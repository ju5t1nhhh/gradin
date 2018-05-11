<template>
    <div>
        <head-top></head-top>
		<section class="data_section">
			<header class="section_title">重要操作日志</header>
			<el-row>
				<el-col offset="2">
				<el-button round @click="flash" style="margin-bottom: 20px">刷新</el-button>
				<div class="table_container">
					<el-table
					:data="tableData"
					style="width: 80%">
					<el-table-column
						prop="admin"
						label="管理员ID"
						width="250">
					</el-table-column>
					<el-table-column
						prop="text"
						label="操作内容"
						>
					</el-table-column>
					<el-table-column
						prop="creatime"
						label="操作时间"
						>
					</el-table-column>
					</el-table>
					<div class="Pagination" style="text-align: left;margin-top: 10px;margin-left:-5px;">
						<el-row>
							<el-col span="2">
								<el-pagination
								@current-change="handleCurrentChange"
								:current-page="currentPage"
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
				</el-col>
			</el-row>
		</section>
    </div>
</template>

<script>
import headTop from "../components/headTop";
import tendency from "../components/tendency";
// import dtime from 'time-formater'
import { listLogrecord } from "@/api/getData";
export default {
  data() {
    return {
      tableData: [],
      currentPage: 1
    };
  },
  components: {
    headTop,
    tendency
  },
  mounted() {
    this.initData();
  },
  methods: {
    async initData() {
      try {
        const res = await listLogrecord(this.currentPage);
        if (res.code == 200) {
          this.tableData = [];
          res.data.forEach(item => {
            const tableItem = {
              admin: item.admin,
              text: item.text,
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
      listLogrecord(this.currentPage).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            admin: item.admin,
            text: item.text,
            creatime: item.creatime
          };
          this.tableData.push(tableItem);
        });
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      listLogrecord(val).then(res => {
        this.tableData = [];
        res.data.forEach(item => {
          const tableItem = {
            admin: item.admin,
            text: item.text,
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
.data_section {
  padding: 20px;
  margin-bottom: 40px;
  .section_title {
    text-align: center;
    font-size: 30px;
    margin-bottom: 10px;
  }
  .data_list {
    text-align: center;
    font-size: 14px;
    color: #666;
    border-radius: 6px;
    background: #e5e9f2;
    .data_num {
      color: #333;
      font-size: 26px;
    }
    .head {
      border-radius: 6px;
      font-size: 22px;
      padding: 4px 0;
      color: #fff;
      display: inline-block;
    }
  }
  .today_head {
    background: #ff9800;
  }
  .all_head {
    background: #20a0ff;
  }
}
.wan {
  .sc(16px, #333);
}
</style>
