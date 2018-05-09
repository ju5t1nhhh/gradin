<template>
    <div>
        <head-top></head-top>
        <el-row style="margin-top: 20px;">
  			<el-col :span="12" :offset="4">
		        <el-form :model="formData" :rules="rules" ref="formData" label-width="110px" class="demo-formData">
					<el-form-item label="GINS码" prop="code">
						<el-input v-model="formData.code"></el-input>
					</el-form-item>
					<!-- <el-form-item label="用户" prop="pwd">
						<el-input v-model="formData.pwd" maxLength="11" type="password"></el-input>
					</el-form-item>
					<el-form-item label="角色" prop="role">
						<el-input v-model.number="formData.role"></el-input>
					</el-form-item> -->
					<!-- <el-form-item label="上传店铺头像">
						<el-upload
						  class="avatar-uploader"
						  :action="baseUrl + '/v1/addimg/shop'"
						  :show-file-list="false"
						  :on-success="handleShopAvatarScucess"
						  :before-upload="beforeAvatarUpload">
						  <img v-if="formData.image_path" :src="baseImgPath + formData.image_path" class="avatar">
						  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
						</el-upload>
					</el-form-item> -->
					<el-form-item class="button_submit">
						<el-button type="primary" @click="submitForm('formData')">立即创建</el-button>
					</el-form-item>
				</el-form>
  			</el-col>
  		</el-row>
    </div>
</template>

<script>
    import headTop from '@/components/headTop'
    import {addPayment} from '@/api/getData'
    // import {baseUrl, baseImgPath} from '@/config/env'
    export default {
    	data(){
    		return {
    			formData: {
					code: '',	
		        },
		        rules: {
					code: [
						{ required: true, message: '请输入新GINS码', trigger: 'blur' },
					],
				},
			    // baseUrl,
			    // baseImgPath,
    		}
    	},
    	components: {
    		headTop,
    	},
    	mounted(){
    	},
    	methods: {
		    submitForm(formName) {
				this.$refs[formName].validate(async (valid) => {
					if (valid) {
						try{
							let result = await addPayment(this.formData);
							if (result.code == 200) {
								this.$message({
					            	type: 'success',
					            	message: '添加成功'
					          	});
					          	this.formData = {
                                    loginId: '',
                                    pwd: '',
                                    role: '',
						        };
							}else{
								this.$message({
					            	type: 'error',
					            	message: result.msg
					          	});
							}
							console.log(result)
						}catch(err){
							console.log(err)
						}
					} else {
						this.$notify.error({
							title: '错误',
							message: '请检查输入是否正确',
							offset: 100
						});
						return false;
					}
				});
			},
		}
    }
</script>

<style lang="less">
	@import '../style/mixin';
	.button_submit{
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
