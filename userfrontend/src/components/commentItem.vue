<template>
  <div>
  <li @mouseover="modShow" @mouseout="modShow">
    <a style="font-size: 14px;font-weight:bold">{{cmtuser}}</a>&nbsp;&nbsp;
    <span style="font-size: 13px;">{{cmttext}}</span>&nbsp;&nbsp;
    <a  @click="modLike"><span v-show="show" class="likeorcom" v-bind:style="{'font-weight': like?'bold':'normal','color': like?'red':'grey'}">赞</span></a>
    <a @click="modComplaint"><span v-show="show" class="likeorcom" v-bind:style="{'font-weight': complaint?'bold':'normal', 'color': complaint?'black':'grey'}">举报</span></a>
  </li>
  </div>
</template>

<script>
export default {
  props:['cmtuser','cmttext'],
  data() {
      return {
          show: false,
          like: false,
          complaint: false,
      }
  },
  methods: {
      modShow () {
          this.show = !this.show
      },
      modLike () {
          this.like = !this.like
      },
      modComplaint () {
          this.complaint = !this.complaint
      }

  }
}
</script>

<style>
.likeorcom{
    font-size: 5px;
}
</style>
