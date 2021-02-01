<template>
    <div>
        <a-modal
                :visible="addProjectModalVisible"
                title="添加项目"
                cancelText="取消"
                okText="添加"
                @cancel="cancelSubmit"
                @ok="handleSubmit"
        >
            <a-form :form="form" style="margin-top: 30px" v-bind="formItemLayout">
                <a-form-item label="项目名称" v-bind="formItemLayout">
                    <a-input v-decorator="['projectName', { rules: [{ required: true, message: '请填写项目名称' }]}]"
                             placeholder="请填写项目名称"></a-input>
                </a-form-item>
                <a-form-item v-bind="formItemLayout" label="活动时间">
                    <a-range-picker
                            format="YYYY-MM-DD"
                            v-decorator="['date',{ rules: [{ required: true, message: '请选择项目时间' }]}]"
                            :placeholder="['开始日期','结束日期']"
                    />
                </a-form-item>
                <a-form-item v-bind="formItemLayout" label="项目描述">
                    <a-input v-decorator="['description']"
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
        name: "addProjectModal",
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
        computed: {
            ...mapGetters([
                'addProjectModalVisible',
            ]),
        },
        methods: {
            ...mapMutations([
                'set_addProjectModalVisible',
            ]),
            ...mapActions([
                'addProject',
            ]),
            cancelSubmit(){
                this.set_addProjectModalVisible(false)
            },
            handleSubmit(e) {
                e.preventDefault();
                this.form.validateFieldsAndScroll((err, values) => {
                    if (!err) {
                        const data = {
                            projectName: this.form.getFieldValue('projectName'),
                            startTime: moment(this.form.getFieldValue('date')[0]).format('YYYY-MM-DD'),
                            endTime: moment(this.form.getFieldValue('date')[1]).format('YYYY-MM-DD'),
                            description: this.form.getFieldValue('description'),
                        }
                        console.log(data)
                        this.addProject(data)
                        this.set_addProjectModalVisible(false)
                    }
                });
            },
        },
    }
</script>

<style scoped>

</style>