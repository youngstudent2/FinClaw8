<template>
    <div>
        <div>
            <h2>历史贷款信息</h2>
            <div v-if="this.history.length != 0">
            <a-table :columns="columns" :data-source="this.history">
                <a slot="bank" slot-scope="text">{{ text }}</a>
                <span slot="customTitle">
                    <a-icon type="bank" /> 银行
                </span>

                <span slot="createTime" slot-scope="text">
                    {{ new Date(text).toLocaleDateString().replace(/\//g, '-') }}
                </span>

                <span slot="action">
                    <a>accept</a>
                    <a-divider type="vertical" />
                    <a>Delete</a>
                </span>
            </a-table>
            </div>
            
            <div v-else>
                <span>暂无贷款记录</span>
            </div>
        </div>

    </div>
</template>

<script>
const columns = [
    {
        dataIndex: 'bankName',
        key: 'bankName',
        slots: {
            title: 'customTitle'
        },
        scopedSlots: {
            customRender: 'bank'
        },
        align: 'center',
    },
    {
        title: '贷款金额',
        dataIndex: 'amount',
        key: 'amount',
        align: 'center',
    },
    {
        title: '贷款利息',
        dataIndex: 'interestRate',
        key: 'interestRate',
        align: 'center',
    },
    {
        title: '贷款时间',
        dataIndex: 'createTime',
        key: 'createTime',
        scopedSlots: {
            customRender: 'createTime'
        },
        align: 'center',
    },
    {
        title: '申请人',
        dataIndex: 'person',
        key: 'person',
        align: 'center',
    },
];

import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
    data() {
        return {
            history: [],
            columns,
        };
    },
    async mounted() {
        await this.getUserLoanHistory(this.userId);
        for (let loan of this.userLoanHistory) {
            if (loan.hasDealt) {
                await this.getLendingHistoryByLoanApplicationID(loan.loanApplicationID);
                for (let res of this.loanApplicationResponse) {
                    if (res.hasDealt) {
                        res.person = loan.userName;
                        this.history.push(res);
                    }
                }
            }
        }
    },
    computed: {
        ...mapGetters([
            'userLoanHistory',
            'loanApplicationResponse',
            'userId'
        ]),
    },
    methods: {
        ...mapActions([
            'getUserLoanHistory',
            'getLendingHistoryByLoanApplicationID',
        ])
    }
};
</script>

<style>

</style>