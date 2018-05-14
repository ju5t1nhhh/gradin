<template>
<div>
    <div class="infor-show"  v-loading="loading" @mouseover="moph" @mouseout="moph">
        <a>
            <img v-bind:src="fphoto">
            <div class="layer" v-bind:style="{display:ph}" >
            </div>
            <div class="description" v-bind:style="{display:ph}">
                <i class="iconfont6">&#xe608; <span>{{likes}}</span></i>&nbsp;&nbsp;&nbsp;&nbsp;
                <i class="iconfont5">&#xea5a; <span>{{comments}}</span></i>
            </div>
        </a>
    </div>
</div>
</template>

<script>
export default {
  data() {
    return {
      ph: "none",
    };
  },
  components: {
  },
  props: ["fphoto", "likes", "comments","phk",'loading'],
  methods: {
    moph() {
      this.ph = this.ph == "none" ? "block" : "none";
    },
  },
  mounted() {}
};
</script>