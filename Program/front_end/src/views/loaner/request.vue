<template>
    <div>
        <h2>贷款申请</h2>
        <div class="center">
            <a-form-model :model="form" :label-col="labelCol" :wrapper-col="wrapperCol" style="border: 1px solid">
                <a-form-model-item label="申请人">
                    <a-input v-model="form.name" />
                </a-form-model-item>
                <a-form-model-item label="联系方式">
                    <a-input v-model="form.phoneNumber" />
                </a-form-model-item>
                <a-form-model-item label="申请金额">
                    <a-input v-model="form.amount" />
                </a-form-model-item>
                <a-form-model-item label="企业名称">
                    <a-input v-model="form.companyName" />
                </a-form-model-item>
                <a-form-model-item label="社会统一认证代码">
                    <a-input v-model="form.certificationCode" />
                </a-form-model-item>
                <a-form-model-item label="注册号">
                    <a-input v-model="form.registrationCode" />
                </a-form-model-item>
                
                <a-form-model-item :wrapper-col="{ span: 14, offset: 4 }">
                    <a-button type="primary" @click="onSubmit">
                        提交
                    </a-button>
                    <a-button style="margin-left: 10px;">
                        取消
                    </a-button>
                </a-form-model-item>
            </a-form-model>
        </div>
    </div>
</template>

<script>
    import {
        mapGetters,
        mapMutations,
        mapActions
    } from 'vuex'
import registerVue from '../register.vue';
    export default {
        data() {
            return {
                labelCol: {
                    span: 8
                },
                wrapperCol: {
                    span: 10
                },
                form: {
                    name: '',
                    phoneNumber: '',
                    amount: '',
                    certificationCode: '',
                    registrationCode: '',
                    companyName: '',
                },
            };
        },
        components: {

        },
        computed: {
            ...mapGetters([
                'userId'
            ])
        },
        methods: {
            ...mapActions([
                'addLoanApplication'
            ]),

            onSubmit() {
                console.log('submit!', this.form);
                var data = {
                    userID: 7,
                    amount: this.form.amount,
                    phoneNumber: this.form.phoneNumber,
                    certificationCode: this.form.certificationCode,
                    registrationCode: this.form.registrationCode,
                    companyName: this.form.companyName
                }
                console.log(data)
                this.addLoanApplication(data)
                this.form.resetFields()
            },
        },
    };
</script>

<style>
    .center {
        width: 70%;
        margin: auto auto;
    }
</style>