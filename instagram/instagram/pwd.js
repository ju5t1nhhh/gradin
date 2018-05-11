function my$(id) {
    return document.getElementById(id);
}
/*获取密码框的id注册键盘抬起事件*/
my$("pwd").onkeyup=function () {
    //显示密码强度
    my$("pwd-strength").style.display="block";
    //调用构造函数的同时 把把密码的值传给函数 this指的是my$("pwd")
    //得到返回的等级
    //根据等级改变类名 strength-level+0/1/2/3
        my$("strength-level").className="strength-level"+(this.value.length>=6?getLel(this.value):0);/*得加小括号*/
}

//构造一个函数 给我一个密码 我返回相应的级别
function getLel(pwd) {
    var lvl=0;
    if(/[0-9]/.test(pwd)){
      lvl++;
    }
    if(/[a-zA-Z]/.test(pwd)){
        lvl++;
    }
    if (/[^0-9a-zA-Z_]/.test(pwd)){
        lvl++;
    }
    return lvl;
}

