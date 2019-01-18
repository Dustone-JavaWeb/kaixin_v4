const SYS_LOGIN="login";
const SYS_HOME="admin";
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