<template>
  <div id="myheader">
    <el-menu
      class="el-menu"
      mode="horizontal"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="0" id="label">
        <img :src="logo_url" class="logo" alt="logo" @click="jumpToHome" />
      </el-menu-item>
      <el-menu-item index="1" @click="jumpToHome">首页</el-menu-item>
      <el-menu-item index="2" @click="jumpToCenter">管理中心</el-menu-item>
      <el-menu-item index="3"><h1 style="color:white">当前项目：花旗餐饮行业信用训练项目</h1></el-menu-item> 
      
      <el-menu-item
        id="loginBox"
        style="float: right; margin-left: 40px; cursor: pointer"
      >
        <template v-if="!userId">
          <el-button @click="jumpToLogin" type="primary" round>登录</el-button>
          <el-button @click="jumpToRegister" round>注册</el-button>
        </template>
        <template v-else>
          <el-dropdown id="user">
              <div><el-avatar :size="40" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></el-avatar>
            <i style="color:white;margin-left:5px">{{userInfo.username}}</i></div>
            

            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item @click="jumpToUserInfo">我的信息</el-dropdown-item>
              <el-dropdown-item style="color:red" @click="quit">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </template>
      </el-menu-item>

    </el-menu>

    
  </div>

</template>
<script>
import { mapGetters, mapActions, mapMutations } from "vuex";
export default {
  name: "detailHeader",
  data() {
    return {
      logo_url:
        "https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/finclaw_logo.png",
    };
  },
  components: {
    //AddProjectModal,
  },
  computed: {
    ...mapGetters([
      "userId",
      "userInfo",
      "projectID",
      "projectList",
      "projectInfo",
      "addProjectModalVisible",
    ]),
  },
  async mounted() {
    await this.getAllProject();
    if (this.projectID === null) {
      this.set_currentProject(this.projectList[0]);
      this.getProjectData({
        operatorID: Number(this.userId),
        projectID: this.projectID,
      });
    }
  },
  methods: {
    ...mapMutations(["set_addProjectModalVisible", "set_currentProject"]),
    ...mapActions(["logout", "getUserInfo", "getProjectData", "getAllProject"]),
    selectMenu(v) {},
    async quit() {
      await this.$store.dispatch("logout");
      await this.$router.push(`/login?redirect=${this.$route.fullPath}`);
    },
    jumpToUserInfo() {
      this.$router.push({
        name: "userInfo",
        params: {
          userId: Number(this.userId),
        },
      });
    },
    jumpToHome() {
      this.$router.push("/home");
    },
    jumpToLogin() {
      this.$router.push("/login");
    },
    jumpToRegister() {
      this.$router.push("/register");
    },
    jumpToCenter() {
      const r = this.userInfo.role
      if (r == "bank") {
        this.$router.push("/bank");
      }
      else if (r == "cooperator") {
        this.$router.push("/cooperator");
      }
      else if (r == "loaner") {
        this.$router.push("/loaner");
      }
      else if (r == "manager") {
        this.$router.push("/manager");
      }
      else if (r == "unathority") {
        alert("审核未通过，请等待审核通过")
      }
      else {
        alert("未登录，请先登录")
      }
    },

  },
};
</script>
<style scoped lang="less">
.support {
  display: flex;
  align-items: baseline;

  h2 {
    color: white;
    margin-right: 5px;
  }
  h5 {
    color: rgba(255, 255, 255, 0.808);
  }
}

#label {
  vertical-align: middle;
  text-align: center;
  .logo {
    height: 50px;
    margin-right: 16px;
    border-style: none;
    cursor: pointer;
  }

}


</style>
