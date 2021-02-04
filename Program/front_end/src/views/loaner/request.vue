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
export default {
  data() {
    return {
      labelCol: { span: 8 },
      wrapperCol: { span: 10 },
      form: {
        name: '',
        phoneNumber: '',
        amount: '',
      },
    };
  },
  methods: {
    onSubmit() {
      console.log('submit!', this.form);
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