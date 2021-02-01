<template>
  <a-form
    :form="form"
    :label-col="{ span: 5 }"
    :wrapper-col="{ span: 12 }"
    @submit="handleSubmit"
  >
    <a-form-item label="server IP">
      <a-input
        v-decorator="[
          'ipAddress',
          { rules: [{ required: true, message: 'Please input your server ip' }] },
        ]"
      />
    </a-form-item>
    <a-form-item label="root账户名">
      <a-input
        v-decorator="[
          'serviceName',
          { rules: [{ required: true, message: 'Please input your root account' }] },
        ]"
      />
    </a-form-item>
    <a-form-item label="密码">
      <a-input
        type="password"
        v-decorator="[
          'servicePassword',
          { rules: [{ required: true, message: 'Please input your password' }] },
        ]"
      />
    </a-form-item>
    <a-form-item label="文件路径">
      <a-input
        v-decorator="[
          'filepath',
          { rules: [{ required: true, message: 'Please input your file path' }] },
        ]"
      />
    </a-form-item>
    <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
      <a-button type="primary" html-type="submit"> 修改 </a-button>
    </a-form-item>
  </a-form>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
  data() {
    return {
      formLayout: "horizontal",
      form: this.$form.createForm(this, { name: "cooperationForm" }),
    };
  },
  computed:{
    ...mapGetters([
      "userInfo"
    ])
  },
  methods: {
    ...mapActions([
      "uploadServiceInfo"
    ]),
    
    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log("Received values of form: ", values);
          values.cooperationID = this.userInfo.cooperationID
          values.projectID = this.$route.params.projectID
          this.uploadServiceInfo(values)
        }
      });
    },
    
  },
};
</script>

<style>
</style>