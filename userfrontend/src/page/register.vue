<template>
    <div class="box">
    <div class="box1">
        <div class="banner" id="banner">
            <!--哪一个显示就给哪一个加一个active的类-->
            <div class="banner-slide slide1 slide-active"></div>
            <div class="banner-slide slide2"></div>
            <div class="banner-slide slide3"></div>
            <div class="banner-slide slide4"></div>
        </div>
    </div>
    <div class="box2" v-if="showbox">
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
                  没有账户？<a href="#" @click="changeShowbox">注册</a>
              </span>
          </div>
      </div>
    <div class="box2" v-else>
        <div class="table1">
            <div class="logo"></div>
            <div class="in1">
                <input type="text" placeholder="手机号或邮箱" id="phone-num">
                <span id="prompt">手机号/邮箱输入错误</span>
            </div>
            <div class="in2">
                <input type="text" placeholder="全名">
            </div>
            <div class="in3">
                <input type="text" placeholder="账号">
            </div>
            <div class="in4">
                <input type="password" placeholder="密码 不少于6位" id="pwd" maxlength="16" v-model="rpwd">
                    <div class="pwd-strength" id="pwd-strength" style="display:block;" v-if="pwdstrength">
                        <em class="font">密码强度</em>
                        <div id="strength-level" v-bind:class="strlvl"></div>
                    </div>
            </div>
            <button>注册</button>
        </div>
        <div class="table2">
            <span>
                有账户了？<a href="#" @click="changeShowbox">请登录</a>
            </span>
        </div>
    </div>
</div>
</template>

<script>
import {slideImg} from '../style/banner.js'
import {getLel} from '../style/pwd.js'
// import phonenumjs from '../style/phonenum.js'
export default {
    data(){
        return{
            strlvl: 'strength-level0',
            pwdstrength: false,
            showbox: true,
            rpwd: '',
        }
    },
    watch: {
        rpwd: function (val) {
            if ( val == '' )
                this.pwdstrength=false;
            else
                this.pwdstrength=true;
            var level = getLel(val);
            this.strlvl = 'strength-level'+level;
        },
    },
    mounted() {
        slideImg();
    },
    methods: {
        changeShowbox(){
            this.showbox = !this.showbox;
        },
    }
}
</script>


<style>
@import "../style/register.css";
</style>
