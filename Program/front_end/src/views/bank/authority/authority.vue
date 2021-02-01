<template>
    <a-table :columns="columns" :data-source="cooperationsList">
        <span slot="customTitle">
            <a-icon type="smile-o" />
            合作方
        </span>
        <span slot="action" slot-scope="record">
            <a-button type="dashed" @click="Open(record)" v-if="record.authority===0">
                开放权限
            </a-button>
            <a-button type="danger" @click="Close(record)" v-if="record.authority===1">
                关闭权限
            </a-button>
        </span>
    </a-table>
</template>


<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
const columns = [
    {
        title: '合作方ID',
        dataIndex: 'cooperationID',
    },
    {
        dataIndex: '合作方名称',
        slots: { title: 'customTitle' },
        scopedSlots: { customRender: 'cooperationName' },
    },
    {
        title: '电话号码',
        dataIndex: 'phoneNumber',
        scopedSlots: { customRender: 'phoneNumber' },
    },
    {
        title: 'Ip地址',
        dataIndex: 'ipAddress',
        scopedSlots: {customRender: 'ipAddress'},
    },
    {
        title: '服务名称',
        dataIndex: 'serviceName',
    },
    {
        title: '服务密码',
        dataIndex: 'servicePassword',
    },
    {
        title: '操作',
        key: 'action',
        scopedSlots: { customRender: 'action' },
    },
];


export default {
    name: 'authority',
    data(){
        return {
            columns,
        };
    },
    components: {

    },
    computed: {
        ...mapGetters([
            'cooperationsList',
            'projectID',
            'userId',
        ])
    },
    async mounted() {
        console.log(Number(this.projectID))
        await this.getProjectCooperations(Number(this.projectID))
    },
    methods: {
        ...mapActions([
            "OpenAuthority",
            "CloseAuthority",
            "getProjectCooperations",
        ]),
        Open(record){
            let params = {
                userId: Number(this.userId),
                projectID: Number(this.projectID),
                cooperationID: Number(record.cooperationID),
            }
            this.OpenAuthority(params)
        },
        Close(record){
            console.log(record)
            let params = {
                userId: Number(this.userId),
                projectID: Number(this.projectID),
                cooperationID: Number(record.cooperationID),
            }
            this.CloseAuthority(params)
        },
    }
}
</script>

<style scoped lang="less">
</style>