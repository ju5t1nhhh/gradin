<template>
    <div style="width: 300px;height: 80px;"  >
        <a @click="toUserPage"><img v-bind:src="avatar" style="width: 50px;height: 50px;border-radius: 25px;position: relative;left: 20px;top:20px;"></a>
        <a @click="toUserPage"><span style="font-size: 13px;font-weight: bold;position: relative; left: 35px;bottom: 15px;">{{userid}}</span></a>
        <a @click="changeStatus"><p style="font-weight: bold;font-size: 13px;color: darkgrey; position: relative;left: 90px;bottom: 10px;">{{status}}</p></a>
    </div>
</template>

<script>
export default {
  data() {
      return {
          status: '关注'
      }
  },
  props:['avatar','userid'],
  methods: {
      toUserPage() {
          this.$router.push("/user/"+this.userid)
      },
      changeStatus() {
          this.status = this.status == '关注' ? '已关注' : '关注';
      }
  }
}
</script>