<template>
  <div>
      <div class="cover" id="cover" style="display:block;" @click="closeCover">
        <div class="close" id="close" style="margin: 10px 20px 0 0" @click="closeCover">×</div>
    </div>
    <div class="show-details" style="display:block;">
        <div class="show-pics">
            <img style="width:550px;height:550px" src="../style/pics/instagram/1.jpg">
        </div>
        <div class="comment">
            <div class="user-infor" style="margin-left:10%;width:340px;">
                <div class="user-head">
                    <a><img src="../style/pics/2.jpg"></a>&nbsp;&nbsp;&nbsp;
                    <span class="u-name"><a>r4j_justin</a></span>&nbsp;&nbsp;&nbsp;
                    <span class="focus">关注</span>&nbsp;&nbsp;&nbsp;
                    <a v-bind:style="{'font-weight': collect > 0 ? 'bold' : 'normal','color': collect > 0 ? 'black' : 'grey'}" class="focus" @click="collectThis">收藏</a>
                </div>
            </div>
            <div style="position:absolute;top:85px;left:550px;margin-left:10px">
                <a style="font-size: 14px;font-weight:bold">judy123</a>&nbsp;&nbsp;
                <span style="font-size: 13px;">hello everyone</span>
                <br/>
                <p style="font-size: 14px;color: silver;font-weight: bold;position: relative;">刚刚</p>
                <a style="font-size: 14px;color: grey;">加载更多评论</a>
                <ul style="list-style: none;overflow:auto;height:300px;">
                    <commentItem v-for="cmt in comments" :cmtuser="cmt.user" :cmttext="cmt.text"></commentItem>
                </ul>
            </div>
        </div>
        <div style="position:absolute;width: 600px;height: 80px;bottom:30px;left: 560px;">
                <el-rate v-model="rate" :colors="['#99A9BF', '#F7BA2A', '#FF9900']"></el-rate>
                <p style="line-height: 2.0;font-size: 13px;"><a>6666 人参与评分</a></p>
        </div>
        <div style="position: absolute;left: 560px;bottom:0px;width: 300px;height: 50px;border-top: lavender 1px solid;">
            <input style="border: none;font-size: 14px;resize:none;width:100%" placeholder="添加评论..."></input>
        </div>
    </div>
  </div>
</template>

<script>
import commentItem from "../components/commentItem"
export default {
  components: {
      commentItem,
  },
  data() {
      return {
          comments: [
              {user:'justin123',text:'cool啊'},
              {user:'banana123',text:'ya蕉啦'},
              {user:'justin123',text:'@banana123 你ya'},
          ],
          collect: 0,
          rate: 0,
      }
  },
  methods: {
      closeCover() {
          this.$emit('ccclose')
      },
      collectThis() {          
          this.collect = this.collect > 0 ? 0 : 1
      }
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

