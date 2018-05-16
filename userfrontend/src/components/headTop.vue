<template>
    <header class="nav-header">
        <div class="header-wrap">
            <div class="nav-wrap">
                <a @click="toMakePost">
                    <i class="iconfont">&#xe663;</i>&nbsp;&nbsp;
                </a >
                <span class="line">|</span>&nbsp;
                <a @click="toHome">
                    <img class="logo" src="../style/pics/logo.png">
                </a>
            </div>
            <div class="explore-wrap">
                <el-popover
                    ref="explore"
                    placement="bottom"
                    title=""
                    width="240"
                    trigger="manual"
                    content="">
                    <!-- <el-button slot="reference">click 激活</el-button> -->
                    <div class="explore-list">
                        <searchItem :img="'https://scontent-hkg3-1.cdninstagram.com/vp/f8f59cab74ba87ed4871805d2b77c1cb/5B97F8C8/t51.2885-19/s150x150/27892221_1966350730297578_2927562134017540096_n.jpg'" 
                        :name="'piggy'" :tagcount="0"></searchItem>
                        <searchItem :img="'http://localhost:8082/1.jpg'" 
                        :name="'pigger'" :tagcount="0"></searchItem>
                        <searchItem :img="'https://scontent-hkg3-1.cdninstagram.com/vp/f8f59cab74ba87ed4871805d2b77c1cb/5B97F8C8/t51.2885-19/s150x150/27892221_1966350730297578_2927562134017540096_n.jpg'" 
                        :name="'piggy'" :tagcount="7"></searchItem>
                    </div>
                    <input @blur="closeExplorePop" @focus="isShowExplorePop" slot="reference" v-model="searchVal" type="text" align="center" placeholder="搜索" class="input-box">
                </el-popover>
            </div>
            <div class="list-wrap">
                <a @click="toExplore"><i class="iconfont1">&#xe746;</i></a>
                <el-popover
                    placement="bottom"
                    title=""
                    width="480"
                    trigger="click"
                    content="">
                <!-- <el-button slot="reference">click 激活</el-button> -->
                <div class="pop-list">
                    <ul style="list-style: none;">
                        <li class="pop-item">
                            <div class="pop-avatar">
                                <a href="" >
                                    <img style="height: 100%; width: 100%" src="https://scontent-nrt1-1.cdninstagram.com/vp/5daee8212f8ee191f918db692864f2aa/5B93A04A/t51.2885-19/s150x150/31738523_585891931809314_709610025584164864_n.jpg" alt="">
                                </a>
                            </div>
                            <div class="pop-text">
                                <a href="">justin</a>
                                <span>开始关注你</span>
                                <time>1天</time>
                            </div>
                            <div class="btn-follow"><el-button type="primary" style="padding: 6px 12px;" >关注</el-button></div>
                        </li>
                        <!-- <li class="pop-item">
                            <div class="pop-avatar">
                                <a href="" >
                                    <img style="height: 100%; width: 100%" src="https://scontent-nrt1-1.cdninstagram.com/vp/5daee8212f8ee191f918db692864f2aa/5B93A04A/t51.2885-19/s150x150/31738523_585891931809314_709610025584164864_n.jpg" alt="">
                                </a>
                            </div>
                            <div class="pop-text">
                                <a href="">justin</a>
                                <span>开始关注你</span>
                                <time>1天</time>
                            </div>
                            <div class="btn-follow"><el-button type="primary" style="padding: 6px 12px;" >关注</el-button></div>
                        </li>
                        <li class="pop-item">
                            <div class="pop-avatar">
                                <a href="" >
                                    <img style="height: 100%; width: 100%" src="https://scontent-nrt1-1.cdninstagram.com/vp/5daee8212f8ee191f918db692864f2aa/5B93A04A/t51.2885-19/s150x150/31738523_585891931809314_709610025584164864_n.jpg" alt="">
                                </a>
                            </div>
                            <div class="pop-text">
                                <a href="">justin</a>
                                <span>开始关注你</span>
                                <time>1天</time>
                            </div>
                            <div class="btn-follow"><el-button type="primary" style="padding: 6px 12px;" >关注</el-button></div>
                        </li> -->
                    </ul>
                </div>
                <a style="height:70px;" slot="reference"><i class="iconfont2" v-bind:style="{color: heartColor}">&#xe623;</i></a>
                </el-popover>
                <a @click="myPage" style="height:70px;"><i class="iconfont3">&#xe609;</i></a>
            </div>
        </div>
    </header>
