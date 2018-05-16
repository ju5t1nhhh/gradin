<template>
  <div>
    <div class="cover" id="cover" style="display:block;" @click="closeCover">
        <div class="close" id="close" style="margin: 10px 20px 0 0" @click="closeCover">×</div>
    </div>
    <div style="width: 45%;height: 600px;background-color: white;position:absolute;z-index:99999;left:27.5%;top:20px;">
            <!--放 已关注 的盒子-->
            <div style="width: 100%;height: 40px;background-color: white;"><span style="font-size: 14px;color: dimgrey;font-weight: bold;line-height: 40px;margin-left: 20px;">已关注</span></div>
            <!--内容的盒子-->
            <div style="width: 100%;height: 560px;background-color: white;border-top: 2px silver solid; overflow: auto;">
                <focusItem :avatar="'https://scontent-hkg3-1.cdninstagram.com/vp/f8f59cab74ba87ed4871805d2b77c1cb/5B97F8C8/t51.2885-19/s150x150/27892221_1966350730297578_2927562134017540096_n.jpg'" :id="'piggy'" :status="'已关注'"></focusItem>
                <focusItem :avatar="'http://localhost:8082/2.jpg'" :id="'banana123'" :status="'已关注'"></focusItem>
                <focusItem :avatar="'http://localhost:8082/4.jpg'" :id="'kobe123'" :status="'已关注'"></focusItem>
            </div>
        </div>
  </div>
</template>

<script>
import focusItem from "./focusItem"
export default {
    components: {
        focusItem,
    },
    methods: {
        closeCover() {
            this.$emit('cclose')
        }
    }
}
</script>
