<template>
	<div class="manage_page fillcontain">
		<el-row style="height: 100%;">
	  		<el-col :span="4"  style="min-height: 100%; background-color: #324057;">
				<el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
					<el-menu-item index="manage"><i class="el-icon-menu"></i>首页</el-menu-item>
					<el-submenu index="2">
						<template slot="title"><i class="el-icon-star-on"></i>管理员管理</template>
						<el-menu-item index="adminList">查看管理员</el-menu-item>
						<el-menu-item v-show="perm4" index="adminMod">修改管理员</el-menu-item>
						<el-menu-item v-show="perm2" index="adminAdd">添加管理员</el-menu-item>
						<el-menu-item v-show="perm3" index="adminDelete">删除管理员</el-menu-item>
					</el-submenu>
					<el-submenu index="3">
						<template slot="title"><i class="el-icon-star-on"></i>角色管理</template>
						<el-menu-item index="roleList">查看角色</el-menu-item>
						<el-menu-item v-show="perm7" index="roleAdd">添加角色</el-menu-item>
						<el-menu-item v-show="perm8" index="roleDelete">删除角色</el-menu-item>
						<el-menu-item v-show="perm10" index="roleMod">角色权限管理</el-menu-item>
					</el-submenu>
					<el-submenu index="4">
						<template slot="title"><i class="el-icon-star-on"></i>权限管理</template>
						<el-menu-item index="permissionList">查看权限</el-menu-item>
					</el-submenu>
					<el-submenu index="5">
						<template slot="title"><i class="el-icon-star-on"></i>用户管理</template>
						<el-menu-item index="userList">查看用户</el-menu-item>
						<el-menu-item v-show="perm42" index="userMod">修改用户</el-menu-item>
						<el-menu-item v-show="perm40" index="userAdd">新增用户</el-menu-item>
						<el-menu-item v-show="perm41" index="userDelete">删除用户</el-menu-item>
					</el-submenu>
					<el-submenu index="6">
						<template slot="title"><i class="el-icon-document"></i>评论管理</template>
						<el-menu-item index="commentList">查看评论</el-menu-item>
						<el-menu-item v-show="perm17" index="commentDelete">删除评论</el-menu-item>
					</el-submenu>
					<el-submenu index="7">
						<template slot="title"><i class="el-icon-document"></i>举报管理</template>
						<el-menu-item index="complaintList">查看举报</el-menu-item>
						<el-menu-item v-show="perm20" index="complaintMod">处理举报</el-menu-item>
					</el-submenu>
					<el-submenu index="8">
						<template slot="title"><i class="el-icon-document"></i>日志管理</template>
						<el-menu-item index="logrecordList">查看日志</el-menu-item>
					</el-submenu>
					<el-submenu index="9">
						<template slot="title"><i class="el-icon-document"></i>订单管理</template>
						<el-menu-item index="paymentList">查看订单</el-menu-item>
						<el-menu-item v-show="perm25" index="paymentAdd">新增订单</el-menu-item>
					</el-submenu>
					<el-submenu index="10">
						<template slot="title"><i class="el-icon-document"></i>作品管理</template>
						<el-menu-item index="postList">查看作品</el-menu-item>
						<el-menu-item v-show="perm28" index="postDelete">删除作品</el-menu-item>
					</el-submenu>
					<el-submenu index="11">
						<template slot="title"><i class="el-icon-document"></i>版区管理</template>
						<el-menu-item index="sectionList">查看版区</el-menu-item>
						<el-menu-item v-show="perm33" index="sectionMod">更新版区</el-menu-item>
						<el-menu-item v-show="perm31" index="sectionAdd">新增版区</el-menu-item>
						<el-menu-item v-show="perm32" index="sectionDelete">删除版区</el-menu-item>
					</el-submenu>
					<el-submenu index="12">
						<template slot="title"><i class="el-icon-document"></i>敏感词管理</template>
						<el-menu-item index="swList">查看敏感词</el-menu-item>
						<el-menu-item v-show="perm36" index="swAdd">新增敏感词</el-menu-item>
						<el-menu-item v-show="perm37" index="swDelete">删除敏感词</el-menu-item>
					</el-submenu>
				</el-menu>
			</el-col>
			<el-col :span="20" style="height: 100%;overflow: auto;">
				<keep-alive>
				    <router-view></router-view>
				</keep-alive>
			</el-col>
		</el-row>
  	</div>
</template>

<script>
	import {getAdminInfo, getMyPermissions} from '@/api/getData'
    export default {
		data(){
			return {
				perm2 : false, perm3 : false, perm4 : false,
				perm7 : false, perm8 : false, perm10 : false,
				perm40 : false, perm41 : false, perm42 : false,
				perm17 : false, perm20 : false, perm25 : false,
				perm28 : false, perm31: false, perm32: false,
				perm33: false, perm36 : false, perm37 : false
			}
		},
		computed: {
			defaultActive: function(){
				return this.$route.path.replace('/', '');
			}
		},
		mounted(){
			getMyPermissions().then(res=>{
				var data = res.data;
				for( var i = 0; i < data.length; i++ ) {
					switch( data[i].id ) {
						case 2:
							this.perm2 = true; break;
						case 3:
							this.perm3 = true; break;
						case 4:
							this.perm4 = true; break;
						case 7:
							this.perm7 = true; break;
						case 8:
							this.perm8 = true; break;
						case 10:
							this.perm10 = true; break;
						case 17:
							this.perm17 = true; break;
						case 20:
							this.perm20 = true; break;
						case 25:
							this.perm25 = true; break;
						case 28:
							this.perm28 = true; break;
						case 31:
							this.perm31 = true; break;
						case 32:
							this.perm32 = true; break;
						case 33:
							this.perm33 = true; break;
						case 36:
							this.perm36 = true; break;
						case 37:
							this.perm37 = true; break;
						case 40:
							this.perm40 = true; break;
						case 41:
							this.perm41 = true; break;
						case 42:
							this.perm42 = true; break;
					}
				}
			});

			// console.log(res)
			// console.log(res._v.data[0])
		}
    }
</script>


<style lang="less" scoped>
	@import '../style/mixin';
	.manage_page{
		
	}
</style>
