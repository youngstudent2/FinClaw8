<template>
    <div >
        <dv-border-box13 style="height: 500px">
            <h2 style="padding-top: 30px">利率池分配推荐</h2>
            <div :style="backgroundStyle">
                <p style="width: 50px; padding-top: 225px; padding-left: 220px; position: absolute;
                          font-family: 'Verdana'; font-size: 20px; font-weight: bold; color: #dddddd">33%</p>
                <p style="width: 50px; padding-top: 175px; padding-left: 440px; position: absolute;
                          font-family: 'Verdana'; font-size: 20px; font-weight: bold; color: #ffffff">33%</p>
                <p style="width: 50px; padding-top: 255px; padding-left: 690px; position: absolute;
                          font-family: 'Verdana'; font-size: 20px; font-weight: bold; color: #888888">33%</p>
            </div>
        </dv-border-box13>
    </div>
</template>

<script>
export default {
    name: "recommend",
    data(){
        return {
            backgroundStyle: {
                width: '800px',
                height: '400px',
                backgroundImage: "url(" + require("../../../assets/strategy.jpg") + ")",
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'top',
                backgroundSize: '800px, 400px',
                marginLeft: '150px',
            },
        }
    },
}
</script>

<style scoped>

</style>