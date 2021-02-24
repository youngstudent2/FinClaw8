<template>
  <div>
    <a-layout>
      <Header></Header>
      <Banner></Banner>
      <div id="components-grid-demo-playground">
        <div
          class="projects"
          style="
            margin: 2px auto;
            width: 80%;
            background: white;
            padding-top: 30px;
          "
        >
          <a-row>
            <a-col :span="12" :offset="1">
              <h2>目前已有<em>323</em>个训练项目</h2>
            </a-col>
            <a-col :span="2" :offset="9">
              <a style="line-height: 40px" @click="shuffleProjects"
                >查看更多
                <a-icon type="right" />
              </a>
            </a-col>
          </a-row>

          <a-row :gutter="[4, 2]">
            <a-col
              v-for="(p,index) in projects"
              :key="index.toString()"
              :span="24 / colCount"
            >
              <div>
                <router-link
                  tag="detail"
                  :to="{ name: 'detail', params: { projectId: 1 } }"
                >
                  <a-card hoverable style="width: 300px">
                    <img
                      slot="cover"
                      alt="example"
                      :src="p.image"
                    />
                    <div class="mask"><em>@FinClaw8</em></div>
                    <a-icon type="line-chart" style="float: right"></a-icon>
                    <a-card-meta
                      :title="p.title"
                      :description="p.description"
                    >
                    </a-card-meta>
                    <div class="meta-info">
                      <a-row :gutter="[0,0]">
                        <a-col :span="12"
                          ><a-tag :color="p.color" 
                            >{{p.creator}}</a-tag
                          ></a-col
                        >
                        <a-col :span="10" :offset="2">
                          <a-icon type="calendar" />
                          <span class="meta-date">{{p.createdAt}}</span>
                        </a-col>
                      </a-row>
                    </div>
                  </a-card>
                </router-link>
              </div>
            </a-col>
          </a-row>
        </div>
      </div>
    </a-layout>

    <el-container>
      <el-main style="height: 100%; margin-bottom: 3%">
        <el-row type="flex" justify="center" style="margin-top: 5%">
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
      <el-footer style="height: 180px">
        <el-row :gutter="10" class="footer-row">
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
        <el-row :gutter="10">
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
      projects: [],
      shuffleTime : 0,
    };
  },
  mounted() {
    this.shuffleProjects()
    console.log("projects:",this.projects)
  },
  methods: {
    goToLogin() {
      this.$router.push("/login");
    },
    goToRegister() {
      this.$router.push("/register");
    },

    shuffleProjects() {
      const orgNames = ["花旗银行","工商银行","农业银行","建设银行","上海银行"]
      const colors = ['pink','orange','red','cyan','blue']
      let orgs = []
      for(let i=0;i<orgNames.length;i++) orgs.push({name:orgNames[i],color:colors[i]})
      const industries = ["餐饮","自动化","印刷业","新能源","互联网","服装","自媒体"]
      const imageUrls = [
        "https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png",
        "https://image.tianyancha.com/462d55f16d254aba84e9e759e699b087.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/265428e96b1e400986f58d0c492aef72.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/4e05cfc4c6254569a6a219d455ce794d.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/3b49a87d9bf74884b9e7b739bb3b5f6e.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/2de12f1756eb457b85755c69313e8007.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/ac34744af238437e941dbb4b9302fa6c.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/3fb4a6b5dcc24940aea83f23a3cccce7.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/521dd0e0891d49938cae2986d468afb0.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/fae09e7374f44f40865bebfe6ef59a01.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/e4234fc1e6bd49c8a6c8ddf6fbb27d72.jpg@!hotNews_f_273x171",
        "https://image.tianyancha.com/29479646109a4d489be6817824e6c740.jpg@!hotNews_f_273x171",
      ]
      const projectNum = 8
      var tmpProjects = []
      for (let i=0;i<projectNum;++i) {
        let tmpProject = {}
        let o = this.randomChoice(orgs)
        tmpProject.creator = o.name
        tmpProject.color = o.color
        tmpProject.industry = this.randomChoice(industries)
        tmpProject.createdAt = this.getRandomDate() 
        tmpProject.description = "为中小微企业提供高效、便携的融资服务"
        tmpProject.title = tmpProject.creator.substring(0,2) +tmpProject.industry+"行业训练项目"
        tmpProject.image = imageUrls[(i+8*this.shuffleTime)%imageUrls.length]
        tmpProjects.push(tmpProject)
      }
      this.shuffleTime++
      this.projects = tmpProjects
      // may need force to update
    },
    getRandomDate() {
      let minDate = new Date(2020,9,20,8).getTime()
      let maxDate = new Date().getTime()
      let randomDate = this.getRandom(minDate,maxDate)
      return this.$moment(randomDate).format("YYYY-MM-DD")
    },
    getRandom(min,max) {
      min = Math.ceil(min)
      max = Math.floor(max)
      return Math.floor(Math.random() * (max - min + 1)) + min;
    },
    randomChoice(array) {
      return array[Math.round(Math.random()*(array.length-1))]
    }
  },
  computed: {
    
  },
  components: {
    Header,
    Banner,
  },
};
</script>


<style scoped>
.mask{
  width: 75px;
  height: 30px;
  line-height: 30px; 
  background-color:rgba(255, 255, 255, 0.54);
  border-radius: 30px;
  position: absolute;
  margin-top: -60px;
  margin-left:199px;
  font-weight: bold; 
}
.el-header {
  /* background-color: #a191fc; */
  color: rgb(255, 255, 255);
  text-align: right;
  /* line-height: 60px; */
}

.el-footer {
  height: 100%;
  background-color: rgba(0, 0, 0, 0.575);
  color: rgb(255, 255, 255);
}

.el-container {
  padding-bottom: 1px;
}

.el-main {
  /* background-color: #E9EEF3; */
  color: #606266;

}

#header {
  text-align: right;
}

.footer-row {
  margin-top: 20px;
  line-height: 30px;
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

<style lang="less" scoped>
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
  flex-direction: column;
  align-content: center;
}
#components-grid-demo-playground [class~="ant-col"] {
  background: transparent;
  border: 0;
}
#components-grid-demo-playground [class~="ant-col"] > div {
  /*background: #00a0e9;*/
  line-height: 300px;
  font-size: 13px;
}

h1 {
  font-size: 52px;
  color: rgba(255, 255, 255, 0.9);
  letter-spacing: 8px;
}

h2 {
  font-size: 30px;
  color: #333333;
  line-height: 40px;
  font-weight: bold;
  em {
    color: #409eff;
  }
}

.meta-info{
  margin:10px auto -10px auto;
}
#components-grid-demo-playground pre {
  background: #f9f9f9;
  border-radius: 6px;
  font-size: 13px;
  padding: 8px 16px;
}
</style>