<template>
    <div>
        <headTop></headTop>
        <div style="background-color: ghostwhite;width: 100%;height: 2200px">
            <!--文字部分-->
            <div style="width: 70%;height: 60px;position: relative;top:100px;left: 18%">
                <h2>#{{tag}}</h2><br>
                <span>共 7 作品</span>
            </div>
            <!--帖子部分-->
            <div style="width: 70%;height: 1200px;position: relative;top:470px;left: 15%;margin-top: 30px;">
                <div class="line-item">
                    <exploreItem :loading="loading" :fphoto="'http://localhost:8082/aa.jpg'" :likes="0" :comments="2" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="'http://localhost:8082/aaa.jpg'" :likes="1" :comments="3" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="'http://localhost:8082/aaaa.jpg'" :likes="3" :comments="2" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="'http://localhost:8082/aaaaa.jpg'" :likes="4" :comments="1" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="'http://localhost:8082/aaaaaa.jpg'" :likes="1" :comments="4" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="'http://localhost:8082/aaaaaaa.jpg'" :likes="0" :comments="3" v-on:click.native="openCover"></exploreItem>
                    <exploreItem :loading="loading" :fphoto="'http://localhost:8082/a.jpg'" :likes="2" :comments="2" v-on:click.native="openCover"></exploreItem>
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

