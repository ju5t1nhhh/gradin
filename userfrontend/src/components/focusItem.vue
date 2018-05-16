<template>
  <div style="width: 100%;height: 60px; border-bottom: silver 1px solid">
    <img v-bind:src="avatar" style="width: 40px; height: 40px; border-radius: 20px; margin-left: 20px;margin-top: 10px;cursor: pointer">
    <span style="font-size: 13px;color: dimgrey;font-weight: bold;position: relative;bottom:20px;left: 14px;cursor: pointer">{{id}}</span>
    <!-- <span style="font-size: 13px;color: silver;font-weight: bold; position: relative;left: -18px; cursor: pointer">{{id}}</span> -->
    <div style="width: 50px;height: 20px;border: 1px silver solid;position: relative;left: 80%;bottom:30px;text-align: center;">
        <span @click="changeStatus" style="font-size: 13px; color: dimgrey;font-weight: bold;line-height: 20px;cursor: pointer">{{status}}</span>
    </div>
  </div>
</template>

<script>
export default {
  props:['avatar','id','status'],
  methods: {
    changeStatus() {
      this.status = this.status == '已关注' ? '关注' : '已关注';
    }
  }
}
</script>
