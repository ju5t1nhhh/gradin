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
                <el-button @click="getComment" type="info">获取</el-button>
            </el-col>
            <el-col :span="1" :offset="1">
                <el-button @click="deleteComment" type="danger">删除</el-button>
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
import { listComment, delComment } from "@/api/getData";
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
    getComment() {
      var params = {
        post: this.post,
        cmtid: this.cmtid
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
    deleteComment() {
      var params = {
        post: this.post,
        cmtid: this.cmtid
      };
      if (this.post === "" || this.cmtid === "") {
        this.$message({
          type: "error",
          message: "不能同时删除多个"
        });
        return false;
      }
      delComment(params).then(res => {
        if (res.code == 200) {
          this.tableData = [];
          this.$message({
            type: "success",
            message: "删除成功"
          });
        } else {
          this.$message({
            type: "error",
            message: "删除失败"
          });
        }
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


