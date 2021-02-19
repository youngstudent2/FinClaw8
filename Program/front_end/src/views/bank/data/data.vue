<template>
    <div :style="backgroundStyle">
        <div style="width: 100%; padding-left: 930px; padding-top: 215px; text-align: left; font-size: 9px">
            <p>{{projectInfo.projectName}}</p>
            <p>{{projectInfo.description}}</p>
            <p>{{status}}</p>
            <p>{{restDays}}</p>
        </div>
    </div>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
    name: 'data',

    data(){
        return {
            backgroundStyle: {
                height: '1200px',
                backgroundImage: "url(" + require("../../../assets/test.png") + ")",
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'top',
                backgroundSize: '1200px, 1000px'
            },
            restDays: 0,
            status: ""
        }
    },
    async mounted() {
        await this.calculate()
    },
    computed: {
        ...mapGetters([
            'projectInfo',
        ])
    },
    methods: {
        ...mapActions([

        ]),
        calculate() {
            if (this.projectInfo.status === "Running") { this.status = "未截止" }
            else if (this.projectInfo.status === "Stop") { this.status = "已结束" }
            else if (this.projectInfo.status === "Training") { this.status = "训练中" }
            else if (this.projectInfo.status === "Finished") { this.status = "已完成" }
            else if (this.projectInfo.status === "Failed") { this.status = "已失败" }

            let d1 = Date.parse(new Date())
            let d2 = Date.parse(this.projectInfo.endTime)
            if (d2 > d1) {
                this.restDays = parseInt((d2 - d1) / (1000 * 60 * 60 * 24))
            }
        }
    }
}

</script>

<style scoped lang="less">

</style>