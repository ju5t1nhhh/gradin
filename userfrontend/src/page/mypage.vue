<template>
  <div>
    <headTop></headTop>
    <div class="main-body" style="width:100%;height:1600px;background-color:ghostwhite;">
      <div class="box1" style="position:absolute;left:20%;width:80%;height:300px;">
        <div>
          <div class="box1-head" style="position:absolute;top:130px;left:180px;">
            <img style="height:150px;width:150px;border-radius:100px" src="../style/pics/2.jpg">
          </div>
          <div class="box2" style="height:150px;width:400px;position:absolute;left:400px;top:150px;">
            <div>
              <span class="username" style="font-size:30px;font-weight:300">r4j_justin</span>
              <button style="width:120px;height:30px;margin-left:30px;text-align:center;border: 1px solid #dbdbdb;">
                <a @click="toEditMe">
                  <span style="line-height:15px;">我的设置</span>&nbsp;&nbsp;
                  <span style="line-height:15px;" class="iconfont9">&#xe645;</span>
                </a>
              </button>
            </div>
            <div class="box2-2" style="margin: 10px 0 10px 0;">
              <span style="font-weight:bold;">14</span>贴子
              <span style="font-weight:bold;">15</span><a @click="focuscover=true">关注者</a>
              <span style="font-weight:bold;">18</span><a @click="folincover=true">正在关注</a>
            </div>
            <div class="box2-3" style="position:relative;top:10px;">
              <span style="font-weight:bold;">胡斯庭</span>
            </div>
          </div>
        </div>
      </div>
      <div class="main-box" style="position:absolute;left:10%;width:80%;top:330px;height:1200px;">
        <div class="prompt" style="margin-left:11.5%;width:900px;height:60px;text-align:center;border-top:lavender 1px solid;">
          <span class="spanspan" v-bind:style="{'font-weight':cho == 0 ? 'bold': 'normal'}" @click="changeCho"><a>帖子</a></span>&nbsp;&nbsp;&nbsp;
          <span class="spanspan" v-bind:style="{'font-weight':cho != 0 ? 'bold': 'normal'}" @click="changeCho"><a>收藏夹</a></span>
        </div>
        
        <div class="main-box" style="top:30px;height:0px;position:absolute;left:10%;width:80%;">
          <div class="body-box" style="position:absolute;top:-130px;height:0px;">
              <div class="explore-new" style="top:500px">
                  <div class="line-item">
                      <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                  </div>
              </div>
          </div>
        </div></div></div>      
    <exploreDetail v-show="cover" @ccclose="closectl"></exploreDetail>
    <focusList v-show="focuscover" @cclose="closectl2"></focusList>
    <focusList v-show="folincover" @cclose="closectl3"></focusList>
  </div>    
</template>


<script>
import headTop from "../components/headTop";
import exploreItem from "../components/exploreItem";
import exploreDetail from "../components/exploreDetail";
import focusList from "../components/focusList";
export default {
  data() {
    return {
      cho: 0,
      loading: false,
      cover: false,
      focuscover: false,
      folincover: false,
      photourl: "https://i.loli.net/2018/05/13/5af838855b18a.jpg",
    };
  },
  components: {
    headTop,
    exploreItem,
    exploreDetail,
    focusList,
  },
  mounted() {},
  methods: {
    openCover() {
      console.log("hello")
      this.cover = true;
    },
    closectl() {
      this.cover = false;
    },
    closectl2() {
      this.focuscover = false;
    },
    closectl3() {
      this.folincover = false;
    },
    changeCho() {
      this.cho = this.cho == 0 ? 1 : 0;
    },
    toEditMe() {
      this.$router.push("/editMe");
    }
  }
};
</script>

<style>
@font-face {
  font-family: "iconfont"; /* project id 648030 */
  src: url("http://at.alicdn.com/t/font_648030_lvd1jwg28zn6ogvi.eot");
  src: url("http://at.alicdn.com/t/font_648030_lvd1jwg28zn6ogvi.eot?#iefix")
      format("embedded-opentype"),
    url("http://at.alicdn.com/t/font_648030_lvd1jwg28zn6ogvi.woff")
      format("woff"),
    url("http://at.alicdn.com/t/font_648030_lvd1jwg28zn6ogvi.ttf")
      format("truetype"),
    url("http://at.alicdn.com/t/font_648030_lvd1jwg28zn6ogvi.svg#iconfont")
      format("svg");
}
.iconfont9 {
  font-family: iconfont;
  font-style: normal;
  font-size: 20px;
}
.spanspan {
  line-height: 60px;
  font-size: 13px;
}
</style>