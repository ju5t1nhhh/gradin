<template>
  <div style="background-color:ghostwhite;height:100%;">
    <headTop></headTop>
    <div style="position:absolute;top:200px;left:300px;width:60%;height:500px;background-color:white;border:1px solid #dbdbdb;">
      <div style="width:30%;">
        <div class="editiii" style="border-left:3px solid black;font-weight:bold;">编缉主页</div>
        <div class="editiii" >更改密码</div>
        <div class="editiii" >GINS码兑换</div>
      </div>
      <div style="position:absolute;top:0px;right:0px;width:70%;height:100%;border-left:1px solid #dbdbdb;">
        <el-form :model="formData" :rules="rules" ref="formData" label-width="110px" class="demo-formData" style="margin-left:15%">
          <div style="margin:30px 0 20px 20%">
            <div style="display:inline;">
              <img src="../style/pics/instagram/1.jpg" style="width:50px;height:50px;border-radius:100px;">
            </div>
            <div style="display:inline-block;line-height:30px;margin-left:20px;">
              <span>r4j_justin</span>
              <br/>
              <a style="font-size:13px;">编缉头像</a>
            </div>
          </div>
					<el-form-item label="性别" prop="gender">
						<el-input v-model="formData.gender" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item label="微信" prop="wechat">
						<el-input v-model="formData.wechat" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item label="手机号码" prop="phone">
						<el-input v-model="formData.phone" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item label="个人网站" prop="website">
						<el-input v-model="formData.website" style="width:50%;"></el-input>
					</el-form-item>
          <el-form-item label="简单介绍自己" prop="brief">
            <el-input type="textarea" :rows="2" v-model="formData.brief" style="width:50%;resize:none;"></el-input>
					</el-form-item>
        </el-form>
      </div>
    </div>
  </div>    
</template>

<script>
import headTop from "../components/headTop";
export default {
  data() {
    return {
      formData: {
        avatar: '',
        gender: '',
        wechat: '',
        phone: '',
        website: '',
        brief: '',
      },
    };
  },
  components: {
    headTop,
  },
  mounted() {
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
</style>
