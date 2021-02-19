<template>
    <div>
        <dv-border-box13 style="height: 500px">
            <a-row :gutter="10">
                <a-col :span="12"
                       style="height: 500px; display: flex; flex-direction: column; justify-content: center; align-items: center">
                    <a-button type="primary" size="large" @click="startPredict" style="width: 100px; margin-bottom: 50px">
                        预测
                    </a-button>
                    <a-button type="primary" size="large" ghost @click="reset" style="width: 100px">
                        重置
                    </a-button>
                </a-col>
                <a-col :span="12" style="height: 500px; padding-top: 50px">
                    <dv-charts :option="option" style="height: 450px"></dv-charts>
                </a-col>
            </a-row>

        </dv-border-box13>
    </div>
</template>

<script>
    import {mapGetters, mapMutations, mapActions} from 'vuex'

    export default {
        name: 'predict',
        data() {
            return {
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
                'projectInfo',
                'predictPoint'
            ])
        },
        async mounted() {
            await this.setPoint()
        },
        methods: {
            ...mapActions([
                "predict",
            ]),
            setPoint() {
                this.option.series[0].data[0].value = this.predictPoint
            },
            startPredict() {
                this.predict()
                this.setPoint()
                this.option = { ...this.option }
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
