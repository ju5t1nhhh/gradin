<template>
    <div class="header_container">

		<el-breadcrumb separator="/">
			<el-breadcrumb-item :to="{ path: '/manage' }">首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in $route.meta" key="index">{{item}}</el-breadcrumb-item>
		</el-breadcrumb>
		<el-dropdown @command="handleCommand" menu-align='start'>
			<!-- <div style="text-align:center;"> -->
				<img :src="images.sample" class="avator">
				
			<!-- </div> -->
			<el-dropdown-menu slot="dropdown">
				<el-dropdown-item command="home">首页</el-dropdown-item>
				<el-dropdown-item command="singout">退出</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
		<div>
			<el-tag type="warning">{{adminInfo.loginId}}</el-tag>
			<el-tag>{{adminInfo.rolename}}</el-tag>
		</div>
    </div>
</template>

<script>
	import {signout} from '@/api/getData'
	import {baseImgPath} from '@/config/env'
	import {mapActions, mapState} from 'vuex'

    export default {
    	data(){
    		return {
				// imgUrl: avatar,  
				images: {
					sample: require('../assets/img/avator.png')
				}  			
    		}
    	},
    	created(){
			// console.log("created:"+this.adminInfo)
    		// if (!this.adminInfo.loginId) {
			// 	console.log("headTop:"+this.adminInfo.loginId)
    		// 	this.getAdminData()
    		// }
		},
		mounted(){
			// console.log("headtop mounted:"+this.adminInfo.loginId)
			if(!this.adminInfo.loginId){
				this.$message({
					type: 'error',
					message: '请先登录'
				});
				this.$router.push('/');
			}
		},
    	computed: {
    		...mapState(['adminInfo']),
    	},
		methods: {
			...mapActions(['getAdminData','clearAdminData']),
			async handleCommand(command) {
				if (command == 'home') {
					this.$router.push('/manage');
				}else if(command == 'singout'){					
					const res = await signout()
					console.log("logout:"+res.code)
					if ( res.code == 999 ) {
						this.$message({
							type: 'success',
							message: '退出成功'
						});
						this.clearAdminData()
					} else {
						this.$message({
							type: 'error',
							message: res.msg
						});
					}
					this.$router.push('/');
					
					// if (!res) {
					// 	this.$message({
	                //         type: 'success',
	                //         message: '退出成功'
	                //     });
	                //     this.$router.push('/');
					// }else{
					// 	this.$message({
	                //         type: 'error',
	                //         message: res.message
	                //     });
					// }
				}
			},
		}
    }
</script>

<style lang="less">
	@import '../style/mixin';
	.header_container{
		background-color: #EFF2F7;
		height: 60px;
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding-left: 20px;
	}
	.avator{
		.wh(36px, 36px);
		border-radius: 50%;
		// margin-right: 15px;
		// margin-left:32px;
	}
	.el-dropdown-menu__item{
        text-align: center;
    }
</style>
