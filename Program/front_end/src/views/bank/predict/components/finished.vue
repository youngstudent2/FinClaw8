<template>
    <div>
        <dv-border-box-11 title="信用预测">
            <el-row type="flex" justify="center" align="middle" style="padding-top: 60px">
                <el-col :span="4">
                    <el-form 
                        label-position="right" 
                        label-width="80px" 
                        :model="predictForm"
                        ref="predictForm">

                        
                        <el-form-item 
                            v-for="(attr, index) in this.predictForm.values"
                            :label="attr.key"
                            :key="attr.key"
                            :prop="'values.' + index + '.value'"
                            :rules="{
                                required: true, trigger: 'blur'
                            }"
                            >
                            <el-input v-model="attr.value"></el-input>
                        </el-form-item>
                        

                        <el-form-item>
                            <el-button type="primary" @click="submitForm('predictForm')">开始预测</el-button>
                            <el-button type="primary" @click="resetForm('predictForm')">重置</el-button>
                        </el-form-item>

                    </el-form>
                </el-col>

                <el-col :span="6" :offset="2">
                    <dv-charts :option="option" style="height: 400px; width: 400px" />
                </el-col>

            </el-row>
        </dv-border-box-11>
    </div>
</template>

<script>
    import {
        mapGetters,
        mapMutations,
        mapActions
    } from 'vuex'
    export default {
        name: "finished",
        data() {
            return {
                option: {
                    title: {
                        text: '预测评分'
                    },
                    series: [{
                        type: 'gauge',
                        data: [{
                            name: 'itemA',
                            value: 100
                        }],
                        axisLabel: {
                            formatter: '{value}'
                        },
                        details: {
                            show: true,
                            offset: [0, 40],
                            formatter: '评分 {value}'
                        },
                        animationCurve: 'easeOutBack',
                    }]
                },
                predictForm: {
                    values: [{
                        value: ''
                    }]
                }
            }
        },
        computed: {
            ...mapGetters([
                'projectData',
                'userId',
                'metadata',
                'predictScore',
            ])
        },
        mounted() {
            console.log(this.projectData)
            this.getMetaInfo()
        },
        methods: {
            ...mapActions([
                'getMetadata',
                'predict'
            ]),
            getMetaInfo() {
                var data = {
                    fileID: this.projectData.fileID,
                    operatorID: Number(this.userId)
                }
                this.getMetadata(data)
                console.log(this.metadata)
                this.predictForm.values = []
                for (var i = 0; i < this.metadata.length; i++) {
                    this.predictForm.values.push({
                        value: '',
                        key: this.metadata[i]
                    })
                }
            },
            submitForm(formName) {
                let featVec = []
                for (var i = 0;i < this.predictForm.values.length; i++) {
                    featVec.push(this.predictForm.values[i].value)
                }
                console.log(featVec)
                let data = {
                    projectID: this.projectData.projectID,
                    featureVector: featVec
                }
                console.log(data)

                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.predict(data).then(() => {
                            alert(this.predictScore)
                        })
                        
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
        }
    }
</script>

<style scoped>

</style>