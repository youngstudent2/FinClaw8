<template>
  <a-layout-sider class="sidebar">
    <a-menu
      mode="inline"
      :style="{ height: '100%', borderRight: 0, padding: '20px 0px 0px' }"
    >
      <a-menu-item key="1">
        <router-link :to="{ name: 'dataView' }">
          <a-icon type="bank" />数据展示
        </router-link>
      </a-menu-item>
      <a-menu-item key="2">
        <router-link :to="{ name: 'fileManage' }">
          <a-icon type="file" />文件管理
        </router-link>
      </a-menu-item>
      <a-menu-item key="3">
        <router-link :to="{ name: 'monitorInfo' }">
          <a-icon type="switcher" />使用监控
        </router-link>
      </a-menu-item>
      <a-menu-item key="4">
        <router-link :to="{ name: 'predict' }">
          <a-icon type="stock" />信用预测
        </router-link>
      </a-menu-item>
      <a-menu-item key="5">
        <router-link :to="{ name: 'modelView' }">
          <a-icon type="database" />模型管理
        </router-link>
      </a-menu-item>
      <a-menu-item key="manageDataManager">
        <router-link :to="{ name: 'manageDataManager' }">
          <a-icon type="team" />数据操作员管理
        </router-link>
      </a-menu-item>
      <a-menu-item key="7">
        <router-link :to="{ name: 'authorityManage' }">
          <a-icon type="lock" />权限管理
        </router-link>
      </a-menu-item>
      <a-menu-item key="6" @click="jumpToUserInfo">
        <a-icon type="user" />个人信息
      </a-menu-item>
    </a-menu>
  </a-layout-sider>
</template>
<script>
export default {
  methods: {
    jumpToUserInfo() {
      this.$router.push({
        name: "userInfo",
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