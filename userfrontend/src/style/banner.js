function slideImg() {
    var index = 0;
    var timer = null;
    var pics = document.getElementsByClassName("banner-slide");
    var len = pics.length;
    /*间歇调用*/
    timer = setInterval(function () {
        index++;
        if (index >= len) {
            index = 0;
        }
        //切换图片
        changeImg(index, pics);
    }, 3000);
}
function changeImg(index, pics) {
    var temp = index == 0 ? 3 : index - 1;
    if ( pics[index] != null ) pics[index].classList.toggle("slide-active");
    if ( pics[temp] != null ) pics[temp].classList.toggle("slide-active");
}
export {
    slideImg
}