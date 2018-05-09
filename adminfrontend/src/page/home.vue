<template>
    <div>
        <head-top></head-top>
		<section class="data_section">
			<header class="section_title">重要操作日志</header>
			<!-- <el-row :gutter="20" style="margin-bottom: 10px;">
                <el-col :span="4"><div class="data_list today_head"><span class="data_num head">当日数据：</span></div></el-col>
				<el-col :span="4"><div class="data_list"><span class="data_num">{{userCount}}</span> 新增用户</div></el-col>
				<el-col :span="4"><div class="data_list"><span class="data_num">{{orderCount}}</span> 新增订单</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{adminCount}}</span> 新增管理员</div></el-col>
			</el-row>
            <el-row :gutter="20">
                <el-col :span="4"><div class="data_list all_head"><span class="data_num head">总数据：</span></div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{allUserCount}}</span> 注册用户</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{allOrderCount}}</span> 订单</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{allAdminCount}}</span> 管理员</div></el-col>
            </el-row> -->
			<el-row>
				<el-col offset="2">
				<el-button round @click="flash" style="margin-bottom: 20px">刷新</el-button>
				<div class="table_container">
					<el-table
					:data="tableData"
					style="width: 80%">
					<el-table-column
						prop="admin"
						label="管理员ID"
						width="250">
					</el-table-column>
					<el-table-column
						prop="text"
						label="操作内容"
						>
					</el-table-column>
					<el-table-column
						prop="creatime"
						label="操作时间"
						>
					</el-table-column>
					</el-table>
					<div class="Pagination" style="text-align: left;margin-top: 10px;margin-left:-5px;">
						<el-row>
							<el-col span="2">
								<el-pagination
								@current-change="handleCurrentChange"
								:current-page="currentPage"
								layout="prev, pager, next"
								>
								</el-pagination>
							</el-col>
							<el-col span="1">
								<el-tag style="margin-top:4px;margin-left:-15px;">{{currentPage}}</el-tag>
							</el-col>
						</el-row>
					</div>
				</div>
				</el-col>
			</el-row>
		</section>
		<!-- <tendency :sevenDate='sevenDate' :sevenDay='sevenDay'></tendency> -->
    </div>
</template>

<script>
	import headTop from '../components/headTop'
	import tendency from '../components/tendency' 
	// import dtime from 'time-formater'
	import {listLogrecord} from '@/api/getData'
    export default {
    	data(){
    		return {
				tableData: [],
    			// userCount: null,
    			// orderCount: null,
                // adminCount: null,
                // allUserCount: null,
                // allOrderCount: null,
                // allAdminCount: null,
    			// sevenDay: [],
				// sevenDate: [[],[],[]],
				currentPage: 1,
    		}
    	},
    	components: {
    		headTop,
    		tendency,
    	},
    	mounted(){
    		this.initData();
    		// for (let i = 6; i > -1; i--) {
    		// 	const date = dtime(new Date().getTime() - 86400000*i).format('YYYY-MM-DD')
    		// 	this.sevenDay.push(date)
    		// }
    		// this.getSevenData();
    	},
        computed: {

        },
    	methods: {
    		async initData(){
                try{
                    const res = await listLogrecord(this.currentPage);
                    if (res.code == 200) {
                    	this.tableData = [];
                    	res.data.forEach(item => {
                    		const tableItem = {
								admin: item.admin,
								text:  item.text,
								creatime: item.creatime,
                    		}
                    		this.tableData.push(tableItem)
                    	})
                    }else{
                    	throw new Error(res.message)
                    }
                }catch(err){
                    console.log('获取数据失败', err);
                }
			},
			flash(){
                listLogrecord(this.currentPage).then(res=>{
                    this.tableData = [];
                    res.data.forEach(item => {
                        const tableItem = {
                            admin: item.admin,
							text:  item.text,
							creatime: item.creatime,
                        }
                        this.tableData.push(tableItem)
                    });
                });
			},
			handleCurrentChange(val) {
                this.currentPage = val;
                listLogrecord(val).then(res=>{
                    this.tableData = [];
                    res.data.forEach(item => {
                        const tableItem = {
                            admin: item.admin,
							text:  item.text,
							creatime: item.creatime,
                        }
                        this.tableData.push(tableItem)
                    });
                });
            },
    		// async getSevenData(){
    		// 	const apiArr = [[],[],[]];
    		// 	this.sevenDay.forEach(item => {
    		// 		apiArr[0].push(userCount(item))
    		// 		apiArr[1].push(orderCount(item))
            //         apiArr[2].push(adminDayCount(item))
    		// 	})
    		// 	const promiseArr = [...apiArr[0], ...apiArr[1], ...apiArr[2]]
    		// 	Promise.all(promiseArr).then(res => {
    		// 		const resArr = [[],[],[]];
			// 		res.forEach((item, index) => {
			// 			if (item.status == 1) {
			// 				resArr[Math.floor(index/7)].push(item.count)
			// 			}
			// 		})
			// 		this.sevenDate = resArr;
    		// 	}).catch(err => {
    		// 		console.log(err)
    		// 	})
    		// }
    	}
    }
</script>

<style lang="less">
	@import '../style/mixin';
	.data_section{
		padding: 20px;
		margin-bottom: 40px;
		.section_title{
			text-align: center;
			font-size: 30px;
			margin-bottom: 10px;
		}
		.data_list{
			text-align: center;
			font-size: 14px;
			color: #666;
            border-radius: 6px;
            background: #E5E9F2;
            .data_num{
                color: #333;
                font-size: 26px;

            }
            .head{
                border-radius: 6px;
                font-size: 22px;
                padding: 4px 0;
                color: #fff;
                display: inline-block;
            }
        }
        .today_head{
            background: #FF9800;
        }
        .all_head{
            background: #20A0FF;
        }
	}
    .wan{
        .sc(16px, #333)
    }
</style>
