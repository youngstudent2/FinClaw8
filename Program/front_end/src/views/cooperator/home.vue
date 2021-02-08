<template>
 <div :style="backgroundStyle">
   </div>
</template>


<script>

export default {
  data() {
    return {
      backgroundStyle: {
                height: '1200px',
                backgroundImage: "url(" + require("@/assets/test.png") + ")",
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'top',
                backgroundSize: '1200px, 1000px'
            },
    }
  }
}
</script>

<style>

</style>