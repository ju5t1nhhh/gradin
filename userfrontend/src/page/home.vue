<template>
  <div>
    <headTop></headTop>
    <div style="background-color: ghostwhite;width: 100%;height: 5000px;">
            <!--box1-->
            <homeItem :items="items1" :id="'r4j_justin'" :avatar="'http://localhost:8082/1526447659202.jpg'"></homeItem>
            <homeItem :items="items2" :id="'cool_it'" :comments="comments" :avatar="'http://localhost:8082/1.jpg'"></homeItem>
            <homeItem :items="items3" :id="'samsuil'" :avatar="'http://localhost:8082/4.jpg'"></homeItem>
        <!--box2-->
            <div style="width: 22.5%;height: 600px;position: fixed;left: 63%;top:150px;">
            <div style="width: 300px;height:80px;">
                <a><img src="../style/pics/2.jpg" style="width: 50px;height: 50px;border-radius: 25px; position: relative; left: 20px; top: 15px;"></a>
                <a><span style="font-size: 14px; position: relative; left: 30px;bottom:15px;font-weight:bold">r4j_justin</span></a>
                <!-- <a><p style="font-size: 13px; color: silver;font-weight: bold; position: relative; left: 85px; bottom:10px;">我的名字</p></a> -->
            </div>
            <div style="width:300px; height: 350px; border-top: 1px gainsboro solid;border-bottom: 1px gainsboro solid;overflow:auto;">
                <span style="font-size: 13px;position: relative;left: 20px;color: darkgrey; font-weight: bold">推荐用户</span>
                <!-- <span style="position: relative; left: 200px; font-size: 13px;font-weight: bold">全部播放</span> -->
                <homePreUser :avatar="'https://i.loli.net/2018/05/13/5af838855b18a.jpg'" :userid="'banana'"></homePreUser>
                <homePreUser :avatar="'https://scontent-hkg3-1.cdninstagram.com/vp/f8f59cab74ba87ed4871805d2b77c1cb/5B97F8C8/t51.2885-19/s150x150/27892221_1966350730297578_2927562134017540096_n.jpg'" :userid="'piggy'"></homePreUser>
                <homePreUser :avatar="'https://scontent-lax3-2.cdninstagram.com/vp/068faf48d3d03c40feb7a1917b8ce1dd/5B8B5A91/t51.2885-19/11324935_790690444363113_166122318_a.jpg'" :userid="'gem0816'"></homePreUser>
                <homePreUser :avatar="'https://scontent-lax3-2.cdninstagram.com/vp/090e049d4a12f969c999c38939d58a3c/5B77CF9F/t51.2885-19/s150x150/21147825_124638651514445_4540910313213526016_a.jpg'" :userid="'jaychou'"></homePreUser>
                <homePreUser :avatar="'https://scontent-lax3-2.cdninstagram.com/vp/3137fd8f71d16bdc4c16c886cfc318a8/5B94F50B/t51.2885-19/10956766_1091974014165886_1814279444_a.jpg'" :userid="'jlin7'"></homePreUser>
            </div>
        </div>
    </div>

  </div>    
</template>

<script>
import headTop from "../components/headTop";
import exploreItem from "../components/exploreItem";
import homeItem from "../components/homeItem";
import homePreUser from "../components/homePreUser";
export default {
  data() {
    return {
      items1: ['http://localhost:8082/1526447209089.jpg',
              'http://localhost:8082/1526447211200.jpg',
              'http://localhost:8082/1526447213821.jpg'],
      items2: ['http://localhost:8082/1526447842494.jpg',
              'http://localhost:8082/1526447847320.jpg',
              'http://localhost:8082/1526447851322.jpg'],
      items3: ['http://localhost:8082/4.jpg','http://localhost:8082/5.jpg','http://localhost:8082/6.jpg',],
      comments: [
              {user:'justin123',text:'cool啊'},
              {user:'banana123',text:'ya蕉啦'},
              {user:'justin123',text:'@banana123 你ya'},
          ],
      cho: 0,
      loading: false,
      phk: "none",
      photourl: 'https://i.loli.net/2018/05/13/5af838855b18a.jpg'
    };
  },
  components: {
    headTop,
    exploreItem,
    homeItem,
    homePreUser,
  },
//   mounted() {},
//   methods: {
//     showCover(val) {
//       console.log("hello");
//       this.phk = val;
//     },
//     closeCover() {
//       this.phk = "none";
//     },
//     changeCho() {
//         this.cho = this.cho == 0 ? 1 : 0;
//     }
//   }
};
</script>