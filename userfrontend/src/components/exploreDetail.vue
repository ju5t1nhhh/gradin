<template>
  <div>
      <div class="cover" id="cover" v-bind:style="{display: phk}" @click="closeCover">
        <div class="close" id="close" style="margin: 10px 20px 0 0" @click="closeCover">×</div>
    </div>
    <div class="show-details" v-bind:style="{display: phk}">
        <div class="show-pics">
            <img style="width:550px;height:550px" src="../style/pics/instagram/1.jpg">
        </div>
        <div class="comment">
            <div class="user-infor" style="margin-left:10%;">
                <div class="user-head">
                    <a><img src="../style/pics/2.jpg"></a>&nbsp;&nbsp;&nbsp;
                    <span class="u-name"><a>judy123</a></span>&nbsp;&nbsp;&nbsp;
                    <span class="focus">关注</span>&nbsp;&nbsp;&nbsp;
                    <span class="report">举报</span>
                </div>
            </div>
            <div class="comment-message" style="margin-left:10%;height:300px">
                <ul>
                    <li>
                        <a>judy123</a>&nbsp;&nbsp;
                        <span>我是猪娣</span>
                    </li>
                    <li class="more">
                        <a>全部25条评论</a>
                    </li>
                    <li>
                        <a>justin123</a>&nbsp;&nbsp;
                        <span>justin好帅啊</span>
                    </li>
                    <li>
                        <a>banana123</a>&nbsp;&nbsp;
                        <span>我喜欢吃香蕉</span>
                    </li>

                </ul>
            </div>
        </div>
        <div class="thumbs-up" style="margin-left:10%;top:400px;">
            <i class="iconfont7 like">&#xe623;</i>&nbsp;&nbsp;
            <i class="iconfont8 comment">&#xe69b;</i>
            <p><a>6666 次赞</a></p>
            <p>8小时前</p>
        </div>
        <div class="make-comment" style="margin-left:10%;top:480px">
            <input class="make-comments" cols="40" rows="2" style="resize:none;" placeholder="添加评论..."></input>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['phk'],
  methods: {
      closeCover() {
          this.phk = 'none'
      },
  }
}
</script>

<style>
.show-details{
    width:67%;
    height: 550px;
    margin-left:-3%;
    margin-top:20px;
}
</style>

