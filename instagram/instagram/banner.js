var index=0;
var timer=null;
var pics=document.getElementById("banner").getElementsByTagName("div");
var len=pics.length;
function slideImg() {
    /*间歇调用*/
    timer=setInterval(function () {
       index++;
       if(index>=len){
        index=0;
       }
       //切换图片
        changeImg();
    },3000);
}
function changeImg() {
    //遍历banner下所有的div将其隐藏
    for(var i=0;i<len;i++){
        pics[i].style.display='none';
    }
    /*索引跟图片的结合 通过pics这个数组*/
    pics[index].style.display='block';
}
slideImg();