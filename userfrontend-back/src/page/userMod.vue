<template>
    <div>
        <head-top></head-top>
        <el-row style="margin-top: 20px;">
  			<el-col :span="12" :offset="4">
		        <el-form :model="formData" :rules="rules" ref="formData" label-width="110px" class="demo-formData">
                    <el-form-item label="用户自增ID" prop="autoid">
						<el-input v-model="formData.autoid"></el-input>
					</el-form-item>
					<el-form-item label="用户ID" prop="id">
						<el-input v-model="formData.id"></el-input>
					</el-form-item>
                    <el-form-item class="button_submit">
						<el-button @click="getUserData">获取数据</el-button>
					</el-form-item>
                    <el-form-item label="邮箱" prop="email">
						<el-input v-model="formData.email"></el-input>
					</el-form-item>
					<el-form-item label="密码" prop="pwd">
						<el-input v-model="formData.pwd" maxLength="11" type="password"></el-input>
					</el-form-item>
                    <el-form-item label="用户状态" prop="status">
						<el-input v-model.number="formData.status"></el-input>
					</el-form-item>
					<el-form-item label="GINS" prop="gins">
						<el-input v-model.number="formData.gins"></el-input>
					</el-form-item>
					<el-form-item class="button_submit">
						<el-button type="primary" @click="submitForm('formData')">立即修改</el-button>
					</el-form-item>
				</el-form>
  			</el-col>
  		</el-row>
    </div>
</template>

<script>
import headTop from "@/components/headTop";
import { getUser, modUser } from "@/api/getData";
export default {
  data() {
    return {
      formData: {
        autoid: "",
        id: "",
        email: "",
        pwd: "",
        status: "",
        gins: ""
      },
      rules: {
        id: [{ required: true, message: "请输入新用户邮箱", trigger: "blur" }],
        status: [{ type: "number", message: "1表示正常，2表示冻结" }],
        gins: [
          { required: true, message: "请输入用户所拥有的GINS" },
          { type: "number", message: "必须是数字" }
        ]
      }
    };
  },
  components: {
    headTop
  },
  mounted() {},
  methods: {
    getUserData() {
      if (this.formData.autoid === "" && this.formData.id === "") {
        this.$message({
          type: "error",
          message: "自增ID与ID至少输入一项"
        });
        return false;
      }
      var params = {
        autoid: this.formData.autoid,
        id: this.formData.id
      };
      getUser(params).then(res => {
        this.formData.autoid = res.data.autoid;
        this.formData.id = res.data.id;
        this.formData.email = res.data.email;
        this.formData.status = res.data.status;
        this.formData.gins = res.data.gins;
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(async valid => {
        if (this.formData.autoid === "" && this.formData.id === "") {
          this.$message({
            type: "error",
            message: "请先获取数据"
          });
          return false;
        }
        if (valid) {
          try {
            let result = await modUser(this.formData);
            if (result.code == 200) {
              this.$message({
                type: "success",
                message: "修改成功"
              });
              this.formData = {
                loginId: "",
                pwd: "",
                role: ""
              };
            } else {
              this.$message({
                type: "error",
                message: result.msg
              });
            }
            console.log(result);
          } catch (err) {
            console.log(err);
          }
        } else {
          this.$notify.error({
            title: "错误",
            message: "请检查输入是否正确",
            offset: 100
          });
          return false;
        }
      });
    }
  }
};
</script>

<style lang="less">
@import "../style/mixin";
.button_submit {
  text-align: center;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #20a0ff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 120px;
  height: 120px;
  line-height: 120px;
  text-align: center;
}
.avatar {
  width: 120px;
  height: 120px;
  display: block;
}
.el-table .info-row {
  background: #c9e5f5;
}

.el-table .positive-row {
  background: #e2f0e4;
}
</style>
