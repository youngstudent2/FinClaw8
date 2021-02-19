<template>
    <div>
        <div v-if="this.hasNotDealt">
            <div>
                <div>
                    <a-descriptions title="申请详情" bordered :column="{ xxl: 4, xl: 3, lg: 3, md: 3, sm: 2, xs: 1 }">
                        <a-descriptions-item label="申请人">
                            {{ loan_detail.userName }}
                        </a-descriptions-item>
                        <a-descriptions-item label="申请金额">
                            {{ loan_detail.amount }}
                        </a-descriptions-item>
                        <a-descriptions-item label="申请时间">
                            {{ new Date(loan_detail.createTime).toLocaleDateString().replace(/\//g, '-') }}
                        </a-descriptions-item>
                    </a-descriptions>
                </div>
                <!-- <a-button type="danger">撤销申请</a-button> -->
            </div>
            <a-divider />
            <div>
                <h2>银行回复</h2>
                <a-table :columns="columns" :data-source="this.loanApplicationResponse" id="response">
                    <a slot="bank" slot-scope="text">{{ text }}</a>
                    <span slot="customTitle">
                        <a-icon type="bank" /> 银行
                    </span>

                    <span slot="action" slot-scope="record">
                        <a @click="accept(record)">接受</a>
                        <a-divider type="vertical" />
                        <a>放弃</a>
                    </span>
                </a-table>
            </div>
        </div>

        <div v-else>
            <h2>申请管理</h2>
            暂无未处理贷款申请，可至<a @click="gotoLoan">贷款申请</a>处进行贷款
        </div>

    </div>
</template>

<script>
    import {
        mapGetters,
        mapMutations,
        mapActions
    } from 'vuex'
    const columns = [{
            dataIndex: 'bankName',
            key: 'bank',
            slots: {
                title: 'customTitle'
            },
            scopedSlots: {
                customRender: 'bank'
            },
        },
        {
            title: '意愿贷款金额',
            dataIndex: 'amount',
            key: 'amount',
        },
        {
            title: '意愿贷款利息',
            dataIndex: 'interestRate',
            key: 'interestRate',
        },
        {
            title: '操作',
            key: 'action',
            scopedSlots: {
                customRender: 'action'
            },
        },
    ];

    export default {
        data() {
            return {
                loan_detail: {},
                columns,
                hasNotDealt: false,
            };
        },
        async mounted() {
            await this.getUserLoanApplication(this.userId);
            console.log(this.userLoanApplication);
            for (let loan of this.userLoanApplication) {
                if (!loan.hasDealt) {
                    this.hasNotDealt = true;
                    this.loan_detail = loan;
                    break;
                }
            }
            await this.getLendingHistoryByLoanApplicationID(this.loan_detail.loanApplicationID);
        },
        computed: {
            ...mapGetters([
                'userLoanApplication',
                'loanApplicationResponse',
                'userId'
            ])
        },
        methods: {
            ...mapActions([
                'getUserLoanApplication',
                'getLendingHistoryByLoanApplicationID',
                'setDealt'
            ]),
            gotoLoan() {
                this.$router.push('/loaner/request');
            },
            accept(record) {
                this.setDealt([record.loanApplicationID, record.lendingHistoryID]);
                this.$router.push('/loaner/responseReview');
            }
        },
    };
</script>

<style>
    h1 {
        display: inline;
    }

    #detail-btn {
        float: right;
    }

    atable-thead>tr>th {
        text-align: center;
    }
</style>