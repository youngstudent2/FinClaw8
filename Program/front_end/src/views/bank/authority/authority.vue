<template>
    <a-table :columns="columns" :data-source="cooperationList">
        <span slot="action" slot-scope="record">
            <a-button type="primary" ghost @click="control(record.userID)">
                权限控制
            </a-button>
        </span>
    </a-table>
</template>


<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
const columns = [
    {
        title: '数据提供方',
        dataIndex: 'username',
    },
    {
        title: '联系电话',
        dataIndex: 'phoneNumber'
    },
    {
        title: '邮件地址',
        dataIndex: 'email'
    },
    {
        title: '服务密码',
        dataIndex: 'password',
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
            'cooperationList',
            'projectID',
            'userId',
        ])
    },
    async mounted() {
        console.log(Number(this.projectID))
        await this.getProjectCooperation(1)
    },
    methods: {
        ...mapActions([
            "controlAuthority",
            "getProjectCooperation",
        ]),
        control(cooperationID) {
            const data = {
                cooperationID: cooperationID,
                projectID: 1
            }
            this.controlAuthority(data)
        }
    }
}
</script>

<style scoped lang="less">
</style>