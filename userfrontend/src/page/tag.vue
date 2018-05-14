<template>
    <div>
        <headTop></headTop>
        <div style="background-color: ghostwhite;width: 100%;height: 2200px">
            <!--文字部分-->
            <div style="width: 70%;height: 60px;position: relative;top:100px;left: 18%">
                <h2>#{{tag}}</h2><br>
                <span>共16,204,250 帖子</span>
            </div>
            <!--帖子部分-->
            <div style="width: 70%;height: 1200px;position: relative;top:470px;left: 15%;margin-top: 30px;">
                <div class="line-item">
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="photourl" :likes="100" :comments="200" v-on:click.native="openCover"></exploreItem>
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
            tag: '',
            loading: false,
            cover: false,
            photourl: "http://www.embeddedlinux.org.cn/uploads/allimg/161125/101RA2C-5.jpg"
        }
    },
    components: {
        headTop,
        exploreItem,
        exploreDetail,
    }, 
    created() {
        this.tag = this.$route.params[0];
    },
    methods: {
        openCover() {
          console.log("hello")
          this.cover = true;
        },
        closectl() {
            this.cover = false;
        },
    }
}
</script>

