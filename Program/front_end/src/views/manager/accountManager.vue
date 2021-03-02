<template>
    <a-table :columns="accountColumns" :data-source="AllUsers" :bordered=true>
        <span slot="action" slot-scope="record" style="display: flex; justify-content: center">
            <a-button type="danger" @click="deleteUsers(record.userID)">删除用户</a-button>
        </span>
    </a-table>
</template>

<script>
    import {mapActions, mapMutations, mapGetters} from "vuex";
    const accountColumns = [
        {
            title: '用户编号',
            dataIndex: 'userID',
        },
        {
            title: '用户名',
            dataIndex: 'username',
        },
        {
            title: '用户邮箱',
            dataIndex: 'email',
        },
        {
            title: '密码',
            dataIndex: 'password',
        },
        {
            title: '联系电话',
            dataIndex: 'phoneNumber',
        },
        {
            title: '角色',
            dataIndex: 'role',
        },
        {
            title: '操作',
            key: 'action',
            scopedSlots: {customRender: 'action'},
            align: 'center'
        }
    ];
export default {
    name: 'accountManage',
    data(){
        return {
            accountColumns,
        }
    },
    components: {

    },
    computed: {
        ...mapGetters([
            'AllUsers',
        ])
    },
    async mounted() {
        await this.getAllUserInfo();
    },
    methods: {
        ...mapActions([
            'getAllUserInfo',
            'deleteUser',
        ]),
        deleteUsers(userID){
            this.deleteUser(userID);
        }
    }
}
</script>

<style>

</style>