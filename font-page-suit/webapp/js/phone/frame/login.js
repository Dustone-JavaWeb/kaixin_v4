const BASE_URL="http://192.168.3.34:8080/kaixin/";
const SYS_LOGIN=BASE_URL+"login";
const SYS_HOME=BASE_URL+"admin";
$(function(){
    new Vue({
        el: '#systemLogin',
        data: {
            sysUser:{}
        },
        mounted: function() {

        },
        methods: {
            login:function () {
				alert();
                var self=this;
                axios.post(SYS_LOGIN, self.sysUser).then(function(response) {
                    if(response.data.code=="200"){
                        window.location.href = SYS_HOME;
                    }else{
                        mdui.snackbar({
                            message: response.data.msg,
                            timeout: 3000,
                            position: "bottom",
                        });
                    }
                });
            }
        }
    });
});