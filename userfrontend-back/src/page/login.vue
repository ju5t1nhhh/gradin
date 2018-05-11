<template>
  	<!-- <div class="login_page fillcontain">
	  	<transition name="form-fade" mode="in-out">
	  		<section class="form_contianer" v-show="showLogin">
		  		<div class="manage_tip">
		  			<p>Gradin后台管理系统</p>
		  		</div>
		    	<el-form :model="loginForm" :rules="rules" ref="loginForm">
					<el-form-item prop="username">
						<el-input v-model="loginForm.username" placeholder="用户名"><span>dsfsf</span></el-input>
					</el-form-item>
					<el-form-item prop="password">
						<el-input type="password" placeholder="密码" v-model="loginForm.password"></el-input>
					</el-form-item>
					<el-form-item>
				    	<el-button type="primary" @click="submitForm('loginForm')" class="submit_btn">登陆</el-button>
				  	</el-form-item>
				</el-form>
	  		</section>
	  	</transition>
  	</div> -->
    <div class="box">
      <div class="box1">
          <div class="banner" id="banner">
              <div class="banner-slide slide1 slide-active"></div>
              <div class="banner-slide slide2"></div>
              <div class="banner-slide slide3"></div>
              <div class="banner-slide slide4"></div>
          </div>
      </div>
      <div class="box2">
          <div class="table1">
              <div class="logo"></div>
              <div class="in1">
                  <input type="text" placeholder="手机号、账号、邮箱">
              </div>
              <div class="in2">
                  <input type="text" placeholder="密码">
              </div>
              <button>登录</button>
          </div>
          <div class="table2">
              <span>
                  没有账户？<a href="Register.html">注册</a>
              </span>
          </div>
      </div>
    </div>
</template>

<script>
import {slideImg} from '../style/banner.js'
import { login, getAdminInfo } from "@/api/getData";
import { mapActions, mapState } from "vuex";

export default {
  mounted() {
        slideImg();
  },
  // data() {
  //   return {
  //     loginForm: {
  //       username: "",
  //       password: ""
  //     },
  //     rules: {
  //       username: [
  //         { required: true, message: "请输入用户名", trigger: "blur" }
  //       ],
  //       password: [{ required: true, message: "请输入密码", trigger: "blur" }]
  //     },
  //     showLogin: false
  //   };
  // },
  // mounted() {
  //   this.showLogin = true;
  //   if (!this.adminInfo.loginId) {
  //     this.getAdminData();
  //   }
  // },
  // computed: {
  //   ...mapState(["adminInfo"])
  // },
  // methods: {
  //   ...mapActions(["getAdminData"]),
  //   async submitForm(formName) {
  //     this.$refs[formName].validate(async valid => {
  //       if (valid) {
  //         const res = await login({
  //           loginId: this.loginForm.username,
  //           pwd: this.loginForm.password
  //         });
  //         if (res.code == 200) {
  //           this.$message({
  //             type: "success",
  //             message: "登录成功"
  //           });
  //           this.getAdminData();
  //           this.$router.push("manage");
  //         } else {
  //           this.$message({
  //             type: "error",
  //             message: res.msg
  //           });
  //         }
  //       } else {
  //         this.$notify.error({
  //           title: "错误",
  //           message: "请输入正确的用户名密码",
  //           offset: 100
  //         });
  //         return false;
  //       }
  //     });
  //   }
  // },
  // watch: {
  //   adminInfo: function(newValue) {
  //     console.log("newvalue:" + newValue.loginId);
  //     if (newValue.loginId) {
  //       this.$message({
  //         type: "success",
  //         message: "检测到您之前登录过，将自动登录"
  //       });
  //       this.$router.push("manage");
  //     }
  //   }
  // }
};
</script>

<style>
@import "../style/login.css";
</style>