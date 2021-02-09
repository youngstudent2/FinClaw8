<template>
  <div id="layout">
    <a-layout>
      <Header></Header>
      <a-layout style="height: 100%">
        <Sidebar v-bind:links="links"></Sidebar>
        <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>项目</a-breadcrumb-item>
          <a-breadcrumb-item>管理</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '1000px' }"
        >
          <transition name="fade-transform" mode="out-in">
                <router-view/>
            </transition>
        </a-layout-content>
        </a-layout>


      <Footer></Footer>
    </a-layout>

    </a-layout>
  </div>
</template>
<script>
import Header from "@/components/header";
import Sidebar from "@/components/sidebar";
import Footer from "@/components/footer";
export default {
  name: "layout",
  components: {
    Header,Sidebar,Footer,
  },
  data() {
    return {
      links : [
        ['dataView','数据展示','bank'],
        ['authorityManage','权限管理','lock'],
        ['predict','信用预测','stock'],
        ['projectConfig','项目配置','setting']
      ]
    }
  }
};
</script>
<style>
#layout {
  text-align: center;
}


</style>