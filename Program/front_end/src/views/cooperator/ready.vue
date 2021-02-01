<template>
  <div>
    <div style="height: 200px">
      <a-descriptions title="注意事项" bordered>
        <a-descriptions-item label="部署说明" >
            <p style="text-align:left">
          1、请在您的私有服务器部署的FinClaw网站上上传训练数据集<br />
          2、待训练数据集将会在您的服务器本地对模型进行训练<br />
          3、请确保服务器账号配置无误后点击下方准备按钮<br />
            </p>
        </a-descriptions-item>


      </a-descriptions>
    </div>
    <a-button v-bind:disabled="notReady" type="primary" @click="ready">
      <span v-if="notReady"> 已准备 </span>
      <span v-else> 准备好了 </span>
    </a-button>
  </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from "vuex";
export default {
  data() {
    return {
      notReady: false,
    };
  },
  computed : {
    ...mapGetters([
      'userInfo'
    ])
  },
  methods: {
    ...mapActions(["setReady"]),
    ready() {
      const projectID = this.$route.params.projectID;
      console.log("ready:" + projectID);
      this.notReady = true;
      this.setReady({ cooperationID: this.userInfo.cooperationID, projectID: projectID });
    },
  },
};
</script>

<style>
</style>