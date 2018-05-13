<template>
    <header class="nav-header">
        <div class="header-wrap">
            <div class="nav-wrap">
                <a>
                    <i class="iconfont">&#xe663;</i>&nbsp;&nbsp;
                </a >
                <span class="line">|</span>&nbsp;
                <a @click="toHome">
                    <img class="logo" src="../style/pics/logo.png">
                </a>
            </div>
            <div class="explore-wrap">
                <span>
                    <input type="text" align="center" placeholder="搜索" class="input-box">
                </span>
            </div>
            <div class="list-wrap">
                <a @click="toExplore"><i class="iconfont1">&#xe746;</i></a>
                <a style="height:70px;"><i class="iconfont2" v-bind:style="{color: heartColor}">&#xe623;</i></a>
                <a @click="myPage" style="height:70px;"><i class="iconfont3">&#xe609;</i></a>
            </div>
        </div>
    </header>
</template>

<script>
import { mapActions, mapState } from "vuex";
import {getMyInfo} from "@/api/getData"
export default {
    data() {
        return{
            heartColor: 'black',
        }
    },
    computed: {
        ...mapState(["myInfo"])
    },
    mounted() {
        getMyInfo().then(res=>{
            if ( res.code == 200 ) {
                this.heartColor = res.data.msgstatus == 0 ? 'black' : 'red';
            }
        });
    },
    methods: {
        ...mapActions(["getMyInfo"]),
        toExplore() {
            this.$router.push("/explore")
        },
        toHome() {
            this.$router.push("/")
        },
        myPage() {
            console.log("mounted:"+this.myInfo);
            if ( !this.myInfo.id ) {
                this.$router.push("/login")
            } else {
                this.$router.push("/mypage")
            }
        }
    }
};
</script>


<style>
@import "../style/explore.css";
</style>