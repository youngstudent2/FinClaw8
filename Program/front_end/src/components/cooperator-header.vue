<template>
  <div class="myheader">
    <div class="label">
      <img
        :src="logo_url"
        class="logo"
        alt="logo"
        @click="jumpToHome"
      />
      <span class="title">NJU-FinClaw</span>
    </div>
    
    <div class="logout">
      <a-dropdown placement="bottomCenter">
        <div class="user">
          <a-avatar
            shape="square"
            size="large"
            :style="{ backgroundColor: randomColor, verticalAlign: 'middle' }"
          >
            {{ userInfo.username }}
          </a-avatar>
        </div>
        <a-menu slot="overlay">
          <a-menu-item @click="jumpToHome">
            <a-icon type="home"></a-icon>
            首页
          </a-menu-item>
          <a-menu-item @click="jumpToUserInfo">
            <a-icon type="profile"></a-icon>
            我的信息
          </a-menu-item>
          <a-menu-item @click="quit">
            <a-icon type="poweroff"></a-icon>
            退出登录
          </a-menu-item>
        </a-menu>
      </a-dropdown>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapActions, mapMutations } from "vuex";
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
export default {
  name: "cooperator-header",

  data() {
    return {
        logo_url: "https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/finclaw_logo.png"
    };
  },

  computed: {
    randomColor: function() {
      return colorList[Math.floor(Math.random()*colorList.length+1)-1]
    },
    ...mapGetters([
        "userId",
        "userInfo",
        "projectID",
        "projectData",
    ]),
  },
  async mounted() {

  },
  methods: {

    ...mapActions([
        "logout",
        "getUserInfo",
    ]),

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
        this.$router.push('/home')
    },

  },
};
</script>
<style scoped lang="less">
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  min-width: 800px;
  margin: 4px 0px;
  height: 70px;
  .label {
    height: 44px;
    line-height: 44px;
    vertical-align: middle;
    min-width: 700px;

    .logo {
      height: 44px;
      vertical-align: top;
      margin-right: 16px;
      border-style: none;
      cursor: pointer;
    }

    .title {
      font-size: 33px;
      color: rgba(255, 255, 255, 0.884);
      font-family: Avenir, "Helvetica Neue", Arial, Helvetica, sans-serif;
      font-weight: 600;
      position: relative;
      top: 2px;
    }

    .search {
      width: 300px;
      margin-left: 30px;
    }
  }

  .logout {
    margin-right: 40px;

    .user {
      cursor: pointer;
      display: flex;
      align-items: center;

      span {
        margin-left: 5px;
      }
    }
  }
}
</style>
<style lang="less">
.header {
  background: rgb(59, 59, 59);
}
</style>