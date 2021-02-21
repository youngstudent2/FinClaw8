<template>
  <a-layout>
    <Header></Header>

    <div style="align: center">
      <div id="write" class="first-line-indent" style="width: 1000px">
        <h1>
          <a name="花旗餐饮行业信用训练项目" class="md-header-anchor"></a
          ><span>花旗餐饮行业信用训练项目</span>
        </h1>
        <p>&nbsp;</p>
        <figure>
          <table>
            <thead>
              <tr>
                <th style="text-align: center"><span>发起方</span></th>
                <th style="text-align: center"><span>发起时间</span></th>
                <th style="text-align: center"><span>目前参与组织数</span></th>
                <th style="text-align: center"><span>状态</span></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td style="text-align: center"><span>花旗银行</span></td>
                <td style="text-align: center"><span>2021/2/9</span></td>
                <td style="text-align: center"><span>240</span></td>
                <td style="text-align: center"><span>待训练</span></td>
              </tr>
            </tbody>
          </table>
        </figure>
        <h2><a name="介绍" class="md-header-anchor"></a><span>介绍</span></h2>
        <h3>
          <a name="花旗银行" class="md-header-anchor"></a><span>花旗银行</span>
        </h3>
        <p>
          <img
            src="https://online.citi.com/GFC/branding/img/redesigned/citilogoredesign.png"
            style="zoom: 150%"
          />
        </p>
        <p>
          <span
            >花旗银行是花旗集团旗下的一家零售银行，其主要前身是1812年6月16日成立的“纽约城市银行”，经过近两个世纪的发展、并购，已经成为美国最大的银行之一，也是一家在全球近一百五十个国家及地区设有分支机构的国际大银行。</span
          >
        </p>
        <h3>
          <a name="餐饮行业" class="md-header-anchor"></a><span>餐饮行业</span>
        </h3>
        <p>
          <img
            src="https://img3.qianzhan.com/news/202101/28/20210128-1f043cd86f07c5f8.png"
            referrerpolicy="no-referrer"
          />
        </p>
        <p>
          <span
            >根据国家统计局数据显示，近年来，中国餐饮业市场规模持续壮大，2011年突破2万亿，2015年突破3万亿，2018年更是突破4万亿，达到4.27万亿，占国民经济产值的4.7%。2019年餐饮行业收入为4.7万亿，同比增长9.4%。尽管近年来增速有所下滑，2019年为9.4%，但仍远高于GDP增速。受疫情影响，2020年我国餐饮行业收入有所下降，为3.95万亿元，同比下降16.6%</span
          >
        </p>
        <p>
          <span
            >因此为帮助小微企业度过此次疫情危机，开展餐饮行业信用训练项目为后续花旗银行对餐饮行业提供贷款帮助有着至关重要的作用。</span
          >
        </p>
        <h3>
          <a name="对于借贷者" class="md-header-anchor"></a
          ><span>对于借贷者</span>
        </h3>
        <p>
          <span
            >花旗银行的餐饮信用贷是花旗银行为广大中小微餐饮企业提供的线上流动资金贷款服务。企业从申请至提款全部在线完成，无需抵质押，额度立等可见，资金分钟到账，按日计息，随借随还，以科技金融为中小微企业提供高效编写的融资服务</span
          >
        </p>
        <p>
          <img
            src="https://i.loli.net/2021/02/09/IL7R8JjZCSsghDa.png"
            alt="qrcode01"
            style="zoom: 33%"
          />
        </p>
        <p>
          <img
            src="https://i.loli.net/2021/02/09/CN6yr5MXRf4dQwK.png"
            referrerpolicy="no-referrer"
            alt="image-20210209201101338"
          />
        </p>
        <h3><a name="声明" class="md-header-anchor"></a><span>声明</span></h3>
        <blockquote>
          <ul>
            <li>
              <span
                >花旗银行（中国）有限公司的各分支行作为保险公司之保险兼业务代理只限于代理销售保险产品，保险产品由保险公司发行与管理。花旗银行（中国）有限公司及其各分支行概不负责有关保险产品的投资、对付、风险管理、承保、退保及保险理赔等事宜或对此承担任何责任</span
              >
            </li>
            <li>
              <span
                >保险公司为保险产品的承包人，全面负责一切保险及理赔等相关事宜。本材料中设计的保险产品具体特征及条款以保险公司出具的保单条款及保险合同为准</span
              >
            </li>
            <li>
              <span
                >保险产品由保险公司全权负责，并非银行存款，且花旗银行（中国）有限公司、花旗集团或任何其关联公司或子公司不对保险产品承担任何保证责任</span
              >
            </li>
            <li>
              <span
                >前述所提及的带*号的增值服务由保险公司或第三方负责提供并承担责任，以其届时实际提供的具体活动内容为准。</span
              >
            </li>
            <li><span>中英文如有歧义，应以中文为准。</span></li>
          </ul>
        </blockquote>
      </div>
    </div>
    <div class="add">
      <el-button type="primary" @click="attend"
        >加入<i class="el-icon-bottom-right el-icon--right"></i
      ></el-button>
    </div>
  </a-layout>
</template>

<script>
import Header from "@/components/detail-header";
import { mapGetters, mapActions, mapMutations } from "vuex";
export default {
  computed: {
    ...mapGetters(["userId", "userInfo"]),
  },
  components: {
    Header,
  },
  data() {
    return {};
  },
  mounted() {},
  methods:{
    ...mapActions(["attendProject"]),
    attend() {
      let r = this.userInfo.role
      console.log("attend the project")
      if (r == "Bank"){

      }
      else if (r == "DataProvider") {
        const params = {
          projectID:this.$route.params.projectId,
          cooperationID:this.userId
        }
        console.log(params)
        this.attendProject(params)
      }
      else {
        alert("权限不足")
      }
    }
  }
};
</script>
<style scoped src="../assets/css/vue.css"></style>
<style scoped>
.add {
  position: fixed; 
  left:100px;
  top:100px;

}
</style>