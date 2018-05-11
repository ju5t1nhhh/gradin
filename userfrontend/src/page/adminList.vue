<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="flash" style="margin-left: 20px; margin-top: 20px">刷新</el-button>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 50%">
		      <el-table-column
		        prop="loginId"
		        label="登录ID"
		        width="250">
		      </el-table-column>
		      <el-table-column
		        prop="role"
		        label="角色"
		        >
		      </el-table-column>
		    </el-table>
        </div>
    </div>
</template>

<script>
import headTop from "../components/headTop";
import { listAdmins } from "@/api/getData";
export default {
  data() {
    return {
      tableData: [],
      currentRow: null,
      offset: 0,
      limit: 20,
      count: 0,
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
        const res = await listAdmins();
        if (res.code == 200) {
          this.tableData = [];
          res.data.forEach(item => {
            const tableItem = {
              loginId: item.loginId,
              role: item.role
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
      listAdmins().then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            loginId: item.loginId,
            role: item.role
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


