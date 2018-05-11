<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-button round @click="flash" style="margin-left: 20px; margin-top: 20px">刷新</el-button>
        <el-row class="table_container">
            <el-col :span="5">
            <el-input placeholder="GINS码" v-model="pcode" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="用户ID" v-model="puser" clearable width="20"></el-input>
            </el-col>
            <el-col :span="3" :offset="1">
            <el-input placeholder="订单状态" v-model="pstatus" clearable width="20"></el-input>
            </el-col>
            <el-col :span="4" :offset="1">
                <el-date-picker v-model="ptime" type="date"
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
		        prop="code"
		        label="GINS码"
		        width="300">
		      </el-table-column>
		      <el-table-column
		        prop="user"
		        label="用户ID"
		        width="180">
		      </el-table-column>
              <el-table-column
		        prop="status"
		        label="订单状态"
		        width="180">
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
import { listPayments } from "@/api/getData";
export default {
  data() {
    return {
      pcode: "",
      pstatus: "",
      puser: "",
      ptime: "",
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
          code: this.pcode,
          user: this.puser,
          status: this.pstatus,
          creatime: this.ptime,
          page: this.currentPage
        };
        const res = await listPayments(params);
        if (res.code == 200) {
          this.tableData = [];
          res.data.forEach(item => {
            const tableItem = {
              code: item.code,
              user: item.user,
              status: item.status,
              creatime: item.creatime
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
        code: "",
        user: "",
        status: "",
        creatime: "",
        page: this.currentPage
      };
      listPayments(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            code: item.code,
            user: item.user,
            status: item.status,
            creatime: item.creatime
          };
          this.tableData.push(tableItem);
        });
      });
    },
    search() {
      var params = {
        code: this.pcode,
        user: this.puser,
        status: this.pstatus,
        creatime: this.ptime,
        page: this.currentPage
      };
      listPayments(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            code: item.code,
            user: item.user,
            status: item.status,
            creatime: item.creatime
          };
          this.tableData.push(tableItem);
        });
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      var params = {
        code: this.pcode,
        user: this.puser,
        status: this.pstatus,
        creatime: this.ptime,
        page: val
      };
      listPayments(params).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            code: item.code,
            user: item.user,
            status: item.status,
            creatime: item.creatime
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


