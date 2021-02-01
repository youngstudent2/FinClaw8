<template>
  <div id="layout">
    <a-layout>
      <Header></Header>
      <a-layout style="height: 100%">
        <Sidebar></Sidebar>
        <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>主页</a-breadcrumb-item>
          <a-breadcrumb-item>监管</a-breadcrumb-item>
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
};
</script>
<style>
#layout {
  text-align: center;
}


</style>