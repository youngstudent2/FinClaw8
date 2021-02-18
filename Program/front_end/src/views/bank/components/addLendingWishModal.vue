<template>
    <div>
        <a-modal
            :visible="addLendingWishModalVisible"
            title="添加放贷意愿"
            cancelText="取消"
            okText="添加"
            @cancel="cancelSubmit"
            @ok="handleSubmit"
        >
            <a-form :form="form" style="margin-top: 30px" v-bind="formItemLayout">
                <a-form-item label="利率" v-bind="formItemLayout">
                    <a-input v-decorator="['interestRate', { rules: [{ required: true, message: '请填写放贷利率' }]}]"
                             placeholder="请填写放贷利率"></a-input>
                </a-form-item>
                <a-form-item v-bind="formItemLayout" label="说明">
                    <a-input v-decorator="['description']"
                             placeholder="可填写说明"></a-input>
                </a-form-item>
            </a-form>
        </a-modal>
    </div>
</template>

<script>
import {mapActions, mapGetters, mapMutations} from "vuex";
export default {
    name: "addLendingWishModal",
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
            'addLendingWishModalVisible',
            'userId',
            'userInfo',
            'currentLoanerInfo'
        ]),
    },
    methods: {
        ...mapMutations([
            'set_addLendingWishModalVisible',
        ]),
        ...mapActions([
            'addLendingWish',
        ]),
        cancelSubmit(){
            this.set_addLendingWishModalVisible(false)
        },
        handleSubmit(e) {
            e.preventDefault();
            this.form.validateFieldsAndScroll((err, values) => {
                if (!err) {
                    const data = {
                        bankID: Number(this.userId),
                        bankName: this.userInfo.username,
                        lenderID: this.currentLoanerInfo.userID,
                        lenderName: this.currentLoanerInfo.companyName,
                        amount: this.currentLoanerInfo.amount,
                        interestRate: this.form.getFieldValue('interestRate'),
                        phoneNumber: this.currentLoanerInfo.phoneNumber,
                        description: this.form.getFieldValue('description'),
                    }
                    console.log(data)
                    this.addLendingWish(data)
                    this.set_addLendingWishModalVisible(false)
                }
            });
        },
    },
}
</script>

<style scoped>

</style>