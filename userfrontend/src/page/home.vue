<template>
  <div>
    <headTop></headTop>
    <div style="position:absolute;left:10%;width:80%;height:300px;background-color:red;">
      <div>
        <div style="position:absolute;top:130px;left:180px;">
            <img style="height:150px;width:150px;border-radius:100px;" src="../style/pics/1.jpg">
        </div>
        <div style="height:150px;width:400px;background-color:pink;position:absolute;left:370px;top:130px;">
          <div>
            <span style="font-size:30px;font-weight:300;">r4j_justin</span>
            <button style="width:100px;height:30px;margin-left:30px">我的设置</button>
          </div>
          <div style="margin:10px 0 10px 0">
            <span style="font-weight:bold;">14</span>贴子
            <span style="font-weight:bold;">15</span>关注者
            <span style="font-weight:bold;">18</span>正在关注
          </div>
          <div>
            <span style="font-weight:bold;">alksjdlkajsdlkjalskdj</span>
          </div>
        </div>
      </div>
    </div>
    <div style="position:absolute;left:10%;width:80%;background-color:yellow;top:330px;height:300px;">

    </div>
  </div>    
</template>

<script>
import headTop from "../components/headTop";
export default {
  data() {
    return {};
  },
  components: {
    headTop,
  },
  mounted() {
  }
};
</script>