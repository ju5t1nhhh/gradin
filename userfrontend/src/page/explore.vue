<template>
  <div>
    <headTop></headTop>
    <div class="main-box">
        <div class="body-box">
            <h2 class="explore-nav">
                发现用户
                <a>
                    查看全部
                </a>
            </h2><!--发现用户-->
            <div class="explore-users">
                <div class="user">
                    <div class="head-shot">
                        <a><img src="../style/pics/2.jpg"></a>
                    </div>
                    <div class="user-id"><a>Justin123</a></div>
                    <div class="user-name">Justin</div>
                    <button>关注</button>
                </div>
                <div class="user">
                    <div class="head-shot">
                        <a><img src="../style/pics/1.jpg"></a>
                    </div>
                    <div class="user-id"><a>Judy123</a></div>
                    <div class="user-name">Judy</div>
                    <button>关注</button>
                </div>
                <div class="user">
                    <div class="head-shot">
                        <a><img src="../style/pics/3.jpg"></a>
                    </div>
                    <div class="user-id"><a>Banana123</a></div>
                    <div class="user-name">Banana</div>
                    <button>关注</button>
                </div>
            </div>
            <div class="explore-new">
                <h2 class="explore-information">探索</h2>
                <div class="line-item">
                    <div class="infor-show">
                        <a>
                            <img src="../style/pics/instagram/1.jpg">
                            <div class="layer" v-bind:style="{display:ph1}" >
                            </div>
                            <div class="description" v-bind:style="{display:ph1}">
                                <i class="iconfont6">&#xe608; <span>6666</span></i>&nbsp;&nbsp;&nbsp;&nbsp;
                                <i class="iconfont5">&#xea5a; <span>6666</span></i>
                            </div>

                        </a>
                    </div>
                    <div class="infor-show">
                        <a>
                            <img src="../style/pics/instagram/2.jpg">
                            <div class="layer">
                            </div>
                            <div class="description">
                                <i class="iconfont6">&#xe608; <span>6666</span></i>&nbsp;&nbsp;&nbsp;&nbsp;
                                <i class="iconfont5">&#xea5a; <span>6666</span></i>
                            </div>
                        </a>
                    </div>
                    <div class="infor-show">
                        <a>
                            <img src="../style/pics/instagram/3.jpg">
                            <div class="layer">
                            </div>
                            <div class="description">
                                <i class="iconfont6">&#xe608; <span>6666</span></i>&nbsp;&nbsp;&nbsp;&nbsp;
                                <i class="iconfont5">&#xea5a; <span>6666</span></i>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>    
</template>

<script>
import headTop from "../components/headTop";
// import jquery from "../style/jquery-1.12.4.min.js"
export default {
  data() {
    return {
		ph1: 'block',
	};
  },
  components: {
    headTop,
  },
  mounted() {
  }
};
</script>