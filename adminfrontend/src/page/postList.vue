<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="flash" style="margin-left: 20px; margin-top: 20px">刷新</el-button>
        <el-row class="table_container">
            <el-col :span="5">
            <el-input placeholder="区域" v-model="section" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="ID" v-model="id" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="作者" v-model="author" clearable width="20"></el-input>
            </el-col>
            <el-col :span="4" :offset="1">
                <el-date-picker v-model="creatime" type="date"
                placeholder="选择日期" format="yyyy-MM-dd"
                value-format="yyyy-MM-dd">
                </el-date-picker>
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
		        prop="section"
		        label="作品区域"
                width="150"
		        >
		      </el-table-column>
		      <el-table-column
		        prop="id"
		        label="作品ID"
		        width="150">
		      </el-table-column>
		      <el-table-column
		        prop="author"
		        label="作者"
		        width="180">
		      </el-table-column>
          <el-table-column
		        prop="multmedia"
		        label="图片地址"
		        width="180">
		      </el-table-column>
          <el-table-column
		        prop="text"
		        label="内容"
		        >
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
import { listPost } from "@/api/getData";
export default {
  data() {
    return {
      tableData: [],
      section: "",
      id: "",
      author: "",
      multmedia: "",
      text: "",
      creatime: "",
      currentRow: null,
      currentPage: 1
    };
  },
  components: {
    headTop
  },
  methods: {
    flash() {
      var params = {
        section: this.section,
        id: this.id,
        author: this.author,
        multmedia: this.multmedia,
        text: this.text,
        creatime: this.creatime,
        page: this.currentPage
      };
      listPost(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            id: item.id,
            author: item.author,
            multmedia: item.multmedia,
            text: item.text,
            creatime: item.creatime,
            section: item.section
          };
          this.tableData.push(tableItem);
        });
      });
    },
    search() {
      var params = {
        section: this.section,
        id: this.id,
        author: this.author,
        multmedia: this.multmedia,
        text: this.text,
        creatime: this.creatime,
        page: this.currentPage
      };
      listPost(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            id: item.id,
            author: item.author,
            multmedia: item.multmedia,
            text: item.text,
            creatime: item.creatime,
            section: item.section
          };
          this.tableData.push(tableItem);
        });
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      var params = {
        section: this.section,
        id: this.id,
        author: this.author,
        multmedia: this.multmedia,
        text: this.text,
        creatime: this.creatime,
        page: val
      };
      listPost(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            id: item.id,
            author: item.author,
            multmedia: item.multmedia,
            text: item.text,
            creatime: item.creatime,
            section: item.section
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


