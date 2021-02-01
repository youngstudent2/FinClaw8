<template>
  <a-layout>
    <Header></Header>
    <Banner></Banner>
    <div id="components-grid-demo-playground">
      <a-row>
        <a-col :span="24" >
          <div class="banner">
            
            <h1>FinClaw花旗杯项目</h1>

          </div>
          
        </a-col>
      </a-row>
      <div class="projects">
      <a-row :gutter="[6, 2]" style="width:100%">
        <a-col v-for="item in 12" :key="item.toString()" :span="24 / colCount">
          <div>
            <a-card hoverable style="width: 300px">
              <img
                slot="cover"
                alt="example"
                src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
              />
              <a-card-meta title="Europe Street beat">
                <template slot="description"> www.instagram.com </template>
              </a-card-meta>
            </a-card>
          </div>
        </a-col>
      </a-row>
      </div>
    </div>
  </a-layout>
</template>
<script>
import Header from "@/components/header";
import Banner from "@/components/banner";
export default {
  components: {
    Header,
    Banner,
  },
  data() {
    return {
      colCount: 4,
    };
  },
  computed: {},
};
</script>
<style scoped>
#components-grid-demo-playground .projects{
  display: flex;
  align-content: center;
}
#components-grid-demo-playground [class~="ant-col"] {
  background: transparent;
  border: 0;
  
}
#components-grid-demo-playground [class~="ant-col"] > div {
  /*background: #00a0e9;*/
  height: 300px;
  line-height: 300px;
  font-size: 13px;
}
#components-grid-demo-playground [class~="ant-col"] > .banner {
  background: transparent no-repeat 50%;
  background-image: url('https://demo.doublechaintech.com/demodata/imageManager/loadImage/doublechainhome0000/400/300/red/');
  
  margin: 0 auto;
  background-size: cover;
  text-align: center;
  min-height:420px;
  
}
h1{
    font-size: 52px;
    color:rgba(255, 255, 255, 0.9);
    letter-spacing: 8px;
}
#components-grid-demo-playground pre {
  background: #f9f9f9;
  border-radius: 6px;
  font-size: 13px;
  padding: 8px 16px;
}


</style>
