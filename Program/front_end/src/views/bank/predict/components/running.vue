<template>
    <div>
        <a-row :gutter="16">
            <a-col :span="8">
                <a-statistic title="项目名称" :value="projectData.name"/>
            </a-col>
            <a-col :span="8">
                <a-statistic title="项目简介" :value="projectData.description"/>
            </a-col>
            <a-col :span="8">
                <a-statistic title="项目状态" :value="projectStatus[projectData.status]"
                             :value-style="{ color: colorList[projectData.status] }"/>
            </a-col>
        </a-row>
        <a-row :gutter="16" style="margin-top: 32px">
            <a-col :span="12">
                <a-statistic title="开始时间" :value="projectData.startTime.replace('T',' ').substring(0,19)" format="D 天"/>
            </a-col>
            <a-col :span="12">
                <a-statistic-countdown title="剩余时间" :value="projectData.endTime"/>
            </a-col>
        </a-row>
        <a-row :gutter="16" style="margin-top: 32px">
            <a-col :span="24">
                <a-statistic title="合作总数" :value="projectData.cooperationNumber" :value-style="{ color: 'red' }"/>
            </a-col>
        </a-row>
    </div>
</template>
<script>
    import { mapGetters, mapMutations, mapActions } from 'vuex'

    export default {
        name: 'running',
        data(){
            return {
                projectStatus: {
                    "1": "招募合作中",
                    "2": "已结束",
                    "3": "训练中",
                    "4": "已完成"
                },
                colorList: {
                    "1": "green",
                    "2": "black",
                    "3": "orange",
                    "4": "blue"
                }
            }
        },
        components: {
        },
        computed: {
            ...mapGetters([
                'userId',
                'projectID',
                'projectData'
            ])
        },
        async mounted() {
            await this.getProjectData({
                operatorID: Number(this.userId),
                projectID: Number(this.projectID)
            })
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