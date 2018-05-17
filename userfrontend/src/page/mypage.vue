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
              <span style="font-weight:bold;">6</span>贴子
              <span style="font-weight:bold;">3</span><a @click="focuscover=true">关注者</a>
              <span style="font-weight:bold;">3</span><a @click="folincover=true">正在关注</a>
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
                      <exploreItem :loading="loading" :fphoto="photo1" :likes="0" :comments="3" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photo2" :likes="1" :comments="2" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photo3" :likes="0" :comments="1" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photo4" :likes="1" :comments="0" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photo5" :likes="0" :comments="2" v-on:click.native="openCover"></exploreItem>
                      <exploreItem :loading="loading" :fphoto="photo6" :likes="0" :comments="1" v-on:click.native="openCover"></exploreItem>
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
      photo1: 'http://localhost:8082/1526447096674.jpg',
      photo2: 'http://localhost:8082/bb.jpg',
      photo3: 'http://localhost:8082/bbb.jpg',
      photo4: 'http://localhost:8082/bbbb.jpg',
      photo5: 'http://localhost:8082/bbbbb.jpg',
      photo6: 'http://localhost:8082/bbbbbb.jpg',
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
  mounted() {
  },
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
      if ( this.cho != 0 ) {
        this.photo1 = 'http://localhost:8082/cc.jpg';
        this.photo2 = 'http://localhost:8082/ccc.jpg';
        this.photo3 = 'http://localhost:8082/cccc.jpg';
        this.photo4 = 'http://localhost:8082/ccccc.jpg';
        this.photo5 = 'http://localhost:8082/cccccc.jpg';
        this.photo6 = 'http://localhost:8082/ccccccc.jpg';
      } else {
        this.photo1 = 'http://localhost:8082/1526447096674.jpg';
        this.photo2 = 'http://localhost:8082/bb.jpg';
        this.photo3 = 'http://localhost:8082/bbb.jpg';
        this.photo4 = 'http://localhost:8082/bbbb.jpg';
        this.photo5 = 'http://localhost:8082/bbbbb.jpg';
        this.photo6 = 'http://localhost:8082/bbbbbb.jpg';
      }
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