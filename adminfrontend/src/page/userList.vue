<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="flash" style="margin-left: 20px; margin-top: 20px">刷新</el-button>
        <el-row class="table_container">
            <el-col :span="5">
            <el-input placeholder="自增ID" v-model="autoid" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="用户ID" v-model="id" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="用户邮箱" v-model="email" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="用户状态" v-model="status" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
                <el-button @click="search(this.currentPage)" type="info">查找</el-button>
            </el-col>

        </el-row>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 100%">
		      <el-table-column
		        prop="autoid"
		        label="自增ID"
		        width="300">
		      </el-table-column>
		      <el-table-column
		        prop="id"
		        label="用户ID"
		        width="180">
		      </el-table-column>
              <el-table-column
		        prop="email"
		        label="用户邮箱"
		        width="180">
		      </el-table-column>
              <el-table-column
		        prop="status"
		        label="用户状态"
		        >
		      </el-table-column>
              <el-table-column
		        prop="gins"
		        label="GINS"
		        >
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
    import {listUser} from '@/api/getData'
    export default {
        data(){
            return {
                autoid: '',
                id: '',
                email: '',
                status: '',
                gins: '',
                tableData: [],
                currentRow: null,
                currentPage: 1,
            }
        },
    	components: {
    		headTop,
    	},
        created(){
            this.initData();
        },
        methods: {
            async initData(){
                try{
                    const params = {
                        autoid: this.autoid,
                        id: this.id,
                        email: this.email,
                        status: this.status,
                        gins: this.gins,
                        page: this.currentPage
					}
                    const res = await listUser(params);
                    if (res.code == 200) {
                        this.tableData = [];
                    	res.data.forEach(item => {
                    		const tableItem = {
                                autoid: item.autoid,
                                id: item.id,
                                email: item.email,
                                status: item.status,
                                gins: item.gins,
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
                this.currentPage = 1;
                var params = {
                    autoid: '',
                    id: '',
                    email: '',
                    status: '',
                    gins: '',
                    page: this.currentPage
                };
                listUser(params).then(res=>{
                    this.tableData = [];
                    res.data.forEach(item => {
                        const tableItem = {
                            autoid: item.autoid,
                            id: item.id,
                            email: item.email,
                            status: item.status,
                            gins: item.gins,
                            page: item.currentPage
                        }
                        this.tableData.push(tableItem)
                    });
                });
            },
            search() {
                var params = {
                    autoid: this.autoid,
                    id: this.id,
                    email: this.email,
                    status: this.status,
                    gins: this.gins,
                    page: this.currentPage
                };
                listUser(params).then(res=>{
                    this.tableData = [];
                    res.data.forEach(item => {
                        const tableItem = {
                            autoid: item.autoid,
                            id: item.id,
                            email: item.email,
                            status: item.status,
                            gins: item.gins,
                            page: item.currentPage
                        }
                        this.tableData.push(tableItem)
                    });
                });
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                var params = {
                    autoid: this.autoid,
                    id: this.id,
                    email: this.email,
                    status: this.status,
                    gins: this.gins,
                    page: val
                };
                listUser(params).then(res=>{
                    this.tableData = [];
                    res.data.forEach(item => {
                        const tableItem = {
                            autoid: this.autoid,
                            id: this.id,
                            email: this.email,
                            gins: this.gins,
                            status: this.status,
                        }
                        this.tableData.push(tableItem)
                    });
                });
            },
        },
    }
</script>

<style lang="less">
	@import '../style/mixin';
    .table_container{
        padding: 20px;
    }
</style>
