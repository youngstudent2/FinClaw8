<template>
    <div class="header">
        <div class="label">
            <img
                :src="logo_url"
                class="logo"
                alt="logo"
                @click="jumpToHome"
            />
            <span class="title">NJU-FinClaw</span>
        </div>

        <div class="operation">
            <div>
                <span :style="{ fontSize: '16px', color: '#fff' }">当前：{{projectInfo.projectName}}</span>
            </div>
            <div style="margin-left: 20px">
                <a-menu mode="horizontal" :style="{ background: 'rgba(0,0,0,0)' }">
                    <a-sub-menu>
                        <span slot="title">
                            <a-icon
                                type="down-circle"
                                :style="{ fontSize: '16px', color: '#08c' }"
                            />
                            <span :style="{ fontSize: '16px', color: '#fff' }">切换项目</span>
                        </span>
                        <template v-for="project in projectList">
                            <a-menu-item :key="project" @click="changeProject(project)">
                                {{project.projectID}} {{project.projectName}}
                            </a-menu-item>
                        </template>
                    </a-sub-menu>
                </a-menu>
            </div>
            <div style="margin-left: 20px">
                <a-button type="link" :style="{ fontSize: '16px', background:'rgba(0,0,0,0)', color: '#08c'}" icon='plus-circle'  @click="add">
                    <span style="color: #fff">添加项目</span>
                </a-button>
            </div>
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
        <AddProjectModal></AddProjectModal>
    </div>
</template>
<script>
import { mapGetters, mapActions, mapMutations } from "vuex";
import AddProjectModal from "../views/project/components/addProjectModal";
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
export default {
    name: "header",
    inject: ['reload'],
    data() {
        return {
            logo_url: "https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/finclaw_logo.png",
        };
    },
    components: {
        AddProjectModal,
    },
    computed: {
        randomColor: function() {
            return colorList[Math.floor(Math.random()*colorList.length+1)-1]
        },
        ...mapGetters([
            "userId",
            "userInfo",
            "projectID",
            "projectList",
            "projectInfo",
            "addProjectModalVisible"
        ]),
    },
    async mounted() {
        await this.getAllProject()
        if (this.projectID === null) {
            this.set_currentProject(this.projectList[0])
            this.getProjectData({
                operatorID: Number(this.userId),
                projectID: this.projectID
            })
        }
    },
    methods: {
        ...mapMutations([
            "set_addProjectModalVisible",
            "set_currentProject"
        ]),
        ...mapActions([
            "logout",
            "getUserInfo",
            "getProjectData",
            "getAllProject"
        ]),
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
            this.$router.push('/home')
        },
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        changeProject(project) {
            this.set_currentProject(project)
            this.reload()
        },
        add() {
            this.set_addProjectModalVisible(true)
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
    min-width: 400px;

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
  }

  .operation {
    display: flex;
    align-items: center;
  }

  .logout {
    margin-right: 20px;

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