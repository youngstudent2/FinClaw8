<template>
    <div>
        <a-modal
            :visible="modifyProjectModalVisible"
            title="修改项目"
            cancelText="取消"
            okText="确认"
            @cancel="cancelSubmit"
            @ok="handleSubmit"
        >
            <a-form :form="form" style="margin-top: 30px" v-bind="formItemLayout">
                <a-form-item label="项目名称" v-bind="formItemLayout">
                    <a-input v-decorator="['projectName', { rules: [{ required: true, message: '请填写项目名称' }],
                                                            initialValue: modifyData.projectName }]"
                             placeholder="请填写项目名称"></a-input>
                </a-form-item>
                <a-form-item v-bind="formItemLayout" label="活动时间">
                    <a-range-picker
                        format="YYYY-MM-DD"
                        v-decorator="['date', { rules: [{ required: true, message: '请选择项目时间' }],
                                                initialValue: [modifyData.startTime, modifyData.endTime] }]"
                        :placeholder="['开始日期', '结束日期']"
                    />
                </a-form-item>
                <a-form-item v-bind="formItemLayout" label="项目描述">
                    <a-input v-decorator="['description', { initialValue: modifyData.description }]"
                             placeholder="请填写项目描述"></a-input>
                </a-form-item>
            </a-form>
        </a-modal>
    </div>
</template>

<script>
import {mapActions, mapGetters, mapMutations} from "vuex";
const moment = require('moment');
export default {
    name: "modifyProjectModal",
    data(){
        return{
            formItemLayout: {
                labelCol: {
                    xs: {span: 12},
                    sm: {span: 6},
                },
                wrapperCol: {
                    xs: {span: 24},
                    sm: {span: 16},
                },
            },
            form: this.$form.createForm(this, { name: 'addProjectModal'})
        }
    },
    props: ['modifyData'],
    computed: {
        ...mapGetters([
            'modifyProjectModalVisible',
            'userId'
        ]),
    },
    methods: {
        ...mapMutations([
            'set_modifyProjectModalVisible',
        ]),
        ...mapActions([
            'modifyProject',
        ]),
        cancelSubmit(){
            this.set_modifyProjectModalVisible(false)
        },
        handleSubmit(e) {
            e.preventDefault();
            this.form.validateFieldsAndScroll((err, values) => {
                if (!err) {
                    const data = {
                        projectData: {
                            userID: this.userId,
                            projectName: this.form.getFieldValue('projectName'),
                            startTime: moment(this.form.getFieldValue('date')[0]).format('YYYY-MM-DD'),
                            endTime: moment(this.form.getFieldValue('date')[1]).format('YYYY-MM-DD'),
                            description: this.form.getFieldValue('description'),
                        },
                        projectID: this.modifyData.projectID
                    }
                    //console.log(data)
                    this.modifyProject(data)
                    this.set_modifyProjectModalVisible(false)
                }
            });
        },
    },
}
</script>

<style scoped>

</style>