//验证电话号码和邮箱1056004374@qq.com
function my$(id) {
    return document.getElementById(id);
}
my$("phone-num").onblur=function () {
    if(/(^[1][0-9]{10}$)|(^[0-9a-zA-Z_.]+[@][0-9a-zA-Z_.]+([.][a-zA-Z]+){1,2}$)/.test(this.value)){
    //如果是true的话说明手机号或邮箱输入正确 把span隐藏了
        my$("prompt").style.display="none";
        //如果是false 显示span
    }else{
        my$("prompt").style.display="block";
    }
}