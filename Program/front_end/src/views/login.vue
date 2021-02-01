<template>
    <div class="main">
        <div class="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;">
            <img src='https://finclaw.oss-cn-shenzhen.aliyuncs.com/img/登录.png' width="100%" height="100%"/>
        </div>
        <a-form id="formLogin" class="user-layout-login" ref="formLogin" :form="form">
            <a-tabs :activeKey="customActiveKey" :tabBarStyle="{ textAlign: 'center', borderBottom: 'unset' }"
                @change="handleTabClick">
                <a-tab-pane key="tab1" tab="账号密码登录">
                    <a-form-item>
                        <a-input size="large" type="text" placeholder="邮箱" v-decorator="[
                'username',
                {rules: [{ required: true, message: '请输入邮箱地址' }], validateTrigger: 'blur'}
              ]">
                            <a-icon slot="prefix" type="user" :style="{ color: 'rgba(0,0,0,.25)' }" />
                        </a-input>
                    </a-form-item>

                    <a-form-item>
                        <a-input size="large" type="password" autocomplete="false" placeholder="密码" v-decorator="[
                'password',
                {rules: [{ required: true, message: '请输入密码' }], validateTrigger: 'blur'}
              ]">
                            <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }" />
                        </a-input>
                    </a-form-item>
                    <a-form-item style="margin-top:24px">
                        <a-button size="large" type="primary" class="login-button" :loading="loginLoading"
                            @click="handlelogin()">确定
                        </a-button>
                    </a-form-item>
                </a-tab-pane>


            </a-tabs>
        </a-form>

    </div>
</template>

<script>
    import {
        mapGetters,
        mapActions,
        mapMutations
    } from 'vuex'

    export default {
        name: 'login',
        components: {},
        data() {
            return {
                customActiveKey: 'tab1',
                loginLoading: false,
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
            $route: {
                handler: function (route) {
                    this.redirect = route.query && route.query.redirect
                },
                immediate: true
            },
        },
        methods: {
            ...mapActions([
                'login',
            ]),

            // handler
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
                // if (value === undefined) {
                //     callback(new Error('请输入密码'))
                // }
                if (value && password && value.trim() !== password.trim()) {
                    callback(new Error('两次密码不一致'))
                }
                callback()
            },
            handleTabClick(key) {
                this.customActiveKey = key
            },
            handlelogin() {
                const validateFieldsKey = ['username', 'password']
                this.form.validateFields(validateFieldsKey, {
                    force: true
                }, async (err, values) => {
                    if (!err) {
                        this.loginLoading = true
                        const data = {
                            email: this.form.getFieldValue("username"),
                            password: this.form.getFieldValue("password")
                        }
                        await this.login(data)
                        this.loginLoading = false
                    }
                })
            }
        }
    }
</script>

<style lang="less" scoped>
    // .main {
    // }
    .user-layout-login {
        position: absolute;
        min-width: 260px;
        width: 368px;
        right: 10.5%;
        top: 37%;

        // margin: 300px auto;
        
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