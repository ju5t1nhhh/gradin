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
                  <input type="text" placeholder="ID、邮箱" v-model="lid">
                  <span id="prompt">{{lidmsg}}</span>
              </div>
              <div class="in2">
                  <input type="password" placeholder="密码" v-model="lpwd">
                  <span id="prompt">{{lpwdmsg}}</span>
              </div>
              <button @click="glogin">登录</button>
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
                <input type="text" placeholder="ID" id="loginId" v-model="rid">
                <span id="prompt">{{idmsg}}</span>
            </div>
            <div class="in2">
                <input type="text" placeholder="邮箱" v-model="remail">
                <span id="prompt">{{emailmsg}}</span>
            </div>
            <div class="in4" v-bind:style="{ 'margin-bottom' : in4px + 'px', 'height' :  '60px'}">
                <input type="password" placeholder="密码 不少于6位" id="pwd" maxlength="16" v-model="rpwd">
                <span id="prompt">{{pwdmsg}}</span>
                    <div class="pwd-strength" id="pwd-strength" v-if="pwdstrength">
                        <em class="font">密码强度</em>
                        <div id="strength-level" v-bind:class="strlvl"></div>
                    </div>
            </div>
            <button @click="check">注册</button>
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
import {checkId,checkEmail,register,login} from '@/api/getData'
import { mapActions, mapState } from "vuex";
export default {
    data(){
        return{
            lid: '',
            lpwd: '',
            lidmsg: '',
            lpwdmsg: '',
            in4px: 0,
            in4px2: 50,
            idmsg:'',
            emailmsg:'',
            pwdmsg: '',
            rid:'',
            remail:'',
            remailcode:'',
            rpwd: '',
            strlvl: 'strength-level0',
            pwdstrength: false,
            showbox: true,
        }
    },
    computed: {
        ...mapState(["myInfo"])
    },
    watch: {
        myInfo: function (val) {
            if (val.id) {
                this.$router.push("")
            }
        },
        lid: function (val) {
            this.lidmsg = ''
        },
        lpwd: function (val) {
            this.lpwdmsg = ''
        },
        rid: function (val) {
            if ( val == '' ) {
                this.idmsg = 'ID不能空'
            } else {
                this.idmsg = ''
            }
        },
        rpwd: function (val) {
            this.pwdmsg = '';
            if ( val == '' ) {
                this.pwdstrength=false;
                this.in4px=0;
                this.in4px2=40;
            } else {
                this.pwdstrength=true;
                this.in4px=10;
                this.in4px2=60;
            }
            var level = getLel(val);
            this.strlvl = 'strength-level'+level;
        },
        remail: function (val) {
            if ( val == '' ) {
                this.emailmsg = '邮箱不能为空';
                return false;
            }
            var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
            if( myreg.test(val) ) {
                this.emailmsg = ''
            } else {
                this.emailmsg = '邮箱格式错误'
            }
        }
    },
    mounted() {
        slideImg();
        if ( this.myInfo.id ) {
            this.$router.push("/")
        }
    },
    methods: {
        ...mapActions(["getMyData"]),
        glogin(){
            if ( this.lid == '' ) {
                this.lidmsg = '请输入ID或邮箱'
                return false
            }
            if ( this.lpwd == '' ) {
                this.lpwdmsg = '请输入密码'
                return false
            }
            login({id:this.lid,password:this.lpwd}).then(res=>{
                if ( res.code == 200 ) {
                    console.log(res.msg)
                    this.getMyData()
                    this.$router.replace("/")
                } else {
                    this.lpwdmsg = '密码错误'
                    console.log(res.msg)
                }
            });
        },
        changeShowbox(){
            this.showbox = !this.showbox;
        },
        check(){
            if ( this.rid == '' ) {
                this.idmsg = 'ID不能空'
                return false
            }
            if ( this.remail == '' ) {
                this.emailmsg = '邮箱不能空'
                return false
            }
            checkId(this.rid).then(res=>{
                if ( res.code == 200 ) {
                    this.idmsg = 'ID ok'
                } else {
                    this.idmsg = res.msg
                    return false
                }
            });
            checkEmail({email:this.remail}).then(res=>{
                if ( res.code == 200 ) {
                    this.emailmsg = 'Email ok'
                } else {
                    this.emailmsg = res.msg
                    return false
                }
            });
            if ( this.rpwd.length < 6 ) {
                this.pwdmsg = '密码须多于6位'
                return false
            }
            register({id:this.rid,pwd:this.rpwd,email:this.remail}).then(res=>{
                if ( res.code == 200 ) {
                    console.log("注册成功")
                    this.$router.push("/")
                } else {
                    console.log(res.msg)
                }
            });
        },
    }
}
</script>

<style scoped>
@import "../style/register.css";
</style>