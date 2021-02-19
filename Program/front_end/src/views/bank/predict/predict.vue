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
    import {mapGetters, mapMutations, mapActions} from 'vuex'

    let id = 0;
    export default {
        name: 'predict',
        data() {
            return {
                formItemLayout: {
                    labelCol: {
                        xs: {span: 24},
                        sm: {span: 4},
                    },
                    wrapperCol: {
                        xs: {span: 24},
                        sm: {span: 20},
                    },
                },
                formItemLayoutWithOutLabel: {
                    wrapperCol: {
                        xs: {span: 24, offset: 0},
                        sm: {span: 20, offset: 4},
                    },
                },
            };
        },
        beforeCreate() {
            this.form = this.$form.createForm(this, {name: 'dynamic_form_item'});
            this.form.getFieldDecorator('keys', {initialValue: [], preserve: true});
        },
        components: {
        },
        computed: {
            ...mapGetters([
                'projectInfo',
            ])
        },
        methods: {
            ...mapActions([
                "predict",
            ]),
            remove(k) {
                const {form} = this;
                // can use data-binding to get
                const keys = form.getFieldValue('keys');
                // We need at least one attribute
                if (keys.length === 1) {
                    return;
                }

                // can use data-binding to set
                form.setFieldsValue({
                    keys: keys.filter(key => key !== k),
                });
            },
            add() {
                const {form} = this;
                // can use data-binding to get
                const keys = form.getFieldValue('keys');
                const nextKeys = keys.concat(id++);
                // can use data-binding to set
                // important! notify form to detect changes
                form.setFieldsValue({
                    keys: nextKeys,
                });
            },
            handleSubmit(e) {
                e.preventDefault();
                this.form.validateFields((err, values) => {
                    if (!err) {
                        const {keys, AttributeNames, AttributeValues} = values;
                        console.log('Received values of form: ', values);
                        console.log(
                            'Merged values:',
                            keys.map(key => AttributeNames[key]),
                            keys.map(key => AttributeValues[key]),
                        );
                        this.predict(values)
                    }
                });
            },
        },
    }
</script>

<style>
    .dynamic-delete-button {
        cursor: pointer;
        position: relative;
        top: 4px;
        font-size: 24px;
        color: #999;
        transition: all 0.3s;
    }

    .dynamic-delete-button:hover {
        color: #777;
    }

    .dynamic-delete-button[disabled] {
        cursor: not-allowed;
        opacity: 0.5;
    }
</style>
