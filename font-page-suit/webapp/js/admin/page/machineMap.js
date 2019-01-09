function onApiLoaded() {
	changeTabContentHeight();

	gMap = new AMap.Map('mapContainer', {
		center: [113.049752, 23.109706],
		resizeEnable: true,
		zoom: 6
	});
	gMap.plugin(["AMap.ToolBar"], function() {
		gMap.addControl(new AMap.ToolBar());
	});

	machineInfoWindow = new AMap.InfoWindow({
		isCustom: true, 
		//content: createInfoWindow(title, content.join("<br/>")),
		offset: new AMap.Pixel(16, -45)
	});

	new Vue({
		el: '#mapInfoList',
		data: {
			trs: [],
			requestModel: {
				start: 0,
				pageSize: 10000,
				example: {
					machineStatus: ""
				}
			},
			pageNow: 0
		},
		mounted: function() {
			mapInfoVue = this;
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				self.requestModel.start = start;
				var ajaxRequestModel = DEEP_COPY(self.requestModel);
				ajaxRequestModel.example = checkEmpty(ajaxRequestModel.example);
				axios.post(PAGE_MACHINE_MAP_VIEW_QUERY, ajaxRequestModel).then(function(response) {
					self.trs = response.data.content;
					self.initMap();
					mdui.mutation();
				});
			},
			initMap: function() {
				var self = this;
				initMarkerOnMap(self.trs);
			},
			updateMachineInfo: function() {
				var self = this;
				//updateAllMachineMarker(self.trs);
				self.requestModel.start = 0;
				var ajaxRequestModel = DEEP_COPY(self.requestModel);
				ajaxRequestModel.example = checkEmpty(ajaxRequestModel.example);
				axios.post(PAGE_MACHINE_MAP_VIEW_QUERY, ajaxRequestModel).then(function(response) {
					self.trs = response.data.content;
					updateAllMachineMarker(self.trs);
					mdui.mutation();
				});
			},
			chooseColor: function(tr) {
				return chooseMachineColor(tr.machineStatus);
			}
		},
		watch: {
			"requestModel.example.machineStatus": function(val) {
				this.list(0);
			}
		}
	});
}

function initMarkerOnMap(initData) {
	for (var j = 0, len = initData.length; j < len; j++) {
		addOneMachineMarker(initData[j]);
	}
	gMap.setFitView();
}

function addOneMachineMarker(machineInfo) {
	if (machineInfo.gcjX != null && machineInfo.gcjY != null) {
		var machineNode = new AMap.Text({
			text: '#' + machineInfo.machineCode,
			textAlign: 'center', // 'left' 'right', 'center',
			verticalAlign: 'middle', //middle 、bottom,
			draggable: false,
			cursor: 'pointer',
			angle: 0,
			style: {
				'font-size': '20px',
				'color': 'white',
				'background-color': chooseMachineColor(machineInfo.machineStatus),
				'border': '1px solid #ffffff',
			},
			position: [machineInfo.gcjX, machineInfo.gcjY],
		});
		machineNode.MACHINEINFO=machineInfo;
		machineNode.setMap(gMap);
		//鼠标点击marker弹出自定义的信息窗体
		AMap.event.addListener(machineNode, 'click', function(event) {
			machineInfoWindow.setContent(createInfoWindow(event.target.MACHINEINFO));
			machineInfoWindow.open(gMap, machineNode.getPosition());
		});
		gMapMachines.set(machineInfo.id, machineNode);
	}
}

function updateAllMachineMarker(machineInfos) {
	for (var j = 0, len = machineInfos.length; j < len; j++) {
		var machineNode = gMapMachines.get(machineInfos[j].id);
		if (machineNode == undefined || machineNode == null) {
			addOneMachineMarker(machineInfos[j]);
		} else {
			updateOneMachineMarker(machineInfos[j], machineNode)
		}
	}
	gMap.setFitView();
}

function updateOneMachineMarker(machineInfo, machineNode) {
	if (machineNode) {
		if (machineInfo.gcjX == null || machineInfo.gcjY == null) {
			machineNode.setMap(null);
			gMapMachines.delete(machineInfo.id);
		} else {
			machineNode.MACHINEINFO=machineInfo;
			machineNode.setPosition([machineInfo.gcjX, machineInfo.gcjY]);
			machineNode.setStyle({
				'font-size': '20px',
				'color': 'white',
				'background-color': chooseMachineColor(machineInfo.machineStatus),
				'border': '1px solid #ffffff',
			});
		}
	}
}

//构建自定义信息窗体
function createInfoWindow(machineInfo) {
	var info = document.createElement("div");
	info.style.width = "200px";
	info.className = "mdui-typo custom-info input-card content-window-card";
	
	var content=[];
	if(machineInfo.driverId!=null){
		content.push('机手：'+'<a>#'+machineInfo.driverId+'&nbsp;'+machineInfo.driverName+'</a>');
	}
	if(machineInfo.supportId!=null){
		content.push('后勤：'+'<a>#'+machineInfo.supportId+'&nbsp;'+machineInfo.supportName+'</a>');
	}
	if(machineInfo.machineNameplate!=null){
		content.push('机器铭牌：'+machineInfo.machineNameplate+'&nbsp;');
	}
	content=content.join("<br/>");
	
	var top = document.createElement("div");
	var titleD = document.createElement("div");
	var closeX = document.createElement("img");
	top.className = "info-top";
	titleD.innerHTML = '机器编号：<a>#'+machineInfo.machineCode+'</a>&nbsp;'+'<span style="color:'+chooseMachineColor(machineInfo.machineStatus)+'">'+machineInfo.machineStatus+'中</span>';
	closeX.src = "https://webapi.amap.com/images/close2.gif";
	closeX.onclick = closeInfoWindow;

	top.appendChild(titleD);
	top.appendChild(closeX);
	info.appendChild(top);

	// 定义中部内容
	var middle = document.createElement("div");
	middle.className = "info-middle";
	middle.style.backgroundColor = 'white';
	middle.innerHTML = content;
	info.appendChild(middle);

	// 定义底部内容
	var bottom = document.createElement("div");
	bottom.className = "info-bottom";
	bottom.style.position = 'relative';
	bottom.style.top = '0px';
	bottom.style.margin = '0 auto';
	var sharp = document.createElement("img");
	sharp.src = "https://webapi.amap.com/images/sharp.png";
	bottom.appendChild(sharp);
	info.appendChild(bottom);
	return info;
}

//关闭信息窗体
function closeInfoWindow() {
	gMap.clearInfoWindow();
}
