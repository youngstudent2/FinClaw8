<template>
  <a-layout-sider class="sidebar">
    <a-menu
      mode="inline"
      :style="{ height: '100%', borderRight: 0, padding: '20px 0px 0px' }"
      :default-open-keys="['attended','unattended']"
      
    >
      <a-sub-menu key="attended">
        <span slot="title"
          ><a-icon type="appstore" /><span>已参加项目</span></span
        >

        <a-sub-menu v-for="(item,index) in attendedProjects" :key="index">
          <span slot="title">
            <span>{{ item.projectName }}</span>
          </span>
          <a-menu-item v-bind:key="index+'_1'">
            <router-link
              :to="{ name: 'config', params: { projectID: item.projectID } }"
            >
              <a-icon type="database" />配置
            </router-link>
          </a-menu-item>
          <a-menu-item v-bind:key="index+'_2'">
            <router-link
              :to="{ name: 'ready', params: { projectID: item.projectID } }"
            >
              <a-icon type="build" />准备
            </router-link>
          </a-menu-item>
          <a-menu-item v-bind:key="index+'_3'">
            <router-link
              :to="{
                name: 'projectManage',
                params: { projectID: item.projectID },
              }"
            >
              <a-icon type="book" />管理
            </router-link>
          </a-menu-item>
        </a-sub-menu>
      </a-sub-menu>
      <a-sub-menu key="unattended">
        <span slot="title"
          ><a-icon type="appstore" /><span>未参加项目</span></span
        >

        <a-menu-item v-for="(item,index) in unattendedProjects" :key="index">
          <router-link
            :to="{
              name: 'signup',
              params: { projectID: item.projectID },
            }"
          >
            {{ item.projectName }}
          </router-link>
        </a-menu-item>
      </a-sub-menu>
      <!--a-menu-item key="userInfo" @click="jumpToUserInfo">
        <a-icon type="user" />个人信息  
      </a-menu-item-->

    </a-menu>
  </a-layout-sider>
  
</template>


<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {

  data: function () {
    return {};
  },
  computed: {
    ...mapGetters([
      'attendedProjects',
      'unattendedProjects',
      'userInfo'
    ]),
  },
  async mounted(){
    await this.getUserInfo()
    await this.getAllAttendedProjects({cooperationID:this.userInfo.userID})
    await this.getAllUnattendedProjects({cooperationID:this.userInfo.userID})
  },
  methods: {
    ...mapActions([
      'getAllAttendedProjects',
      'getAllUnattendedProjects',
      'getUserInfo'
    ]),
    jumpToUserInfo() {
      
      this.$router.push({
        name: "cooperatorUserInfo",
        params: {
          userId: this.userId,
        },
      });
    },
  },
};
</script>
<style lang="less">
.sidebar {
  width: 200px;
}
</style>