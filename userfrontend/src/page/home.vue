<template>
    <headTop></headTop>
</template>

<script>
import headTop from "../components/headTop";
export default{
  components: {
    headTop,
  }
}
// import tendency from "../components/tendency";
// import dtime from 'time-formater'
// import { listLogrecord } from "@/api/getData";
// export default {
//   data() {
//     return {
//       tableData: [],
//       currentPage: 1
//     };
//   },
//   components: {
//     headTop,
//     tendency
//   },
//   mounted() {
//     this.initData();
//   },
//   methods: {
//     async initData() {
//       try {
//         const res = await listLogrecord(this.currentPage);
//         if (res.code == 200) {
//           this.tableData = [];
//           res.data.forEach(item => {
//             const tableItem = {
//               admin: item.admin,
//               text: item.text,
//               creatime: item.creatime
//             };
//             this.tableData.push(tableItem);
//           });
//         } else {
//           throw new Error(res.message);
//         }
//       } catch (err) {
//         console.log("获取数据失败", err);
//       }
//     },
//     flash() {
//       listLogrecord(this.currentPage).then(res => {
//         this.tableData = [];
//         res.data.forEach(item => {
//           const tableItem = {
//             admin: item.admin,
//             text: item.text,
//             creatime: item.creatime
//           };
//           this.tableData.push(tableItem);
//         });
//       });
//     },
//     handleCurrentChange(val) {
//       this.currentPage = val;
//       listLogrecord(val).then(res => {
//         this.tableData = [];
//         res.data.forEach(item => {
//           const tableItem = {
//             admin: item.admin,
//             text: item.text,
//             creatime: item.creatime
//           };
//           this.tableData.push(tableItem);
//         });
//       });
//     }
//   }
// };
</script>

<style>
@import "../style/explore.css"
</style>