<template>
  <div>
    <a-layou>
      <Header></Header>
      <Banner></Banner>
      <div id="components-grid-demo-playground">
        <a-row>
          <a-col :span="24">
            <div class="banner">
              <h1>FinClaw花旗杯项目</h1>
            </div>
          </a-col>
        </a-row>
        <div class="projects">
          <a-row :gutter="[6, 2]" style="width: 100%">
            <a-col
              v-for="item in 12"
              :key="item.toString()"
              :span="24 / colCount"
            >
              <div>
                <a-card hoverable style="width: 300px">
                  <img
                    slot="cover"
                    alt="example"
                    src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                  />
                  <a-card-meta title="Europe Street beat">
                    <template slot="description"> 花旗餐饮行业信用预测项目 </template>
                  </a-card-meta>
                </a-card>
              </div>
            </a-col>
          </a-row>
        </div>
      </div>
    </a-layou>

    <el-container>
      

      <el-main style="height: 20%; margin-bottom: 3%">
        <el-row type="flex" justify="center" style="margin-top: 30%">
          <el-col :span="20">
            <el-carousel :interval="4000" type="card" height="400px">
              <el-carousel-item v-for="item in 6" :key="item">
                <el-row type="flex" justify="center" style="margin-top: 20px">
                  <el-col :span="5" style="text-align: center">
                    <el-image
                      :src="logo_url"
                      style="height: 100px; width: 100px"
                    ></el-image>
                  </el-col>
                </el-row>

                <el-row type="flex" justify="center">
                  <el-col :span="4" style="text-align: center; font-size: 24px">
                    FinClaw8
                  </el-col>
                </el-row>

                <el-row type="flex" justify="center">
                  <el-col
                    :span="18"
                    style="text-align: center; font-size: 24px"
                  >
                    <div>
                      FinClaw8的产品非常好用！是一款全新的，前所未有的智能风控平台，帮助我解决了客户标签不足，画像不全面的问题，还帮我解决了优化贷款策略的问题！非常赞！
                    </div>
                  </el-col>
                </el-row>

                <el-row type="flex" justify="center" style="margin-top: 20px">
                  <el-col :span="4" style="text-align: center">
                    <el-rate value="5" disabled text-color="#ff9900"> </el-rate>
                  </el-col>
                </el-row>
              </el-carousel-item>
            </el-carousel>
          </el-col>
        </el-row>
      </el-main>

      <!-- 页脚 -->
      <el-footer style="height: 365px">
        <el-row :gutter="24" class="footer-row">
          <el-col :span="4" offset="6">
            <span style="font-size: 24px">帮助中心</span>
            <br />

            <span style="font-size: 16px"
              ><a href="https://github.com/garyGlh/FinClaw"> 版本更新 </a><br />
              <a href="https://github.com/garyGlh/FinClaw"> 联系我们</a>
            </span>
          </el-col>
          <el-col :span="4" offset="6" class="footer-pic">
            <el-image
              style="height: 100px; width: 100px"
              :src="logo_url"
            ></el-image>
          </el-col>
        </el-row>
        <br />
        <el-row :gutter="24">
          <el-col :span="4" :offset="6">
            <span style="font-size: 16px">©NJU FinClaw8</span>
          </el-col>
        </el-row>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import Header from "@/components/header";
import Banner from "@/components/banner";
export default {
  name: "home",
  data() {
    return {
      logo_url:
        "https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/finclaw_logo.png",
      colCount: 4,
    };
  },
  methods: {
    goToLogin() {
      this.$router.push("/login");
    },
    goToRegister() {
      this.$router.push("/register");
    },
  },
  components: {
    Header,
    Banner,
  },
};
</script>


<style scoped>
.el-header {
  /* background-color: #a191fc; */
  color: rgb(255, 255, 255);
  text-align: right;
  /* line-height: 60px; */
}

.el-footer {
  height: 100%;
  background-color: #000;
  color: rgb(255, 255, 255);
}

.el-container {
  padding-bottom: 1px;
}

.el-main {
  /* background-color: #E9EEF3; */
  color: #333;
  height: 5200px;
}

#header {
  text-align: right;
}

.footer-row {
  margin-top: 30px;
  line-height: 40px;
}
</style>

<style scoped>
.threeCard {
  height: 250px;
}

.threeCard div {
  text-align: left;
}

.bottom {
  line-height: 12px;
  bottom: 18px;
  position: absolute;
}

.button {
  padding: 0;
  float: left;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
</style>

<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>

<style scoped>
.section1 {
  /* background-image: url(https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/section02.png); */
  /* background-image: url(../assets/UI-4.png); */
  /* background-repeat: no-repeat;*/
  /* background-position: center center; */
  /*background-size: 100% auto;*/
}

.header-button {
  margin-left: 3%;
  background-color: transparent;
  color: white;
  border: 0;
  font-size: 180%;
}

.header-button:hover {
  background-color: white;
  color: #a191fc;
}

.button2 {
  /* height:40%; */
  font-size: 222%;
  background-color: #a191fc;
  border: 0;
  color: white;
}

.button2:hover {
  background-color: white;
  color: #a191fc;
}

/****** */

#components-grid-demo-playground .projects {
  display: flex;
  align-content: center;
}
#components-grid-demo-playground [class~="ant-col"] {
  background: transparent;
  border: 0;
}
#components-grid-demo-playground [class~="ant-col"] > div {
  /*background: #00a0e9;*/
  height: 300px;
  line-height: 300px;
  font-size: 13px;
}
#components-grid-demo-playground [class~="ant-col"] > .banner {
  background: transparent no-repeat 50%;
  background-image: url("https://demo.doublechaintech.com/demodata/imageManager/loadImage/doublechainhome0000/400/300/red/");

  margin: 0 auto;
  background-size: cover;
  text-align: center;
  min-height: 420px;
}
h1 {
  font-size: 52px;
  color: rgba(255, 255, 255, 0.9);
  letter-spacing: 8px;
}
#components-grid-demo-playground pre {
  background: #f9f9f9;
  border-radius: 6px;
  font-size: 13px;
  padding: 8px 16px;
}
</style>