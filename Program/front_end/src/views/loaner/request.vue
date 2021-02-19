<template>
    <div>
        <h2>贷款申请</h2>
        <div v-if="!this.hasNotDealt">
            <div class="center">
            <a-form-model 
              ref="ruleForm" 
              :model="form" 
              :rules="rules"
              :label-col="labelCol" 
              :wrapper-col="wrapperCol"
              style="border: 5px solid grey; padding-top: 20px"
            >
                <a-form-model-item label="申请人" prop="name">
                    <a-input v-model="form.name" />
                </a-form-model-item>
                <a-form-model-item label="联系方式" prop="phoneNumber">
                    <a-input v-model="form.phoneNumber" />
                </a-form-model-item>
                <a-form-model-item label="申请金额" prop="amount">
                    <a-input v-model="form.amount" />
                </a-form-model-item>
                <a-form-model-item label="企业名称" prop="companyName">
                    <a-input v-model="form.companyName" />
                </a-form-model-item>
                <a-form-model-item label="社会统一认证代码" prop="certificationCode">
                    <a-input v-model="form.certificationCode" />
                </a-form-model-item>
                <a-form-model-item label="注册号" prop="registrationCode">
                    <a-input v-model="form.registrationCode" />
                </a-form-model-item>
                
                <a-form-model-item :wrapper-col="{ span: 14, offset: 5 }">
                    <a-space>
                        <a-button type="primary" @click="onSubmit">
                            提交
                        </a-button>
                        <a-button>
                            取消
                        </a-button>
                    </a-space>
                </a-form-model-item>
            </a-form-model>
            </div>
        </div>
        <div v-else>
            <h3>您有借款申请尚未处理完成，请至<a @click="gotoManage">申请管理</a>处查看</h3>
        </div>
    </div>
</template>

<script>
import {
    mapGetters,
    mapMutations,
    mapActions
} from 'vuex'

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
            rules: {
                name:        [{required: true, message: '请输入申请人姓名',     trigger: 'blur'}],
                phoneNumber: [{required: true, message: '请输入申请人手机号码', trigger: 'blur'}],
                amount:      [{required: true, message: '请输入申请借款金额',   trigger: 'blur'}],
                certificationCode: [{required: true, message: '请输入统一社会信用代码',   trigger: 'blur'}],
                registrationCode:  [{required: true, message: '请输入企业注册号',         trigger: 'blur'}],
                companyName: [{required: true, message: '请输入企业名称',      trigger: 'blur'}],    
            },
            hasNotDealt: false,
        };
    },
    async mounted() {
        await this.getUserLoanApplication(this.userId);
        for (let loan of this.userLoanApplication) {
            if (!loan.hasDealt) {
                this.hasNotDealt = true;
                break;
            }
        }
    },
    computed: {
        ...mapGetters([
            'userId',
            'userLoanHistory',
            'userLoanApplication'
        ])
    },
    methods: {
        ...mapActions([
            'addLoanApplication',
            'getUserLoanApplication',
        ]),

        onSubmit() {
            this.$refs.ruleForm.validate(valid => {
                if (valid) {
                    var data = {
                        userID: this.userId,
                        userName: this.form.name,
                        amount: this.form.amount,
                        phoneNumber: this.form.phoneNumber,
                        certificationCode: this.form.certificationCode,
                        registrationCode: this.form.registrationCode,
                        companyName: this.form.companyName
                    }
                    this.addLoanApplication(data);
                    this.resetForm();
                    this.hasNotDealt = true;
                    this.$router.push('/loaner/requestManage');
                } else {
                    return false;
                }
            })

        },

        resetForm() {
            this.$refs.ruleForm.resetFields();
        },

        gotoManage() {
            this.$router.push('/loaner/requestManage');
        }
    },
};
</script>

<style>
    .center {
        width: 70%;
        margin: auto auto;
        text-align: center;
    }
</style>