<template>
  <div>
    <headTop></headTop>
    <div class="main-box">
        <div class="body-box">
            <div style="position:absolute;top:50px;left:20px;">
                <a style="color:grey;" v-for="item in textList" @click="chooseSection(item,$event)" >{{item}} </a>
            </div>
            <div style="position:absolute;top:50px;right:22px;">
                <a @click="changeSortType" v-bind:style="hotStyle">热度 </a>
                <a @click="changeSortType" v-bind:style="timeStyle">时间 </a>
            </div>
            <div class="explore-new">
                <h2 class="explore-information">
                    探索
                </h2>
                <div class="line-item">
                    <exploreItem :loading="loading" :fphoto="photo1" :likes="10" :comments="30" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo2" :likes="20" :comments="20" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo3" :likes="20" :comments="21" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo4" :likes="10" :comments="22" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo5" :likes="40" :comments="0" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo6" :likes="20" :comments="0" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo7" :likes="10" :comments="30" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo8" :likes="20" :comments="20" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photo9" :likes="10" :comments="10" v-on:click.native="openCover"></exploreItem>
                </div>
            </div>
        </div>
    </div>
    <exploreDetail v-show="cover" @ccclose="closectl"></exploreDetail>
  </div>    
</template>

<script>
import headTop from "../components/headTop";
import exploreItem from "../components/exploreItem";
import exploreDetail from "../components/exploreDetail";
export default {
  data() {
    return {
        photo1: 'http://localhost:8082/1.jpg',
        photo2: 'http://localhost:8082/2.jpg',
        photo3: 'http://localhost:8082/3.jpg',
        photo4: 'http://localhost:8082/4.jpg',
        photo5: 'http://localhost:8082/5.jpg',
        photo6: 'http://localhost:8082/6.jpg',
        photo7: 'http://localhost:8082/7.jpg',
        photo8: 'http://localhost:8082/8.jpg',
        photo9: 'http://localhost:8082/9.jpg',
        hotStyle: {
            color: "black",
            fontWeight: "bold",
        },
        timeStyle: {
            color: "grey",
            fontWeight: "normal",
        },
        index: 0,
        cover: false,
        sort: 1,
        loading: false,
        choSection: [],
        textList: ['摄影版区','体育版区','生活版区'],
        photourl: 'http://www.embeddedlinux.org.cn/uploads/allimg/161125/101RA2C-5.jpg',
	};
  },
  components: {
    headTop,
    exploreItem,
    exploreDetail,
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
      chooseSection(val, event) {
          var el = event.currentTarget
          if ( el.style.color == 'grey' ) {
              el.style.cssText = 'color:black;font-weight:bold;'
              this.choSection.push(val)
          } else {
              el.style.cssText = 'color:grey;font-weight:normal;';   
              var index =this.choSection.findIndex(item => item == val )
              this.choSection.splice(index,1)
          }
          if ( this.index == 0 ) {
              this.index++;
              this.photo1 = 'http://localhost:8082/1.jpg';
              this.photo2 = 'http://localhost:8082/2.jpg';
              this.photo3 = 'http://localhost:8082/3.jpg';
              this.photo4 = 'http://localhost:8082/4.jpg';
              this.photo5 = 'http://localhost:8082/5.jpg';
              this.photo6 = 'http://localhost:8082/6.jpg';
              this.photo7 = 'http://localhost:8082/7.jpg';
              this.photo8 = 'http://localhost:8082/8.jpg';
              this.photo9 = 'http://localhost:8082/9.jpg';
          } else if ( this.index == 1 ) {
              this.index--;
              this.photo1 = 'http://localhost:8082/10.jpg';
              this.photo2 = 'http://localhost:8082/11.jpg';
              this.photo3 = 'http://localhost:8082/12.jpg';
              this.photo4 = 'http://localhost:8082/13.jpg';
              this.photo5 = 'http://localhost:8082/14.jpg';
              this.photo6 = 'http://localhost:8082/15.jpg';
              this.photo7 = 'http://localhost:8082/16.jpg';
              this.photo8 = 'http://localhost:8082/17.jpg';
              this.photo9 = 'http://localhost:8082/18.jpg';
          }
          console.log(this.choSection)
      },
      changeSortType() {
          this.sort = -this.sort;
          var temp = this.hotStyle;
          this.hotStyle = this.timeStyle;
          this.timeStyle = temp;
          var temp = this.photo1;
          this.photo1 = this.photo3;
          this.photo3 = temp;
          var temp = this.photo2;
          this.photo2 = this.photo6;
          this.photo6 = temp;
          var temp = this.photo9;
          this.photo9 = this.photo3;
          this.photo3 = temp;
      },
  },
};
</script>
