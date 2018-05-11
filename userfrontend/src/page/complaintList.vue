<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="flash" style="margin-left: 20px; margin-top: 20px">刷新</el-button>
        <el-row class="table_container">
            <el-col :span="3">
            <el-input placeholder="作品ID" v-model="post" clearable width="20"></el-input>
            </el-col>
            <el-col :span="2" :offset="1">
            <el-input placeholder="评论ID" v-model="cmtid" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="处理状态" v-model="status" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="2">
                <el-button @click="search(this.currentPage)" type="info">查找</el-button>
            </el-col>
        </el-row>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 70%">
		      <el-table-column
		        prop="post"
		        label="作品ID"
		        width="150">
		      </el-table-column>
		      <el-table-column
		        prop="cmtid"
		        label="评论ID"
		        width="150">
		      </el-table-column>
          <el-table-column
		        prop="times"
		        label="举报次数"
		        width="150">
		      </el-table-column>
          <el-table-column
		        prop="status"
		        label="处理状态"
		        width="150">
		      </el-table-column>
              <el-table-column
                
                label="地址"
                width="180">
                <template slot-scope="scope">
                    <el-button @click.native.prevent="showDetail(scope.$index, tableData)" type="text" size="small">查看</el-button>
                </template>
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
        <div class="table_container">
            <el-table
		      :data="tableData2"
		      style="width: 80%">
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
                        @size-change="handleSizeChange2"
                        @current-change="handleCurrentChange2"
                        :current-page="currentPage2"
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
import headTop from "../components/headTop";
import { listComplaintPost, listComplaint } from "@/api/getData";
export default {
  data() {
    return {
      tableData2: [],
      tableData: [],
      post: "",
      cmtid: "",
      status: "",
      currentRow: null,
      currentPage: 1,
      currentPage2: 1,
      temppost: "",
      tempcmtid: ""
    };
  },
  components: {
    headTop
  },
  created() {
    this.initData();
  },
  methods: {
    async initData() {
      try {
        const params = {
          post: this.post,
          cmtid: this.cmtid,
          status: this.status,
          page: this.currentPage
        };
        const res = await listComplaintPost(params);
        if (res.code == 200) {
          this.tableData = [];
          res.data.forEach(item => {
            const tableItem = {
              post: item.post,
              cmtid: item.cmtid,
              status: item.status,
              times: item.times
            };
            this.tableData.push(tableItem);
          });
        } else {
          throw new Error(res.message);
        }
      } catch (err) {
        console.log("获取数据失败", err);
      }
    },
    search() {
      var params = {
        post: this.post,
        cmtid: this.cmtid,
        status: this.status,
        page: this.currentPage
      };
      listComplaintPost(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            post: item.post,
            cmtid: item.cmtid,
            status: item.status,
            times: item.times
          };
          this.tableData.push(tableItem);
        });
      });
    },
    showDetail(index, rows) {
      this.temppost = rows[index].post;
      this.tempcmtid = rows[index].cmtid;
      var params = {
        post: rows[index].post,
        cmtid: rows[index].cmtid
      };
      listComplaint(params).then(res => {
        this.tableData2 = [];
        res.data.forEach(item => {
          const tableItem = {
            cpost: item.post,
            ccmtid: item.cmtid,
            cuser: item.user,
            ccreatime: item.creatime,
            cmsg: item.msg
          };
          this.tableData2.push(tableItem);
        });
      });
    },
    flash() {
      this.currentPage = 1;
      var params = {
        post: "",
        cmtid: "",
        status: "",
        page: this.currentPage
      };
      listComplaintPost(params).then(res => {
        this.tableData = [];
        this.tableData2 = [];
        res.data.forEach(item => {
          const tableItem = {
            post: item.post,
            cmtid: item.cmtid,
            status: item.status,
            times: item.times
          };
          this.tableData.push(tableItem);
        });
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      var params = {
        post: this.post,
        cmtid: this.cmtid,
        status: this.status,
        page: val
      };
      listComplaintPost(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            post: item.post,
            cmtid: item.cmtid,
            status: item.status,
            times: item.times
          };
          this.tableData.push(tableItem);
        });
      });
    },
    handleCurrentChange2(val) {
      this.currentPage2 = val;
      var params = {
        post: this.temppost,
        cmtid: this.tempcmtid,
        page: val
      };
      listComplaint(params).then(res => {
        this.tableData2 = [];
        res.data.forEach(item => {
          const tableItem = {
            cpost: item.post,
            ccmtid: item.cmtid,
            cuser: item.user,
            ccreatime: item.creatime,
            cmsg: item.msg
          };
          this.tableData2.push(tableItem);
        });
      });
    }
  }
};
</script>

<style lang="less">
@import "../style/mixin";
.table_container {
  padding: 20px;
}
</style>


