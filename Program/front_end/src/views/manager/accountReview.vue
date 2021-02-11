<template>
    <a-table :columns="accountColumns" :data-source="unauthorizedUsers">

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
    ];
    export default {
        name: 'accountReview',
        data(){
            return {
                accountColumns,
            }
        },
        components: {

        },
        computed: {
            ...mapGetters([
                'unauthorizedUsers',
            ])
        },
        async mounted() {
            await this.getUnauthorizedUsers();
            console.log(this.unauthorizedUsers);
        },
        methods: {
            ...mapActions([
                'getUnauthorizedUsers',
            ]),
        }
    }
</script>

<style>

</style>