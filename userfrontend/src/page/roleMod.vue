<template>
    <div>
        <head-top></head-top>
        <el-row style="margin-top: 20px;">
  			<el-col :span="12" :offset="4">
		        <el-form :model="formData" :rules="rules" ref="formData" label-width="110px" class="demo-formData">
                    <el-form-item label="角色ID" prop="role">
						<el-input v-model="formData.role"></el-input>
					</el-form-item>
					
					<el-form-item class="button_submit">
						<el-button type="primary" @click="getPermission">获取</el-button>
					</el-form-item>

                    <el-form-item class="button_submit">
						<el-button type="primary" @click="updateRolePermission">修改角色权限</el-button>
					</el-form-item>
				</el-form>
  			</el-col>
  		</el-row>
        <div style="margin-left:-80px;text-align:center;" v-loading="loading">
            管理员管理
            <el-checkbox-group v-model="admincbx">
                <el-checkbox label="修改管理员"></el-checkbox>
                <el-checkbox label="添加管理员"></el-checkbox>
                <el-checkbox label="删除管理员"></el-checkbox>
            </el-checkbox-group>
            <br/>
            角色管理
            <el-checkbox-group v-model="rolecbx">
                <el-checkbox label="添加角色"></el-checkbox>
                <el-checkbox label="删除角色"></el-checkbox>
                <el-checkbox label="角色权限管理"></el-checkbox>
            </el-checkbox-group>
            <br/>
            用户管理
            <el-checkbox-group v-model="usercbx">
                <el-checkbox label="修改用户"></el-checkbox>
                <el-checkbox label="新增用户"></el-checkbox>
                <el-checkbox label="删除用户"></el-checkbox>
            </el-checkbox-group>
            <br/>
            评论管理
            <el-checkbox-group v-model="cmtcbx">
                <el-checkbox label="删除评论"></el-checkbox>
            </el-checkbox-group>
            <br/>
            举报管理
            <el-checkbox-group v-model="complaintcbx">
                <el-checkbox label="处理举报"></el-checkbox>
            </el-checkbox-group>
            <br/>
            订单管理
            <el-checkbox-group v-model="paymentcbx">
                <el-checkbox label="新增订单"></el-checkbox>
            </el-checkbox-group>
            <br/>
            作品管理
            <el-checkbox-group v-model="postcbx">
                <el-checkbox label="删除作品"></el-checkbox>
            </el-checkbox-group>
            <br/>
            版区管理
            <el-checkbox-group v-model="sectioncbx">
                <el-checkbox label="更新版区"></el-checkbox>
                <el-checkbox label="新增版区"></el-checkbox>
                <el-checkbox label="删除版区"></el-checkbox>
            </el-checkbox-group>
            <br/>
            敏感词管理
            <el-checkbox-group v-model="swcbx">
                <el-checkbox label="新增敏感词"></el-checkbox>
                <el-checkbox label="删除敏感词"></el-checkbox>
            </el-checkbox-group>
        </div>
    </div>
</template>

<script>
import headTop from "@/components/headTop";
import { listRolePermission, modRolePermission } from "@/api/getData";
export default {
  data() {
    return {
      loading: false,
      admincbx: [],
      rolecbx: [],
      usercbx: [],
      cmtcbx: [],
      complaintcbx: [],
      paymentcbx: [],
      postcbx: [],
      sectioncbx: [],
      swcbx: [],
      formData: {
        role: ""
      },
      rules: {
        role: [{ required: true, message: "请输入角色ID", trigger: "blur" }]
      }
    };
  },
  components: {
    headTop
  },
  mounted() {},
  methods: {
    updateRolePermission() {
      if (this.formData.role == "") {
        this.$message({
          type: "error",
          message: "请输入角色ID"
        });
        return false;
      }
      var list = this.admincbx
        .concat(this.rolecbx)
        .concat(this.usercbx)
        .concat(this.cmtcbx)
        .concat(this.complaintcbx)
        .concat(this.paymentcbx)
        .concat(this.postcbx)
        .concat(this.sectioncbx)
        .concat(this.swcbx);
      modRolePermission(this.formData.role, list).then(res => {});
    },
    getPermission() {
      if (this.formData.role == "") {
        this.$message({
          type: "error",
          message: "请输入角色ID"
        });
        return false;
      }
      this.loading = true;
      this.admincbx = [];
      this.rolecbx = [];
      this.usercbx = [];
      this.cmtcbx = [];
      this.complaintcbx = [];
      this.paymentcbx = [];
      this.postcbx = [];
      this.sectioncbx = [];
      this.swcbx = [];
      listRolePermission(this.formData.role).then(res => {
        res.data.forEach(item => {
          switch (item.parent) {
            case 1:
              if (
                item.name === "修改管理员" ||
                item.name === "添加管理员" ||
                item.name === "删除管理员"
              )
                this.admincbx.push(item.name);
              break;
            case 6:
              if (
                item.name === "添加角色" ||
                item.name === "删除角色" ||
                item.name === "角色权限管理"
              )
                this.rolecbx.push(item.name);
              break;
            case 39:
              if (
                item.name === "修改用户" ||
                item.name === "新增用户" ||
                item.name === "删除用户"
              )
                this.usercbx.push(item.name);
              break;
            case 16:
              if (item.name === "删除评论") this.cmtcbx.push(item.name);
              break;
            case 19:
              if (item.name === "处理举报") this.complaintcbx.push(item.name);
              break;
            case 24:
              if (item.name === "新增订单") this.paymentcbx.push(item.name);
              break;
            case 27:
              if (item.name === "删除作品") this.postcbx.push(item.name);
              break;
            case 30:
              if (
                item.name === "更新版区" ||
                item.name === "新增版区" ||
                item.name === "删除版区"
              )
                this.sectioncbx.push(item.name);
              break;
            case 35:
              if (item.name === "新增敏感词" || item.name === "删除敏感词")
                this.swcbx.push(item.name);
              break;
          }
        });
        this.loading = false;
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
