<template>
    <div>
       <!-- <a-form :form="form" @submit="handleSubmit">
            <a-form-item
                    v-for="(k, index) in form.getFieldValue('keys')"
                    :key="k"
                    v-bind="index === 0 ? formItemLayout : formItemLayoutWithOutLabel"
                    :label="index === 0 ? 'Attribute' : ''"
                    :required="false"
            >
                <a-input
                        v-decorator="[`AttributeNames[${k}]`,{
                        validateTrigger: ['change', 'blur'],
                        rules: [{required: true,
                                 whitespace: true,
                                 message: 'Please input attribute name or delete this field.',
                                },],
                               },]"
                        placeholder="attribute name"
                        style="width: 30%; margin-right: 14px"/>
                <a-input
                        v-decorator="[`AttributeValues[${k}]`,{
                        validateTrigger: ['change', 'blur'],
                        rules: [{required: true,
                                 whitespace: true,
                                 message: 'Please input attribute value or delete this field.',
                                },],
                               },]"
                        placeholder="attribute value"
                        style="width: 30%; margin-right: 8px"/>
                <a-icon
                        v-if="form.getFieldValue('keys').length > 1"
                        class="dynamic-delete-button"
                        type="minus-circle-o"
                        :disabled="form.getFieldValue('keys').length === 1"
                        @click="() => remove(k)"/>
            </a-form-item>
            <a-form-item v-bind="formItemLayoutWithOutLabel">
                <a-button type="dashed" style="width: 60%; margin-right: 14px" @click="add">
                    <a-icon type="plus"/>
                    Add Attribute
                </a-button>
            </a-form-item>
            <a-form-item v-bind="formItemLayoutWithOutLabel">
                <a-button type="primary" html-type="submit">
                    Submit
                </a-button>
            </a-form-item>
        </a-form>-->
        <Running v-if="projectData.status==='1'"></Running>
        <Stop v-else-if="projectData.status==='2'"></Stop>
        <Training v-else-if="projectData.status==='3'"></Training>
        <Finished v-else></Finished>
    </div>
</template>

<script>
    import {mapGetters, mapMutations, mapActions} from 'vuex'
    import Running from "./components/running";
    import Stop from "./components/stop";
    import Training from "./components/training";
    import Finished from "./components/finished";

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
            Running,
            Stop,
            Training,
            Finished,
        },
        computed: {
            ...mapGetters([
                'projectData',

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
