<template>
    <div>
        <a-table :columns="columns" :data-source="lendingHistory">
            <span slot="state" slot-scope="record" style="vertical-align: middle">
                <a-tag v-if="record.hasDealt" color="green">{{"已接受"}}</a-tag>
                <a-tag v-else color="volcano">{{"未接受"}}</a-tag>
            </span>
        </a-table>
    </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex';
import AddLendingWishModal from "@/views/bank/components/addLendingWishModal";
const columns = [
    {
        title: '放贷方',
        dataIndex: 'bankName',
    },
    {
        title: '贷款方',
        dataIndex: 'lenderName'
    },
    {
        title: '联系电话',
        dataIndex: 'phoneNumber'
    },
    {
        title: '贷款金额',
        dataIndex: 'amount'
    },
    {
        title: '利率',
        dataIndex: 'interestRate'
    },
    {
        title: '状态',
        key: 'state',
        scopedSlots: { customRender: 'state' },
    },
];
export default {
    name: "history",
    data(){
        return {
            columns,
        };
    },
    computed: {
        ...mapGetters([
            'userId',
            'lendingHistory'
        ])
    },
    async mounted() {
        await this.getBankLendingHistory(Number(this.userId))
    },
    methods: {
        ...mapMutations([

        ]),
        ...mapActions([
            'getBankLendingHistory'
        ]),
    }
}
</script>

<style scoped>

</style>