<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="flash" style="margin-left: 20px; margin-top: 20px">刷新</el-button>

        <div class="table_container" v-if="isShow">
            <el-table
		      :data="tableData"
		      style="width: 90%">
		      <el-table-column
		        prop="id"
		        label="板块ID"
		        width="300">
		      </el-table-column>
		      <el-table-column
		        prop="name"
		        label="板块名称"
		        width="180">
		      </el-table-column>
          <el-table-column
		        prop="intro"
		        label="板块介绍"
		        width="180">
		      </el-table-column>
          <el-table-column
		        prop="url"
		        label="板块地址"
		        width="180">
		      </el-table-column>
          <el-table-column
		        label="查看敏感词"
		        width="180">
            <template slot-scope="scope">
              <el-button @click.native.prevent="showSW(scope.$index, tableData)" type="text" size="small">查看</el-button>
            </template>
		      </el-table-column>
		    </el-table>
        </div>
        <div class="table_container" v-else>
            <el-table
		      :data="tableData"
		      style="width: 80%">
		      <el-table-column
		        prop="section"
		        label="板块ID"
		        width="300">
		      </el-table-column>
		      <el-table-column
		        prop="word"
		        label="敏感词"
		        width="180">
		      </el-table-column>
          <el-table-column
		        prop="replace"
		        label="替换词">
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
import headTop from "../components/headTop";
import { listSection, listSW } from "@/api/getData";
export default {
  data() {
    return {
      isShow: true,
      id: "",
      name: "",
      intro: "",
      url: "",
      tableData: [],
      currentRow: null,
      currentPage: 1
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
          id: this.id,
          name: this.name,
          intro: this.intro,
          url: this.url,
          page: this.currentPage
        };
        const res = await listSection(params);
        if (res.code == 200) {
          this.tableData = [];
          res.data.forEach(item => {
            const tableItem = {
              id: item.id,
              name: item.name,
              intro: item.intro,
              url: item.url
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
    flash() {
      this.isShow = true;
      this.currentPage = 1;
      var params = {
        id: "",
        name: "",
        intro: "",
        url: "",
        page: this.currentPage
      };
      listSection(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            id: item.id,
            name: item.name,
            intro: item.intro,
            url: item.url,
            page: item.currentPage
          };
          this.tableData.push(tableItem);
        });
      });
    },
    showSW(index, rows) {
      this.isShow = false;
      let params = {
        id: "",
        name: "",
        intro: "",
        url: ""
      };
      let section = rows[index].id;
      listSW(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            section: item.section,
            word: item.word,
            replace: item.replace
          };
          if (tableItem.section === section) {
            this.tableData.push(tableItem);
          }
        });
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      var params = {
        id: this.id,
        name: this.name,
        intro: this.intro,
        url: this.url,
        page: val
      };
      listSection(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            id: item.id,
            name: item.name,
            intro: item.intro,
            url: item.url
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
