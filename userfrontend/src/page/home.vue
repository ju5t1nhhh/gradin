<template>
  <div>
    <headTop></headTop>
    <div style="background-color: ghostwhite;width: 100%;height: 5000px;">
            <!--box1-->
            <homeItem></homeItem>
            <homeItem></homeItem>
            <homeItem></homeItem>
            <homeItem></homeItem>
        <!--box2-->
            <div style="width: 22.5%;height: 600px;position: fixed;left: 63%;top:150px;">
            <div style="width: 300px;height:80px;">
                <a><img src="../style/pics/3.jpg" style="width: 50px;height: 50px;border-radius: 25px; position: relative; left: 20px; top: 15px;"></a>
                <a><span style="font-size: 14px; position: relative; left: 30px;bottom:15px;">我的用户名</span></a>
                <a><p style="font-size: 13px; color: silver;font-weight: bold; position: relative; left: 85px; bottom:10px;">我的名字</p></a>
            </div>
            <div style="width:300px; height: 350px; border-top: 1px gainsboro solid;border-bottom: 1px gainsboro solid;overflow:auto;">
                <span style="font-size: 13px;position: relative;left: 20px;color: darkgrey; font-weight: bold">快拍</span>
                <span style="position: relative; left: 200px; font-size: 13px;font-weight: bold">全部播放</span>
                <div style="width: 300px;height: 80px;"  >
                    <a><img src="../style/pics/3.jpg" style="width: 50px;height: 50px;border-radius: 25px;position: relative;left: 20px;top:20px;"></a>
                    <a><span style="font-size: 13px;font-weight: bold;position: relative; left: 35px;bottom: 15px;">我关注的人的账号</span></a>
                    <a><p style="font-weight: bold;font-size: 13px;color: darkgrey; position: relative;left: 90px;bottom: 10px;">我关注的人的名字</p></a>
                </div>
                <div style="width: 300px;height: 80px;"  >
                    <a><img src="../style/pics/3.jpg" style="width: 50px;height: 50px;border-radius: 25px;position: relative;left: 20px;top:20px;"></a>
                    <a><span style="font-size: 13px;font-weight: bold;position: relative; left: 35px;bottom: 15px;">我关注的人的账号</span></a>
                    <a><p style="font-weight: bold;font-size: 13px;color: darkgrey; position: relative;left: 90px;bottom: 10px;">我关注的人的名字</p></a>
                </div>
                <div style="width: 300px;height: 80px;"  >
                    <a><img src="../style/pics/3.jpg" style="width: 50px;height: 50px;border-radius: 25px;position: relative;left: 20px;top:20px;"></a>
                    <a><span style="font-size: 13px;font-weight: bold;position: relative; left: 35px;bottom: 15px;">我关注的人的账号</span></a>
                    <a><p style="font-weight: bold;font-size: 13px;color: darkgrey; position: relative;left: 90px;bottom: 10px;">我关注的人的名字</p></a>
                </div>
                <div style="width: 300px;height: 80px;"  >
                    <a><img src="../style/pics/3.jpg" style="width: 50px;height: 50px;border-radius: 25px;position: relative;left: 20px;top:20px;"></a>
                    <a><span style="font-size: 13px;font-weight: bold;position: relative; left: 35px;bottom: 15px;">我关注的人的账号</span></a>
                    <a><p style="font-weight: bold;font-size: 13px;color: darkgrey; position: relative;left: 90px;bottom: 10px;">我关注的人的名字</p></a>
                </div>
                <div style="width: 300px;height: 80px;"  >
                    <a><img src="../style/pics/3.jpg" style="width: 50px;height: 50px;border-radius: 25px;position: relative;left: 20px;top:20px;"></a>
                    <a><span style="font-size: 13px;font-weight: bold;position: relative; left: 35px;bottom: 15px;">我关注的人的账号</span></a>
                    <a><p style="font-weight: bold;font-size: 13px;color: darkgrey; position: relative;left: 90px;bottom: 10px;">我关注的人的名字</p></a>
                </div>
            </div>
        </div>
    </div>

  </div>    
</template>


<script>
import headTop from "../components/headTop";
import exploreItem from "../components/exploreItem";
import homeItem from "../components/homeItem";
export default {
  data() {
    return {
      cho: 0,
      loading: false,
      phk: "none",
      photourl:
        "http://www.embeddedlinux.org.cn/uploads/allimg/161125/101RA2C-5.jpg"
    };
  },
  components: {
    headTop,
    exploreItem,
    homeItem,
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