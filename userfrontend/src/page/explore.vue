<template>
  <div>
    <headTop></headTop>
    <div class="main-box">
        <div class="body-box">
            <div style="position:absolute;top:50px;left:20px;">
                <a style="color:grey;" v-for="item in textList" @click="chooseSection(item,$event)" >{{item}} </a>
            </div>
            <div style="position:absolute;top:50px;right:22px;">
                <a @click="changeSortType" v-bind:style="{'color':sortType == 'hot' ? 'black' : 'grey', 'font-weight':sortType == 'hot' ? 'bold' : 'normal'}">热度 </a>
                <a @click="changeSortType" v-bind:style="{'color':sortType == 'hot' ? 'grey' : 'black', 'font-weight':sortType == 'hot' ? 'normal' : 'bold'}">时间 </a>
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
    <div class="cover" id="cover" v-bind:style="{display: phk}">
        <div class="close" id="close" @click="closeCover">×</div>
    </div>
    <div class="show-details" v-bind:style="{display: phk}">
        <div class="show-pics">
            <img src="pics/Instagram/1.jpg">
        </div>
        <div class="comment">
            <div class="user-infor">
                <div class="user-head">
                    <a><img src="pics/2.jpg"></a>&nbsp;&nbsp;&nbsp;
                    <span class="u-name"><a>judy123</a></span>&nbsp;&nbsp;&nbsp;
                    <span class="focus">关注</span>&nbsp;&nbsp;&nbsp;
                    <span class="report">举报</span>
                </div>
            </div>
            <div class="comment-message">
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
        <div class="thumbs-up">
            <i class="iconfont7 like">&#xe623;</i>&nbsp;&nbsp;
            <i class="iconfont8 comment">&#xe69b;</i>
            <p><a>6666 次赞</a></p>
            <p>8小时前</p>
        </div>
        <div class="make-comment">
            <textarea class="make-comments" cols="40" rows="4" placeholder="添加评论..."></textarea>
        </div>
    </div>
  </div>    
</template>

<script>
import headTop from "../components/headTop";
import exploreItem from "../components/exploreItem";
export default {
  data() {
    return {
        sortType: 'hot',
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
  },
  mounted() {
  },
  methods: {
      showCover(val) {
          console.log("hello")
          this.phk = val;
      },
      closeCover() {
          this.phk = 'none'
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
          this.sortType = this.sortType == 'hot' ? 'time' : 'hot';
      }
  },
};
</script>