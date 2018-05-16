<template>
    <div class="header_container">
		<el-breadcrumb separator="/">
			<el-breadcrumb-item :to="{ path: '/manage' }">首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in $route.meta" key="index">{{item}}</el-breadcrumb-item>
		</el-breadcrumb>
		<el-dropdown @command="handleCommand" menu-align='start' style="position:absolute;right:140px;">
				<img :src="images.sample" class="avator">
			<el-dropdown-menu slot="dropdown">
				<el-dropdown-item command="home">首页</el-dropdown-item>
				<el-dropdown-item command="singout">退出</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
		<div style="margin-right:10px;">
			<el-tag type="warning">{{adminInfo.loginId}}</el-tag>
			<el-tag>{{adminInfo.rolename}}{{user.loginId}}</el-tag>
		</div>
    </div>
</template>

<script>
import { signout,getAdminInfo } from "@/api/getData";
import { baseImgPath } from "@/config/env";
import { mapState, mapActions } from "vuex";
import {USER_SIGNOUT} from "../store/user";

export default {
  data() {
    return {
      adminInfo : null,
      images: {
        sample: require("../assets/img/avator.png")
      }
    };
  },
  computed: {
    ...mapState({user: state => state.user}),
  },
  mounted() {
    getAdminInfo().then(res=>{
      if( res.code == 200 )
        this.adminInfo = res.data;
    });
  },
  methods: {
    ...mapActions([USER_SIGNOUT]),
    handleCommand(command) {
      if (command == "home") {
        this.$router.push("/manage");
      } else if (command == "singout") {
        signout().then(res=>{
          console.log("logout:"+res)
          if (res.code == 999) {
            this.USER_SIGNOUT()
            this.$message({
              type: "success",
              message: "退出成功"
            });
            this.$router.push("/");
          } else {
            this.$message({
              type: "error",
              message: res.msg
            });
          }
        });
      }
    }
  }
};
</script>

<style lang="less">
@import "../style/mixin";
.header_container {
  background-color: #eff2f7;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-left: 20px;
}
.avator {
  .wh(36px, 36px);
  border-radius: 50%;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
