<template>
  <div style="background-color:ghostwhite;height:100%;">
    <headTop></headTop>
    <div style="position:absolute;top:120px;left:300px;width:60%;height:480px;background-color:white;border:1px solid #dbdbdb;">
      <div style="width:30%;">
        <div class="editiii" v-bind:style="aobject" @click="changeA"><a>编缉主页</a></div>
        <div class="editiii" v-bind:style="bobject" @click="changeB"><a>更改密码</a></div>
        <div class="editiii" v-bind:style="cobject" @click="changeC"><a>GINS码兑换</a></div>
        <div class="editiii" v-bind:style="dobject" @click="changeD"><a>退出登录</a></div>
      </div>
      <div style="position:absolute;top:0px;right:0px;width:70%;height:100%;border-left:1px solid #dbdbdb;" v-if="aobject!=null">
        <el-form :model="formData" ref="formData" label-width="110px" class="demo-formData" style="margin-left:15%">
          <div style="margin:30px 0 20px 20%">
            <div style="display:inline;">
              <img v-bind:src="formData.avatar" style="width:50px;height:50px;border-radius:100px;">
            </div>
            <div style="display:inline-block;line-height:30px;margin-left:20px;">
              <span>r4j_justin</span>
              <br/>
              <a style="font-size:13px;" class="hiput">编缉头像</a>
            </div>
          </div>
					<el-form-item class="hiput" label="性别" prop="gender">
						<el-input v-model="formData.gender" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item class="hiput" label="微信" prop="wechat">
						<el-input v-model="formData.wechat" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item class="hiput" label="手机号码" prop="phone">
						<el-input v-model="formData.phone" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item class="hiput" label="个人网站" prop="website">
						<el-input v-model="formData.website" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item class="hiput" label="简单介绍自己" prop="brief">
            <el-input type="textarea" :rows="2" v-model="formData.brief" style="width:50%;resize:none;"></el-input>
					</el-form-item>
          <el-button style="margin-left:27%;width:150px">提交</el-button>
        </el-form>
      </div>
      <div style="position:absolute;top:0px;right:0px;width:70%;height:100%;border-left:1px solid #dbdbdb;" v-if="bobject!=null">
        <el-form :model="formData2" ref="formData2" label-width="110px" class="demo-formData" style="margin-left:15%;margin-top:10%;">
					<el-form-item class="hiput" label="原密码" prop="oldPwd">
						<el-input v-model="formData2.oldPwd" type="password" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item class="hiput" label="新密码" prop="newPwd">
						<el-input v-model="formData2.newPwd" type="password" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item class="hiput" label="再次输入新密码" prop="rnewPwd">
						<el-input v-model="formData2.rnewPwd" type="password" style="width:50%;"></el-input>
					</el-form-item>
          <el-button style="margin-left:26%;width:150px" @click="modpwd">更改密码</el-button>
        </el-form>
      </div>
      <div style="position:absolute;top:0px;right:0px;width:70%;height:100%;border-left:1px solid #dbdbdb;" v-if="cobject!=null">
        <el-form :model="formData3" ref="formData3" label-width="110px" class="demo-formData" style="margin-left:15%;margin-top:10%;">
					<el-form-item class="hiput" label="GINS码" prop="ginscode">
						<el-input v-model="formData3.ginscode" style="width:50%;" placeholder="关注Gradin仔获GINS码"></el-input>
					</el-form-item>
          <el-button style="margin-left:26%;width:150px" @click="chaCode">提交</el-button>
        </el-form>
      </div>
      <div style="position:absolute;top:0px;right:0px;width:70%;height:100%;border-left:1px solid #dbdbdb;" v-if="dobject!=null">
        <el-form :model="formData4" :rules="rules" label-width="110px" class="demo-formData" style="margin-left:15%;margin-top:10%;">
          <el-button style="margin-left:26%;width:150px" @click="getout">确认退出</el-button>
        </el-form>
      </div>
    </div>
  </div>    
</template>

<script>
import headTop from "../components/headTop";
import {getMyInfo,getMyDetail,changePwd,chargeCode,signout} from "@/api/getData"
export default {
  data() {
    return {
      oobject: {
        borderLeft: '3px solid black',
        fontWeight: 'bold'
      },
      aobject: null,
      bobject: null,
      cobject: null,
      dobject: null,
      formData: {
        avatar: '',
        gender: '',
        wechat: '',
        phone: '',
        website: '',
        brief: '',
      },
      formData2: {
        oldPwd: '',
        newPwd: '',
        rnewPwd: '',
      },
      formData3: {
        ginscode: '',
      }
    };
  },
  components: {
    headTop,
  },
  mounted() {
    this.aobject = this.oobject;
    getMyDetail().then(res=>{
      if ( res.code == 200 ) {
        var data = res.data;
        console.log(data)
        this.formData.avatar = data.avatar;
        this.formData.gender = data.gender;
        this.formData.wechat = data.wechat;
        this.formData.phone = data.phone;
        this.formData.website = data.website;
        this.formData.brief = data.brief;
      }
    });
  },
  methods: {
    getout(){
      signout().then(res=>{
        // if( res.code == 999 ) {
          this.$router.push("/login")
        // } else {

        // }
      });
    },
    chaCode(){
      chargeCode(this.formData3.ginscode).then(res=>{
        if ( res.code == 200 ) {
          this.$message({
            type: 'success',
            message: '兑换成功',
          });
        } else {
          this.$message({
            type: 'error',
            message: res.msg,
          });
        }
      });
    },
    modpwd() {
      if ( this.formData2.newPwd != this.formData2.rnewPwd ) {
        this.$message({
          type: 'error',
          message: '两次新密码不一致',
        });
        return false;
      }
      changePwd(this.formData2).then(res=>{
        if ( res.code == 200 ) {
          this.$message({
            type: 'success',
            message: '修改密码成功',
          });
        } else {
          this.$message({
            type: 'error',
            message: res.msg,
          });
        }
      });
    },
    changeA() {
      this.aobject = this.oobject;
      this.bobject = null;
      this.cobject = null;
      this.dobject = null;
    },
    changeB() {
      this.aobject = null;
      this.bobject = this.oobject;
      this.cobject = null;
      this.dobject = null;
    },
    changeC() {
      this.aobject = null;
      this.bobject = null;
      this.cobject = this.oobject;
      this.dobject = null;
    },
    changeD() {
      this.aobject = null;
      this.bobject = null;
      this.cobject = null;
      this.dobject = this.oobject;
    }
  }
};
</script>

<style>
.editiii{
  height:60px;
  width:300px;
  line-height:60px;
  padding-left:30px;
}
.hiput{
  font-weight: bold;
}
</style>
