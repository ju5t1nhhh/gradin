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
                </div>
            </div>
            <div>
                <ul style="list-style: none;position: relative;right:0px;bottom:40%;">
                    <li>
                        <a style="font-size: 14px;font-weight:bold">judy123</a>&nbsp;&nbsp;
                        <span style="font-size: 13px;">hello everyone</span>
                    </li>
                    <li style="color: silver;font-size: 15px;">
                        <a style="font-size: 14px;color: grey;">加载更多评论</a>
                    </li>
                    <commentItem v-for="cmt in comments" :cmtuser="cmt.user" :cmttext="cmt.text"></commentItem>
                </ul>
                <p style="font-size: 14px;color: silver;font-weight: bold;position: relative;left: 20px;">6小时前</p>
            </div>
        </div>
        <div style="position: relative;width: 600px;height: 80px;top:30px;left: 20px;">
                <el-rate v-model="rate" :colors="['#99A9BF', '#F7BA2A', '#FF9900']"></el-rate>
                <p style="line-height: 2.0;font-size: 13px;"><a>6666 人参与评分</a></p>
                <a v-bind:style="{'font-weight': collect > 0 ? 'bold' : 'normal','color': collect > 0 ? 'black' : 'grey'}" class="collect" @click="collectThis">收藏</a>
        </div>
        <div style="position: relative;left: 20px;top:20px;width: 560px;height: 50px;border-top: lavender 1px solid;">
            <input style="border: none;font-size: 14px;resize:none;width:100%" rows="2" placeholder="添加评论..."></input>
        </div>
        <div class="make-comment" style="margin-left:10%;top:480px">
            <input class="make-comments" cols="40" rows="2" style="resize:none;" placeholder="添加评论..."></input>
        </div>
    </div>
  </div>
</template>

<script>
import commentItem from "../components/commentItem"
export default {
  props: ['phk'],
  components: {
      commentItem,
  },
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

