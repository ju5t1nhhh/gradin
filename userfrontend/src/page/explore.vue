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
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" @phk="showCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" @phk="showCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" @phk="showCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" @phk="showCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" @phk="showCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" @phk="showCover"></exploreItem>
                </div>
            </div>
        </div>
    </div>
    <exploreDetail :phk="phk"></exploreDetail>
  </div>    
</template>

<script>
import headTop from "../components/headTop";
import exploreItem from "../components/exploreItem";
import exploreDetail from "../components/exploreDetail";
export default {
  data() {
    return {
        hotStyle: {
            color: "black",
            fontWeight: "bold",
        },
        timeStyle: {
            color: "grey",
            fontWeight: "normal",
        },
        sort: 1,
        loading: false,
        choSection: [],
        phk: 'none',
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
      showCover(val) {
          console.log("hello")
          this.phk = val;
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
          console.log(this.choSection)
      },
      changeSortType() {
          this.sort = -this.sort;
          var temp = this.hotStyle;
          this.hotStyle = this.timeStyle;
          this.timeStyle = temp;
      },
  },
};
</script>
