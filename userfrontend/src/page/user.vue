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
                        <span style="line-height:15px;">已关注</span>&nbsp;&nbsp;
                        </a>
                    </button>
                    </div>
                    <div class="box2-2" style="margin: 10px 0 10px 0;">
                    <span style="font-weight:bold;">14</span>贴子
                    <span style="font-weight:bold;padding-left:20px;">15</span><a>关注者</a>
                    <span style="font-weight:bold;padding-left:20px;">18</span><a>正在关注</a>
                    </div>
                    <div class="box2-3" style="position:relative;top:10px;">
                    <span style="font-weight:bold;">alksjdlkajsdlkjalskdj</span>
                    </div>
                </div>
                </div>
            </div>
            <div class="main-box" style="position:absolute;left:10%;width:80%;top:330px;height:1200px;">
                <div class="main-box" style="top:30px;height:0px;position:absolute;left:10%;width:80%;">
                <div class="body-box" style="position:absolute;top:-130px;height:0px;">
                    <div class="explore-new" style="top:500px">
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
                </div></div></div>
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
            userid: '',
            loading: false,
            phk: "none",
            photourl: "http://www.embeddedlinux.org.cn/uploads/allimg/161125/101RA2C-5.jpg"
        }
    },
    components: {
        headTop,
        exploreItem,
        exploreDetail,
    }, 
    created() {
        this.userid = this.$route.params[0];
    },
    methods: {
        showCover(val) {
            console.log("hello");
            this.phk = val;
        },
    }
}
</script>

