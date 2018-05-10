<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="flash" style="margin-left: 20px; margin-top: 20px">刷新</el-button>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 70%">
		      <el-table-column
		        prop="id"
		        label="板块ID"
		        width="120">
		      </el-table-column>
		      <el-table-column
		        prop="name"
		        label="板块名称"
		        width="180">
		      </el-table-column>
          <el-table-column
		        prop="intro"
		        label="板块介绍"
		        >
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
import { listSection } from "@/api/getData";
export default {
  data() {
    return {
      id: "",
      name: "",
      intro: "",
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
          page: this.currentPage
        };
        const res = await listSection(params);
        if (res.code == 200) {
          this.tableData = [];
          res.data.forEach(item => {
            const tableItem = {
              id: item.id,
              name: item.name,
              intro: item.intro
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
      this.currentPage = 1;
      var params = {
        id: "",
        name: "",
        intro: "",
        page: this.currentPage
      };
      listSection(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            id: item.id,
            name: item.name,
            intro: item.intro,
            page: item.currentPage
          };
          this.tableData.push(tableItem);
        });
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      var params = {
        id: this.id,
        name: this.name,
        intro: this.intro,
        page: val
      };
      listSection(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            id: item.id,
            name: item.name,
            intro: item.intro
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
