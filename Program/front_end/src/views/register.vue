<template>
    <div class="register">
        <div class="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;">
            <img src='https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/注册.png' width="100%" height="100%"/>
        </div>
        <a-form
            id="formRegister"
            class="user-register"
            ref="formRegister"
            :form="form"
        >

            <a-tabs
                :tabBarStyle="{ textAlign: 'center', borderBottom: 'unset' }"
            >
                <a-tab-pane key="tab1" tab="注册合作企业账号">
                <a-form-item>
                    <a-input
                    size="large"
                    type="email"
                    placeholder="邮箱"
                    v-decorator="[
                    'registerUserMail', 
                    {rules: [{ required: true, type: 'email', message: '请输入邮箱' }], validateTrigger: 'blur'}]">
                    <a-icon slot="prefix" type="mail" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input
                    size="large"
                    placeholder="企业名称"
                    v-decorator="[
                    'registerCooperationName', 
                    {rules: [{ required: true, message: '请输入企业名称' }], validateTrigger: 'blur'}]">
                    <a-icon slot="prefix" type="safety" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input
                    size="large"
                    placeholder="负责人姓名"
                    v-decorator="[
                    'RegisterManagerName', 
                    {rules: [{ required: true, message: '请输入负责人姓名' }], validateTrigger: 'blur'}]">
                    <a-icon slot="prefix" type="user" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input
                    size="large"
                    placeholder="手机号"
                    v-decorator="[
                    'registerPhoneNumber', 
                    {rules: [{ required: true, message: '请输入手机号' }], validateTrigger: 'blur'}]">
                    <a-icon slot="prefix" type="phone" :style="{ color: 'rgba(0,0,0,.25)' }"/>
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
                        {rules: [{ required: true, message: '请输入密码' }, { validator: this.handlePassword }], validateTrigger: 'blur'}]">
                    <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input
                    size="large"
                    type="password"
                    placeholder="确认密码"
                    v-decorator="[
                        'registerPasswordconfirm', 
                        {rules: [{ required: true, message: '请输入密码' }, { validator: this.handlePasswordCheck }], validateTrigger: 'blur'}]">
                    <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                    </a-input>
                </a-form-item>
                <a-form-item style="margin-top:24px">
                    <a-button
                    size="large"
                    type="primary"
                    class="login-button"
                    :loading="registerLoading"
                    @click="handleRegister()"
                    >确定</a-button>
                </a-form-item>
                </a-tab-pane>
            </a-tabs>


        </a-form>
    </div>
</template>

<script>
    import {mapGetters,mapActions,mapMutations} from 'vuex'
    export default {
        name: 'register',
        components:{},
    
        data() {
            return {
                registerLoading: false,
                form: this.$form.createForm(this),
            }
        },

        computed: {
            ...mapGetters([
                'token'
            ])
        },
        mounted() {

        },

        watch: {
            $route:{
                handler: function(route) {
                    this.redirect = route.query && route.query.redirect
                }
            },
            immediate: true
        },

        methods: {
            ...mapActions([
                'registerCooperation'
            ]),

            //handler
            handleUsernameOrEmail(rule, value, callback) {
                const {
                    state
                } = this
                const regex = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
                if (regex.test(value)) {
                    callback()
                } else {
                    callback(new Error('请输入有效用户名或邮箱'))
                }
                callback()
            },
            checkEmail(rule, value, callback) {
                const re = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
                if (re.test(value)) {
                    callback();
                } else {
                    callback(new Error('请输入有效邮箱'));
                }
                callback()
            },
            handlePassword(rule, value, callback) {
                if (value.length < 6) {
                    callback(new Error('密码长度至少6位'))
                }
                callback()
            },
            handlePasswordCheck(rule, value, callback) {
                const password = this.form.getFieldValue('registerPassword')
                console.log(password)
                if (value === undefined) {
                    callback(new Error('请输入密码'))
                }
                if (value && password && value.trim() !== password.trim()) {
                    callback(new Error('两次密码不一致'))
                }
                callback()
            },
            handleRegister() {
                const validateFieldsKey = [
                    'registerCooperationName', 'registerPhoneNumber', 'registerUserMail', 'registerPassword',
                    'registerPasswordconfirm', 'registerCooperationName'
                ]
                this.form.validateFields(validateFieldsKey, {
                    force: true
                }, async (err, values) => {
                    if (!err) {
                        this.registerLoading = true
                        const data = {
                            email: this.form.getFieldValue('registerUserMail'),
                            password: this.form.getFieldValue('registerPassword'),
                            phoneNumber: this.form.getFieldValue('registerPhoneNumber'),
                            cooperationName: this.form.getFieldValue('registerCooperationName'),
                            manager:this.form.getFieldValue('RegisterManagerName')
                        }
                        await this.registerCooperation(data).then(() => {
                            this.form.setFieldsValue({
                                'registerUserMail': '',
                                'registerPassword': '',
                                'registerPasswordconfirm': ''
                            })
                            this.goToLogin()
                        })
                        this.registerLoading = false
                    }
                });
            },
            goToLogin(){
                this.$router.push('/login')
            }
        }
    }
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