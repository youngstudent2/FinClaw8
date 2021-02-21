<template>
  <div class="register">
    <div
      class="background"
      style="position: absolute; z-index: -1; width: 100%; top: 0px; left: 0px"
    >
      <img
        src="https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/注册.png"
        width="100%"
        height="100%"
      />
    </div>
    <a-form
      id="formRegister"
      class="user-register"
      ref="formRegister"
      :form="form"
    >
      <a-tabs :tabBarStyle="{ textAlign: 'center', borderBottom: 'unset' }">
        <a-tab-pane key="tab1" tab="注册账号">
          <a-form-item>
            <a-select
              v-decorator="[
                'registerUserRole',
                {
                  initialValue: 'Bank',
                  rules: [{ required: true, message: '请选择用户类型' }],
                  validateTrigger: 'blur',
                },
              ]"
            >
              <a-select-option value="Bank">银行</a-select-option>
              <a-select-option value="DataProvider">数据提供方</a-select-option>
              <a-select-option value="Company">企业</a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item>
            <a-input
              size="large"
              type="email"
              placeholder="邮箱"
              v-decorator="[
                'registerUserMail',
                {
                  rules: [
                    { required: true, type: 'email', message: '请输入邮箱' },
                  ],
                  validateTrigger: 'blur',
                },
              ]"
            >
              <a-icon
                slot="prefix"
                type="mail"
                :style="{ color: 'rgba(0,0,0,.25)' }"
              />
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-input
              size="large"
              placeholder="企业名称"
              v-decorator="[
                'registerUserName',
                {
                  rules: [{ required: true, message: '请输入企业名称' }],
                  validateTrigger: 'blur',
                },
              ]"
            >
              <a-icon
                slot="prefix"
                type="safety"
                :style="{ color: 'rgba(0,0,0,.25)' }"
              />
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-input
              size="large"
              placeholder="手机号"
              v-decorator="[
                'registerPhoneNumber',
                {
                  rules: [{ required: true, message: '请输入手机号' }],
                  validateTrigger: 'blur',
                },
              ]"
            >
              <a-icon
                slot="prefix"
                type="phone"
                :style="{ color: 'rgba(0,0,0,.25)' }"
              />
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-input
              size="large"
              type="password"
              autocomplete="false"
              placeholder="密码"
              v-decorator="[
                'registerPassword',
                {
                  rules: [
                    { required: true, message: '请输入密码' },
                    { validator: this.handlePassword },
                  ],
                  validateTrigger: 'blur',
                },
              ]"
            >
              <a-icon
                slot="prefix"
                type="lock"
                :style="{ color: 'rgba(0,0,0,.25)' }"
              />
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-input
              size="large"
              type="password"
              placeholder="确认密码"
              v-decorator="[
                'registerPasswordconfirm',
                {
                  rules: [
                    { required: true, message: '请输入密码' },
                    { validator: this.handlePasswordCheck },
                  ],
                  validateTrigger: 'blur',
                },
              ]"
            >
              <a-icon
                slot="prefix"
                type="lock"
                :style="{ color: 'rgba(0,0,0,.25)' }"
              />
            </a-input>
          </a-form-item>
          <!--a-form-item label="审核材料">
            <a-upload
              :file-list="fileList"
              :multiple="false"
              :remove="handleRemove"
              :before-upload="beforeUpload"
            >
              <a-button> 选择文件 </a-button>
            </a-upload>
          </a-form-item-->
          <a-form-item style="margin-top: 24px">
            <a-button
              size="large"
              type="primary"
              class="login-button"
              :loading="registerLoading"
              @click="handleRegister()"
              >确定</a-button
            >
          </a-form-item>
        </a-tab-pane>
      </a-tabs>
    </a-form>
  </div>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from "vuex";
export default {
  name: "register",
  components: {},

  data() {
    return {
      registerLoading: false,
      form: this.$form.createForm(this),
      fileList: [],
    };
  },

  computed: {
    ...mapGetters(["token"]),
  },
  mounted() {},

  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect;
      },
    },
    immediate: true,
  },

  methods: {
    ...mapActions(["register"]),

    //handler
    handleUsernameOrEmail(rule, value, callback) {
      const { state } = this;
      const regex = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
      if (regex.test(value)) {
        callback();
      } else {
        callback(new Error("请输入有效用户名或邮箱"));
      }
      callback();
    },
    checkEmail(rule, value, callback) {
      const re = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
      if (re.test(value)) {
        callback();
      } else {
        callback(new Error("请输入有效邮箱"));
      }
      callback();
    },
    handlePassword(rule, value, callback) {
      if (value.length < 6) {
        callback(new Error("密码长度至少6位"));
      }
      callback();
    },
    handlePasswordCheck(rule, value, callback) {
      const password = this.form.getFieldValue("registerPassword");
      console.log(password);
      if (value === undefined) {
        callback(new Error("请输入密码"));
      }
      if (value && password && value.trim() !== password.trim()) {
        callback(new Error("两次密码不一致"));
      }
      callback();
    },
    handleRemove(file) {
      const index = this.fileList.indexOf(file);
      const newFileList = this.fileList.slice();
      newFileList.splice(index, 1);
      this.fileList = newFileList;
    },
    beforeUpload(file) {
      this.fileList = [...this.fileList, file];
      return false;
    },

    handleRegister() {
      const validateFieldsKey = [
        "registerUserName",
        "registerPhoneNumber",
        "registerUserMail",
        "registerPassword",
        "registerPasswordconfirm",
        "registerUserRole",
      ];
      this.form.validateFields(
        validateFieldsKey,
        {
          force: true,
        },
        async (err, values) => {
          if (!err) {
            this.registerLoading = true;
            const data = {
              role: this.form.getFieldValue("registerUserRole"),
              email: this.form.getFieldValue("registerUserMail"),
              password: this.form.getFieldValue("registerPassword"),
              phoneNumber: this.form.getFieldValue("registerPhoneNumber"),
              username: this.form.getFieldValue(
                "registerUserName"
              ),
              //file: this.fileList
            };
            console.log("formData",data)
            await this.register(data).then(() => {
              this.form.setFieldsValue({
                registerUserMail: "",
                registerPassword: "",
                registerPasswordconfirm: "",
              });
              this.$message.success('注册信息已成功提交，请等待审核结束')
              this.goToLogin();
            });
            this.registerLoading = false;
          }
        }
      );
    },
    goToLogin() {
      this.$router.push("/login");
    },
  },
};
</script>


<style lang="less" scoped>
// .register {
// }

.user-register {
  position: absolute;
  min-width: 260px;
  width: 368px;
  right: 10.5%;
  top: 28%;
  label {
    font-size: 14px;
  }

  .getCaptcha {
    display: block;
    width: 100%;
    height: 40px;
  }

  .forge-password {
    font-size: 14px;
  }

  button.login-button {
    padding: 0 15px;
    font-size: 16px;
    height: 40px;
    width: 100%;
  }

  .user-login-other {
    text-align: left;
    margin-top: 24px;
    line-height: 22px;

    .item-icon {
      font-size: 24px;
      color: rgba(0, 0, 0, 0.2);
      margin-left: 16px;
      vertical-align: middle;
      cursor: pointer;
      transition: color 0.3s;

      &:hover {
        color: #1890ff;
      }
    }

    .register {
      float: right;
    }
  }
}
</style>