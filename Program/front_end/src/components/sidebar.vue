<template>
  <a-layout-sider class="sidebar">
    <a-menu
      mode="inline"
      :style="{ height: '100%', borderRight: 0, padding: '20px 0px 0px' }"
    >
      <a-menu-item v-for="link in this.links" 
                    v-bind:key="link[0]">
        <router-link :to="{ name: link[0] }">
          <a-icon v-bind:type="link[2]" />{{link[1]}}
        </router-link>
      </a-menu-item>

      <!--a-menu-item key="6" @click="jumpToUserInfo">
        <a-icon type="user" />组织信息
      </a-menu-item-->
    </a-menu>
  </a-layout-sider>
</template>
<script>
export default {
  props: ['links'],  // links should be : [[router,text,icon]]
  
  data() {
    return {
      current : [this.links[0][0]]
    }
  },
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
  mounted(){ 
    console.log(this.links)
  }
};
</script>
<style lang="less">
.sidebar {
  width: 200px;
}
</style>