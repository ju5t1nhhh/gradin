<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-row class="table_container">
            <el-col :span="3">
            <el-input placeholder="作品ID" v-model="post" clearable width="20"></el-input>
            </el-col>
            <el-col :span="2" :offset="1">
            <el-input placeholder="评论ID" v-model="cmtid" clearable width="20"></el-input>
            </el-col>
            <el-col :span="1" :offset="1">
                <el-button @click="getComplaint" type="info">获取</el-button>
            </el-col>
            <el-col :span="1" :offset="1">
                <el-button @click="dealComplaint" type="danger">处理</el-button>
            </el-col>

        </el-row>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 100%">
		      <el-table-column
		        prop="cuser"
		        label="举报者"
		        width="150">
		      </el-table-column>
		      <el-table-column
		        prop="cpost"
		        label="作品ID"
		        width="150">
		      </el-table-column>
		      <el-table-column
		        prop="ccmtid"
		        label="评论ID"
		        width="150">
		      </el-table-column>
          <el-table-column
		        prop="cmsg"
		        label="举报消息"
		        width="150">
		      </el-table-column>
              <el-table-column
		        prop="ccreatime"
		        label="时间"
		        width="300">
		      </el-table-column>
		    </el-table>
		    <div class="Pagination" style="text-align: left;margin-top: 10px;">
                <el-row>
                    <el-col span="2">
                        <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="currentPage"
                        :page-size="20"
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
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import {listComplaint, modComplaint} from '@/api/getData'
    export default {
        data(){
            return {
                post: '',
                cmtid: '',
                tableData: [],
                currentRow: null,
                currentPage: 1,
            }
        },
    	components: {
    		headTop,
    	},
        created(){
            // this.initData();
        },
        methods: {
            // async initData(){
            //     try{
            //         const params = {
            //             post: this.post,
            //             cmtid: this.cmtid,
            //             cmtor: this.cmtor,
            //             cmtorid: this.cmtorid,
            //             creatime: this.ptime,
            //             page: this.currentPage
			// 		}
            //         const res = await listComment(params);
            //         if (res.code == 200) {
            //         	this.tableData = [];
            //         	res.data.forEach(item => {
            //         		const tableItem = {
            //                     post: item.post,
            //                     cmtid: item.cmtid,
            //                     cmtor: item.cmtor,
            //                     cmtorid: item.cmtorid,
            //                     creatime: item.creatime,
            //         		}
            //         		this.tableData.push(tableItem)
            //         	})
            //         }else{
            //         	throw new Error(res.message)
            //         }
            //     }catch(err){
            //         console.log('获取数据失败', err);
            //     }
            // },
            getComplaint() {
                var params = {
                    post: this.post,
                    cmtid: this.cmtid,
                    page: this.currentPage
                };
                listComplaint(params).then(res=>{
                    this.tableData = [];
                    res.data.forEach(item => {
                        const tableItem = {
                            cpost: item.post,
                            ccmtid: item.cmtid,
                            cuser: item.user,
                            ccreatime: item.creatime,
                            cmsg: item.msg,
                        }
                        this.tableData.push(tableItem)
                    });
                });
            },
            dealComplaint() {
                var params = {
                    post: this.post,
                    cmtid: this.cmtid,
                };
                if ( this.post === '' || this.cmtid === '' ) {
                    this.$message({
                        type: 'error',
                        message: '不能同时处理多个'
                    });
                    return false;
                }
                modComplaint(params).then(res=>{
                    if ( res.code == 200) {
                        this.$message({
                            type: 'success',
                            message: '处理成功'
                        });
                    } else {
                        this.$message({
                            type: 'error',
                            message: '处理失败'
                        });
                    }
                });
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                var params = {
                    post: this.post,
                    cmtid: this.cmtid,
                    page: val
                };
                listComplaint(params).then(res=>{
                    this.tableData = [];
                    res.data.forEach(item => {
                        const tableItem = {
                            cpost: item.post,
                            ccmtid: item.cmtid,
                            cuser: item.user,
                            ccreatime: item.creatime,
                            cmsg: item.msg,
                        }
                        this.tableData.push(tableItem)
                    });
                });
            },
            // async getAdmin(){
            //     try{
            //         const res = await adminList({offset: this.offset, limit: this.limit});
            //         if (res.status == 1) {
            //         	this.tableData = [];
            //         	res.data.forEach(item => {
            //         		const tableItem = {
            //         			create_time: item.create_time,
			// 			        user_name: item.user_name,
			// 			        admin: item.admin,
            //                     city: item.city,
            //         		}
            //         		this.tableData.push(tableItem)
            //         	})
            //         }else{
            //         	throw new Error(res.message)
            //         }
            //     }catch(err){
            //         console.log('获取数据失败', err);
            //     }
            // }
        },
    }
</script>

<style lang="less">
	@import '../style/mixin';
    .table_container{
        padding: 20px;
    }
</style>


