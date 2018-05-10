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
            <el-input placeholder="评论人自增ID" v-model="cmtor" clearable width="20"></el-input>
            </el-col>
            <el-col :span="2" :offset="1">
            <el-input placeholder="评论人ID" v-model="cmtorid" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
                <el-date-picker v-model="ptime" type="date"
                placeholder="选择日期" format="yyyy-MM-dd"
                value-format="yyyy-MM-dd">
                </el-date-picker>
            </el-col>
            <el-col :span="3" :offset="2">
                <el-button @click="search(this.currentPage)" type="info">查找</el-button>
            </el-col>

        </el-row>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 100%">
		      <el-table-column
		        prop="post"
		        label="作品ID"
		        width="120">
		      </el-table-column>
		      <el-table-column
		        prop="cmtid"
		        label="评论ID"
		        width="120">
		      </el-table-column>
          <el-table-column
		        prop="cmtor"
		        label="评论人自增ID"
		        width="140">
		      </el-table-column>
          <el-table-column
		        prop="cmtorid"
		        label="评论者ID"
		        width="120">
		      </el-table-column>
              <el-table-column
		        prop="text"
		        label="评论内容"
		        width="200">
		      </el-table-column>
          <el-table-column
		        prop="creatime"
		        label="创建时间"
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
import headTop from "../components/headTop";
import { listComment } from "@/api/getData";
export default {
  data() {
    return {
      post: "",
      cmtor: "",
      cmtid: "",
      cmtorid: "",
      ptime: "",
      tableData: [],
      currentRow: null,
      currentPage: 1
    };
  },
  components: {
    headTop
  },
  methods: {
    search() {
      var params = {
        post: this.post,
        cmtid: this.cmtid,
        cmtor: this.cmtor,
        cmtorid: this.cmtorid,
        creatime: this.ptime,
        page: this.currentPage
      };
      listComment(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            post: item.post,
            cmtid: item.cmtid,
            cmtor: item.cmtor,
            cmtorid: item.cmtorid,
            creatime: item.creatime,
            text: item.text
          };
          this.tableData.push(tableItem);
        });
      });
    },
    flash() {
      this.currentPage = 1;
      var params = {
        post: "",
        cmtor: "",
        cmtid: "",
        cmtorid: "",
        ptime: "",
        page: this.currentPage
      };
      listComment(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            post: item.post,
            cmtid: item.cmtid,
            cmtor: item.cmtor,
            cmtorid: item.cmtorid,
            creatime: item.creatime,
            text: item.text
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
        cmtor: this.cmtor,
        cmtorid: this.cmtorid,
        creatime: this.ptime,
        page: val
      };
      listComment(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            post: item.post,
            cmtid: item.cmtid,
            cmtor: item.cmtor,
            cmtorid: item.cmtorid,
            creatime: item.creatime,
            text: item.text
          };
          this.tableData.push(tableItem);
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


