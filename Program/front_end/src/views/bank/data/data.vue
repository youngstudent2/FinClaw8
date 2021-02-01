<template>
    <div :style="backgroundStyle">
<!--        <a-row style="height: 100px">-->
<!--            <a-col :span="8">-->
<!--                <a-statistic title="项目名称" :value="projectData.name"/>-->
<!--            </a-col>-->
<!--            <a-col :span="8">-->
<!--                <a-statistic title="项目简介" :value="projectData.description"/>-->
<!--            </a-col>-->
<!--            <a-col :span="8">-->
<!--                <a-statistic title="项目状态" :value="projectStatus[projectData.status]"-->
<!--                                            :value-style="{ color: colorList[projectData.status] }"/>-->
<!--            </a-col>-->
<!--        </a-row>-->
<!--        <a-row style="height: 100px">-->
<!--            <a-col :span="12">-->
<!--                <a-statistic title="项目进度" :value="projectData.progressRate / 100"/>-->
<!--            </a-col>-->
<!--            <a-col :span="12">-->
<!--                <a-statistic-countdown title="剩余天数" :value="projectData.endTime" format="D 天 H 小时"/>-->
<!--            </a-col>-->
<!--        </a-row>-->
<!--        <a-row type="flex" align="middle">-->
<!--            <a-col :span="12" align="middle">-->
<!--            </a-col>-->
<!--            <a-col :span="12">-->
<!--                <a-statistic title="合作总数" :value="projectData.cooperationNumber" :value-style="{ color: 'red' }"/>-->
<!--            </a-col>-->
<!--        </a-row>-->

    </div>

</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
    name: 'data',

    data(){
        return {
            projectStatus: {
                "1": "进行中",
                "2": "已结束",
                "3": "训练中",
                "4": "已完成"
            },
            colorList: {
                "1": "green",
                "2": "black",
                "3": "orange",
                "4": "blue"
            },
            backgroundStyle: {
                height: '1200px',
                backgroundImage: "url(" + require("../../../assets/test.png") + ")",
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'top',
                backgroundSize: '1200px, 1000px'
            }
        }
    },
    components: {
    },
    computed: {
        ...mapGetters([
            'userId',
            'projectID',
            'projectData',
            'chartConfig'
        ])
    },
    async mounted() {
        if (this.projectID !== null) {
            await this.getProjectData({
                operatorID: Number(this.userId),
                projectID: Number(this.projectID)
            })
        }
    },
    methods: {
        ...mapActions([
            'getProjectData'
        ]),
    }
}

</script>

<style scoped lang="less">

</style>