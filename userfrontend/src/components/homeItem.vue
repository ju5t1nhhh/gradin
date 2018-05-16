<template>
  <div style="width: 44.5%;height: 930px;position: relative;left: 250px;top:150px;margin-bottom:50px;border: 1px solid gainsboro;background-color: white;">
            <div style="width: 100%;height: 60px;background-color: white;">
                <div style="margin-left:20px">
                    <a><img v-bind:src="avatar" style="width: 30px;height: 30px;border-radius: 25px;position: relative;top:15px;"></a>&nbsp;&nbsp;
                    <a><span style="font-weight:bold;font-size:13px;">{{id}}</span></a>
                </div>
                <div>
                    <img v-bind:src="imgurl" class="elel">
                    <a @click="preimg" style="color:ghostwhite;position:absolute;top:30%;left:5px;font-size:300px;"><span>&nbsp;</span></a>
                    <a @click="neximg" style="color:ghostwhite;position:absolute;top:30%;right:5px;font-size:300px;"><span>&nbsp;</span></a>
                </div>
                <div style="position: relative;width: 600px;height: 80px;top:30px;left: 20px;">
                        <el-rate v-model="rate" :colors="['#99A9BF', '#F7BA2A', '#FF9900']"></el-rate>
                        <p style="line-height: 2.0;font-size: 13px;"><a>{{man}} 人参与评分</a></p>
                        <a v-bind:style="{'font-weight': collect > 0 ? 'bold' : 'normal','color': collect > 0 ? 'black' : 'grey'}" class="collect" @click="collectThis">收藏</a>
                </div>
                <div style="position: relative;left: 20px;">
                    <a style="font-size: 14px;font-weight:bold;">{{id}}</a>&nbsp;&nbsp;
                    <span style="font-size: 13px;">hello everyone</span>
                    <p style="font-size: 14px;color: silver;font-weight: bold;">刚刚</p>
                    <a style="font-size: 14px;color: grey;">加载更多评论</a>
                    <ul style="list-style: none;">
                        <commentItem v-for="cmt in comments" :cmtuser="cmt.user" :cmttext="cmt.text"></commentItem>
                    </ul>
                </div>
                <div style="position: relative;left: 20px;top:20px;width: 560px;height: 50px;border-top: lavender 1px solid;">
                    <input style="border: none;font-size: 14px;resize:none;width:100%" rows="2" placeholder="添加评论..."></input>
                </div>
            </div>
        </div>
</template>

<script>
import commentItem from "../components/commentItem"
export default {
  props: ['id','postid','items','comments','avatar'],
  components: {
      commentItem,
  },
  data() {
      return {          
          man: 0,
          rate: 0,
          collect: 0,
          index: 0,
          imgurl: '',
      }
  },
  watch: {
      rate: function ( val ) {
          this.man = 1;
      }
  },
  mounted() {
      this.imgurl = this.items[0];
  },
  methods: {
      collectThis() {
          this.collect = this.collect > 0 ? 0 : 1;
      },
      preimg() {
          if ( this.index != 0 ) {
              this.index--;
              this.imgurl = this.items[this.index];
          }
      },
      neximg() {
          if( this.index != this.items.length - 1 ) {
              this.index++;
              this.imgurl = this.items[this.index];
          }
      },
  }
}
</script>

<style>
.collect{
    position:absolute;
    top:0px;
    right:5%;
    line-height: 2.0;
    font-size: 13px;
    color:grey;
}
.elel{
    width: 100%;
    height: 600px;
    position: relative;
    top:25px;
    border-radius: 0;
}
</style>
