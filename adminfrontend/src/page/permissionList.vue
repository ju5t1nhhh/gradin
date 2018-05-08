<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="getCpy" style="margin-left: 20px; margin-top: 20px">刷新</el-button>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 100%">
		      <el-table-column
		        prop="id"
		        label="权限ID"
		        width="250">
		      </el-table-column>
		      <el-table-column
		        prop="name"
		        label="权限名称"
		        >
		      </el-table-column>
          <el-table-column
		        prop="url"
		        label="权限"
		        >
		      </el-table-column>
          <el-table-column
		        prop="type"
		        label="权限类型"
		        >
		      </el-table-column>
          <el-table-column
		        prop="parent"
		        label="权限父结点"
		        >
		      </el-table-column>
              <el-table-column
                
                label="地址"
                width="180">
                <template slot-scope="scope">
        <el-button @click.native.prevent="hideRow(scope.$index, tableData)" type="text" size="small">查看</el-button>
        
      </template>
              </el-table-column>
		    </el-table>

		    <div class="Pagination" style="text-align: left;margin-top: 10px;">
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="currentPage"
                  :page-size="20"
                  layout="prev, pager, next"
                  >
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import {listPermission, getMyPermissions} from '@/api/getData'
    export default {
        data(){
            return {
                tableData: [],
                tableDataCpy: [],
                currentRow: null,
                offset: 0,
                limit: 20,
                count: 0,
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
                    const res = await listPermission();
                    if (res.code == 200) {
                      this.tableData = [];
                      this.tableDataCpy = [];
                    	res.data.forEach(item => {
                    		const tableItem = {
                    			id: item.id,
                          name: item.name,
                          url: item.url,
                          type: item.type,
                          parent: item.parent,
                        }
                        if(tableItem.url === null) {
                          this.tableData.push(tableItem)
                        }
                        this.tableDataCpy.push(tableItem)
                    	})
                    }else{
                    	throw new Error(res.message)
                    }
                }catch(err){
                    console.log('获取数据失败', err);
                }
            },
            getCpy(){
              this.tableData = [];
                var data = this.tableDataCpy;
                for( var i = 0; i < data.length; i++) {
                  var item = data[i];
                  let ti = {
                    			id: item.id,
                          name: item.name,
                          url: item.url,
                          type: item.type,
                          parent: item.parent,
                        }
                  if(ti.url === null) {
                          this.tableData.push(ti)
                        }
                  
                }
            },
            handleClick(a) {
              // const tableItem = {

              // }
              // this.tableData.push(tableItem)
              //console.log(JSON.stringify(a))
            },
            hideRow(index, rows) {
              this.tableData = [];
                var data = this.tableDataCpy;
                let id = rows[index].id
                for( var i = 0; i < data.length; i++) {
                  var item = data[i];
                  if(item.parent === id) {
                  let ti = {
                    			id: item.id,
                          name: item.name,
                          url: item.url,
                          type: item.type,
                          parent: item.parent,
                        }
                  this.tableData.push(ti)
                  }
                }
              //   data.forEach(item => {
                
              //   })
              // // getMyPermissions().then(res=>{
                
              // })
              
              
              // rows.
              // rows.splice(index, 1);
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1)*this.limit;
                // this.getAdmin()
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


