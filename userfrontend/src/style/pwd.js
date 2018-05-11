//构造一个函数 给我一个密码 我返回相应的级别
function getLel(pwd) {
    if( pwd.length < 6 )
        return 0;
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

export{
    getLel
}