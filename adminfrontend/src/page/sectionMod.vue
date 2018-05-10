<template>
    <div>
        <head-top></head-top>
        <el-row style="margin-top: 20px;">
  			<el-col :span="12" :offset="4">
		        <el-form :model="formData" :rules="rules" ref="formData" label-width="110px" class="demo-formData">
					<el-form-item label="版区ID" prop="id">
						<el-input v-model.number="formData.id"></el-input>
					</el-form-item>
                    <el-form-item class="button_submit">
						<el-button @click="getSectionData">获取数据</el-button>
					</el-form-item>
                    <el-form-item label="版区名称" prop="name">
						<el-input v-model="formData.name"></el-input>
					</el-form-item>
					<el-form-item label="版区简介" prop="intro">
						<el-input v-model="formData.intro"></el-input>
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
import { listSection, modSection } from "@/api/getData";
export default {
  data() {
    return {
      formData: {
        id: "",
        name: "",
        intro: ""
      },
      rules: {
        id: [{ type: "number", message: "请输入数字", trigger: "blur" }]
      }
    };
  },
  components: {
    headTop
  },
  mounted() {},
  methods: {
    getSectionData() {
      if (this.formData.id === "") {
        this.$message({
          type: "error",
          message: "版区不能为空"
        });
        return false;
      }
      listSection().then(res => {
        res.data.forEach(item => {
          if (item.id == this.formData.id) {
            this.formData.id = item.id;
            this.formData.name = item.name;
            this.formData.intro = item.intro;
          }
        });
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(async valid => {
        if (this.formData.id === "") {
          this.$message({
            type: "error",
            message: "请先获取数据"
          });
          return false;
        }
        if (valid) {
          try {
            let result = await modSection(this.formData);
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
