<template>
    <div>
        <a-modal
            :visible="controlModalVisible"
            title="权限控制"
            cancelText="取消"
            okText="确定"
            @cancel="cancelSubmit"
            @ok="handleSubmit"
        >
            <a-form :form="form" style="margin-top: 30px" v-bind="formItemLayout">
                <a-form-item label="文件路径" v-bind="formItemLayout">
                    {{currentServerInfo.filePath === "null" ? "未设置" : currentServerInfo.filePath}}
                </a-form-item>
                <a-form-item label="IP地址" v-bind="formItemLayout">
                    {{currentServerInfo.ipAddress === "null" ? "未设置" : currentServerInfo.ipAddress}}
                </a-form-item>
                <a-form-item label="服务器名" v-bind="formItemLayout">
                    {{currentServerInfo.serverName === "null" ? "未设置" : currentServerInfo.serverName}}
                </a-form-item>
                <a-form-item label="服务密码" v-bind="formItemLayout">
                    {{currentServerInfo.serverPassword === "null" ? "未设置" : currentServerInfo.serverPassword}}
                </a-form-item>
                <a-form-item label="准备状态" v-bind="formItemLayout">
                    {{currentAttendanceInfo.ready === true ? "已准备" : "未准备"}}
                </a-form-item>
                <a-form-item label="是否采用" v-bind="formItemLayout">
                    <a-switch :key="chosen" :default-checked="chosen" @change="onChange" />
                </a-form-item>
            </a-form>
        </a-modal>
    </div>
</template>

<script>
import {mapActions, mapGetters, mapMutations} from "vuex";
export default {
    name: "controlModal",
    data(){
        return {
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
            form: this.$form.createForm(this, { name: 'controlModal'}),
            chosen: false
        }
    },
    computed: {
        ...mapGetters([
            'controlModalVisible',
            'currentServerInfo',
            'currentAttendanceInfo'
        ]),
    },
    methods: {
        ...mapMutations([
            'set_controlModalVisible',
        ]),
        ...mapActions([
            'setChosenStatus'
        ]),
        onChange(checked) {
            this.chosen = checked
        },
        cancelSubmit() {
            this.set_controlModalVisible(false)
        },
        handleSubmit(e) {
            e.preventDefault();
            this.form.validateFieldsAndScroll((err, values) => {
                if (!err) {
                    const data = {
                        projectID: this.currentAttendanceInfo.projectID,
                        cooperationID: this.currentAttendanceInfo.userID,
                        isChosen: this.chosen
                    }
                    //console.log(data)
                    this.setChosenStatus(data)
                    this.set_controlModalVisible(false)
                }
            });
        },
    },
}
</script>

<style scoped>

</style>