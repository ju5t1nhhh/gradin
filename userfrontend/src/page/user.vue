<template>
    <div>
        <headTop></headTop>
        <div class="main-body" style="width:100%;height:1600px;background-color:ghostwhite;">
            <div class="box1" style="position:absolute;left:20%;width:80%;height:300px;">
                <div>
                <div class="box1-head" style="position:absolute;top:130px;left:180px;">
                    <img style="height:150px;width:150px;border-radius:100px" src="https://scontent-hkg3-1.cdninstagram.com/vp/f8f59cab74ba87ed4871805d2b77c1cb/5B97F8C8/t51.2885-19/s150x150/27892221_1966350730297578_2927562134017540096_n.jpg">
                </div>
                <div class="box2" style="height:150px;width:400px;position:absolute;left:400px;top:150px;">
                    <div>
                    <span class="username" style="font-size:30px;font-weight:300">{{userid}}</span>
                    <button style="width:120px;height:30px;margin-left:30px;text-align:center;border: 1px solid #dbdbdb;" @click="ctlFollow">
                        <a>
                        <span style="line-height:15px;">{{status}}</span>&nbsp;&nbsp;
                        </a>
                    </button>
                    </div>
                    <div class="box2-2" style="margin: 10px 0 10px 0;">
                    <span style="font-weight:bold;">6</span>贴子
                    <span style="font-weight:bold;padding-left:20px;">15</span><a @click="focuscover=true">关注者</a>
                    <span style="font-weight:bold;padding-left:20px;">18</span><a @click="folincover=true">正在关注</a>
                    </div>
                    <div class="box2-3" style="position:relative;top:10px;">
                    <span style="font-weight:bold;">AKA Piggy</span>
                    </div>
                </div>
                </div>
            </div>
            <div class="main-box" style="position:absolute;left:10%;width:80%;top:330px;height:1200px;">
                <div class="main-box" style="top:30px;height:0px;position:absolute;left:10%;width:80%;">
                <div class="body-box" style="position:absolute;top:-130px;height:0px;">
                    <div class="explore-new" style="top:500px">
                        <div class="line-item">
                            <exploreItem :loading="loading" :fphoto="'http://localhost:8082/a.jpg'" :likes="10" :comments="2" v-on:click.native="openCover"></exploreItem>
                            <exploreItem :loading="loading" :fphoto="'http://localhost:8082/b.jpg'" :likes="6" :comments="3" v-on:click.native="openCover"></exploreItem>
                            <exploreItem :loading="loading" :fphoto="'http://localhost:8082/c.jpg'" :likes="12" :comments="5" v-on:click.native="openCover"></exploreItem>
                            <exploreItem :loading="loading" :fphoto="'http://localhost:8082/d.jpg'" :likes="10" :comments="2" v-on:click.native="openCover"></exploreItem>
                            <exploreItem :loading="loading" :fphoto="'http://localhost:8082/1.jpg'" :likes="0" :comments="3" v-on:click.native="openCover"></exploreItem>
                            <exploreItem :loading="loading" :fphoto="'http://localhost:8082/5.jpg'" :likes="9" :comments="0" v-on:click.native="openCover"></exploreItem>
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
            status: '关注',
            userid: '',
            loading: false,
            cover: false,
            focuscover: false,
            folincover: false,
            photourl: "http://www.embeddedlinux.org.cn/uploads/allimg/161125/101RA2C-5.jpg"
        }
    },
    components: {
        headTop,
        exploreItem,
        exploreDetail,
        focusList,
    }, 
    created() {
        this.userid = this.$route.params[0];
    },
    methods: {
        ctlFollow() {
            this.status = this.status == '关注' ? '已关注' : '关注'
        },
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
    }
}
</script>

