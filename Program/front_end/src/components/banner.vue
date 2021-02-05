<template>
  <el-carousel id="banner" :interval="3000" height="400px">
    <el-carousel-item
      v-for="index in 6"
      :key="index"
    >
      <img :src="require('@/assets/bannerImages/banner-img'+(index-1)+'.png')" alt="banner" style="height: 100%; weight: 100%" />
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  
};
</script>

<style>


#banner .el-carousel__item {
  /*background: transparent no-repeat 50%;*/
  background-color: white;
  margin: 0 auto;
  /*background-size: cover;*/
  text-align: center;
  
}



</style>