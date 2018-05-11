<template>
    <header class="nav-header">
        <div class="header-wrap">
            <div class="nav-wrap">
                <a>
                    <i class="iconfont">&#xe663;</i>&nbsp;&nbsp;
                </a >
                <span class="line">|</span>&nbsp;
                <a>
                    <img class="logo" src="pics/logo.png">
                </a>
            </div>
            <div class="explore-wrap">
                <span>
                    <input type="text" align="center" placeholder="搜索" class="input-box">
                </span>
            </div>
            <div class="list-wrap">
                <a><i class="iconfont1">&#xe746;</i></a>
                <a><i class="iconfont2">&#xe623;</i></a>
                <a><i class="iconfont3">&#xe609;</i></a>
            </div>
        </div>
    </header>
</template>

<script>
import { signout } from "@/api/getData";
import { baseImgPath } from "@/config/env";
import { mapActions, mapState } from "vuex";

export default {
  // data() {
  //   return {
  //     images: {
  //       sample: require("../assets/img/avator.png")
  //     }
  //   };
  // },
  // mounted() {
  //   if (!this.adminInfo.loginId) {
  //     this.$message({
  //       type: "error",
  //       message: "请先登录"
  //     });
  //     this.$router.push("/");
  //   }
  // },
  // computed: {
  //   ...mapState(["adminInfo"])
  // },
  // methods: {
  //   ...mapActions(["getAdminData", "clearAdminData"]),
  //   async handleCommand(command) {
  //     if (command == "home") {
  //       this.$router.push("/manage");
  //     } else if (command == "singout") {
  //       const res = await signout();
  //       console.log("logout:" + res.code);
  //       if (res.code == 999) {
  //         this.$message({
  //           type: "success",
  //           message: "退出成功"
  //         });
  //         this.clearAdminData();
  //       } else {
  //         this.$message({
  //           type: "error",
  //           message: res.msg
  //         });
  //       }
  //       this.$router.push("/");
  //     }
  //   }
  // }
};
</script>

<style>
@import "../style/explore.css";
</style>