</template>

<script>
import { mapActions, mapState } from "vuex";
import { getMyInfo } from "@/api/getData";
import searchItem from "../components/searchItem"
export default {
  data() {
    return {
      id: "",
      searchVal: "",
      heartColor: "black"
    };
  },
  components: {
      searchItem,
  },
  computed: {
    ...mapState(["myInfo"])
  },
  mounted() {
    getMyInfo().then(res => {
      if (res.code == 200) {
        this.heartColor = res.data.msgstatus == 0 ? "black" : "red";
        this.id = res.data.id;
      }
    });
  },
  methods: {
    ...mapActions(["getMyInfo"]),
    toMakePost() {
        this.$router.push("/makepost");
    },
    toExplore() {
      this.$router.push("/explore");
    },
    toHome() {
      this.$router.push("/");
    },
    myPage() {
      if (!this.id) {
        this.$router.push("/login");
      } else {
        this.$router.push("/mypage");
      }
    },
    isShowExplorePop() {
        if(this.searchVal) {
            this.openExplorePop()
        }
    },
    closeExplorePop() {
        this.$refs['explore'].doClose()
    },
    openExplorePop() {
        this.$refs['explore'].doShow()
    }
  },
  watch: {
      searchVal: function(val) {
          if(!val) {
              this.closeExplorePop()
          } else {
              this.openExplorePop()
              //请求val的搜索内容
          }
      }
  }
};
</script>


<style>
@import "../style/explore.css";
.pop-list {
    overflow-y: auto;
    overflow-x: hidden;
    max-height: 362px;
}
.pop-item {
    position: relative;
    display: flex;
    align-items: center;
    min-height: 40px;
    padding: 12px 10px;
}
.pop-item::after {
    border-bottom: 1px solid #efefef;
    bottom: 0;
    content: '';
    height: 0;
    left: 58px;
    position: absolute;
    right: 12px;
}
.pop-avatar a {
    display: block;
    width: 34px; 
    height: 34px;
    border-radius: 50%;
    overflow: hidden;
}
.pop-text {
    color: #262626;
    display: block;
    -webkit-box-flex: 1;
    -webkit-flex: 1 0 0%;
    -ms-flex: 1 0 0%;
    flex: 1 0 0%;
    line-height: 1.3;
    margin: 0 12px;
    min-width: 0;
    word-wrap: break-word;
}
.pop-text a {
    color: #262626;
    font-weight: 600;
}
.explore-list {
    max-height: 362px;
    overflow-y: auto;
    overflow-x: hidden;
    padding: 0;
}
.explore-item {
    position: relative;
    display: flex;
    align-items: center;
    height: 50px;
    padding: 5px 5px;
}
.explore-item div {
    display: flex;
    /* justify-content: center; */
    margin-right: 0;
    white-space: nowrap;
    width: 100%;
    -webkit-box-orient: horizontal;
    -webkit-flex-direction: row;
    -ms-flex-direction: row;
    flex-direction: row;
}
.explore-item div img {
    border: solid 1px #efefef;
    border-radius: 30px;
    display: block;
    -webkit-box-flex: 0;
    -webkit-flex: 0 0 auto;
    -ms-flex: 0 0 auto;
    flex: 0 0 auto;
    height: 30px;
    margin: 0 10px 0 0;
    width: 30px;
}
.explore-item div div {
    display: flex;
    flex-direction: column; 
    align-items: 
}
</style>