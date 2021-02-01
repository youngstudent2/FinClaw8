<template>
    <div>
        <el-main>
            <el-row type="flex" justify="center">
                    <dv-decoration-9 style="width:150px;height:150px;">
                        {{ percent }}%
                    </dv-decoration-9>
            </el-row>

            <el-row type="flex" justify="center">
                <dv-decoration-5 style="width:300px;height:40px;" />
            </el-row>

            <el-row type="flex" justify="center" style="margin-top: 10px">
                <el-col style="font-size: 28px;">
                    模型正在训练中
                </el-col>
         </el-row>
        </el-main>
    </div>
</template>

<script>
    import {mapGetters, mapMutations, mapActions} from 'vuex'

    export default {
        name: "training",
        data() {
            return {
               percent: 0,
            }
        },
        computed: {
            ...mapGetters([
                'projectData',
            ]),
        },
        mounted() {
            this.getDate()
            setInterval(this.getDate, 1000)
        },
        methods: {
            getDate(){
                var now = new Date().getTime()
                var endDate = new Date(this.projectData.endTime).getTime()
                this.percent = ((now - endDate) / 86400000 * 100).toFixed(2)
            }
        }
    }
</script>

<style scoped>

</style>