<template>
    <div>
        <a-table :columns="accountColumns" :data-source="unauthorizedUsers">
            <span slot="action" slot-scope="record">
                <a-button type="primary" size="small" @click="showModal(record)">审核</a-button>
            </span>
        </a-table>
    <AccountModal></AccountModal>
    </div>
</template>

<script>
    import AccountModal from "./component/accountModal";
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
        },
    ];
    export default {
        name: 'accountReview',
        data(){
            return {
                accountColumns,
            }
        },
        components: {
            AccountModal,
        },
        computed: {
            ...mapGetters([
                'unauthorizedUsers',
                'accountModalVisible',
                'temp',
            ]),
        },
        async mounted() {
            await this.getUnauthorizedUsers();
            //console.log(this.unauthorizedUsers);
        },
        methods: {
            ...mapMutations([
                'set_temp',
                'set_accountModalVisible',
            ]),
            ...mapActions([
                'getUnauthorizedUsers',
            ]),
            showModal(record){
                this.set_temp(record);
                this.set_accountModalVisible(true);
                //console.log(this.temp);
            }
        }
    }
</script>

<style>

</style>