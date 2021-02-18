<template>
  <div id="home">
    <a-layout>
      <Header></Header>
      <a-layout style="height: 100%">
          <!--顶部菜单栏-->
          <div>
            <a-menu v-model="current" mode="horizontal" style="padding-left: 60px">
              <a-menu-item key="review">
                <router-link :to="{ name: 'projectReview' }">
                  <a-icon type="project" />项目浏览
                </router-link>
              </a-menu-item>
              <a-menu-item key="lending">
                <router-link :to="{ name: 'lendingHandle' }">
                  <a-icon type="money-collect" />贷款申请
                </router-link>
              </a-menu-item>
              <a-menu-item key="history">
                <router-link :to="{ name: 'lendingHistory' }">
                  <a-icon type="history" />意愿记录
                </router-link>
              </a-menu-item>
              
            </a-menu>
          </div>
        
        <!--内容页-->
        <a-lauout-content style="padding: 20px 40px">
          <div :style="{ background: '#fff', padding: '24px', minHeight: '600px' }">
              <transition name="fade-transform" mode="out-in">
                  <router-view/>
              </transition>
          </div>
        </a-lauout-content>
      </a-layout>
    </a-layout>
  </div>
</template>

<script>
import Header from "@/components/header";
export default {
  components: {
    Header
  },
  data() {
    return {
      current: ["review"],
    };
  },
};
</script>


<style>
</style>