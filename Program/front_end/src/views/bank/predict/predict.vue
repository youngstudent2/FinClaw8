<template>
    <div>
        <dv-border-box13 style="height: 500px">
            <a-row :gutter="10">
                <a-col :span="8"
                       style="height: 500px; display: flex; flex-direction: column; justify-content: center; align-items: center">
                    <div style="display: flex; flex-direction: row">
                        <h4 style="padding-top: 5px">预测对象：</h4>
                        <a-input v-model="predictName" placeholder="请输入需要预测的企业名" style="width: 200px; margin-bottom: 40px"></a-input>
                    </div>
                    <div style="display: flex; flex-direction: row">
                        <h4 style="padding-top: 5px">绑定模型：</h4>
                        <a-button @click="doBind" style="width: 100px; margin-bottom: 50px">
                            绑定模型
                        </a-button>
                    </div>
                    <a-button type="primary" size="large" @click="startPredict" style="width: 100px; margin-bottom: 40px">
                        预测
                    </a-button>
                    <a-button type="primary" size="large" ghost @click="reset" style="width: 100px">
                        重置
                    </a-button>
                </a-col>
                <a-col :span="8" style="height: 500px; padding-top: 90px">
                    <dv-charts :option="option" style="height: 410px"></dv-charts>
                </a-col>
                <a-col :span="8" style="height: 500px; padding-top: 120px">
                    <h2><b>放贷方案推荐</b></h2>
                    <h3 style="padding-top: 10px">信用评级：优</h3>
                    <h3>贷款年利率：3.85%</h3>
                    <h3>贷款比例：1</h3>
                </a-col>
            </a-row>
        </dv-border-box13>
    </div>
</template>

<script>
    import {mapGetters, mapMutations, mapActions} from 'vuex'
    import {message} from "ant-design-vue";

    export default {
        name: 'predict',
        data() {
            return {
                predictName: '',
                option: {
                    title: {
                        text: '预测信用值'
                    },
                    series: [
                        {
                            type: 'gauge',
                            data: [
                                { name: 'itemA', value: 0, gradient: ['#2fded6', '#1ed3e5', '#03c2fd'], localGradient: true }
                            ],
                            axisLabel: {
                                formatter: '{value}'
                            },
                            details: {
                                show: true,
                                offset: [5, 40],
                                formatter: '{value}分'
                            },
                        }
                    ]
                }
            };
        },
        computed: {
            ...mapGetters([
                'projectID',
                'projectInfo',
                'bindStatus',
                'predictPoint'
            ])
        },
        async mounted() {
            await this.setPoint()
        },
        methods: {
            ...mapMutations([
                'set_bindStatus'
            ]),
            ...mapActions([
                "predict",
                'loadBind',
            ]),
            doBind() {
                this.loadBind(this.projectID)
                this.set_bindStatus(true)
            },
            setPoint() {
                this.option.series[0].data[0].value = this.predictPoint
            },
            startPredict() {
                if (!this.bindStatus) {
                    message.info("尚未绑定模型")
                }
                else if (this.predictName === '') {
                    message.error("尚未填写信息")
                }
                else {
                    this.predict()
                    this.setPoint()
                    this.option = { ...this.option }
                }
            },
            reset() {
                this.option.series[0].data[0].value = 0
                this.option = { ...this.option }
            }
        },
    }
</script>

<style>

</style>
