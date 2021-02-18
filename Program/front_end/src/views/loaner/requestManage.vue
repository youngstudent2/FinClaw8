<template>
    <div>
        <div>
            <div>
                <a-descriptions title="申请详情" bordered
                    :column="{ xxl: 4, xl: 3, lg: 3, md: 3, sm: 2, xs: 1 }">
                    <a-descriptions-item label="申请人">
                        {{ loan_detail.person }}
                    </a-descriptions-item>
                    <a-descriptions-item label="申请金额(万元)">
                        {{ loan_detail.amount }}
                    </a-descriptions-item>
                    <a-descriptions-item label="申请时间">
                        {{ loan_detail.time }}
                    </a-descriptions-item>
                </a-descriptions>
            </div>
            <a-button type="danger">撤销申请</a-button>
        </div>
        <a-divider />
        <div>
            <h2>银行回复</h2>
            <a-table :columns="columns" :data-source="data">
                <a slot="bank" slot-scope="text">{{ text }}</a>
                <span slot="customTitle">
                    <a-icon type="bank" /> 银行
                </span>

                <span slot="action">
                    <a>接受</a>
                    <a-divider type="vertical" />
                    <a>放弃</a>
                </span>
            </a-table>
        </div>

    </div>
</template>

<script>
    const columns = [{
            dataIndex: 'bank',
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
            dataIndex: 'rate',
            key: 'rate',
        },
        {
            title: '操作',
            key: 'action',
            scopedSlots: {
                customRender: 'action'
            },
        },
    ];

    const data = [{
            key: '1',
            bank: '花旗银行',
            amount: 32,
            rate: '5%',
            address: 'New York No. 1 Lake Park',
            tags: ['nice', 'developer'],
        },
        {
            key: '2',
            bank: '中国银行',
            amount: 42,
            rate: '5%',
            address: 'London No. 1 Lake Park',
            tags: ['loser'],
        },
        {
            key: '3',
            bank: '中国建设银行',
            amount: 32,
            rate: '5%',
            address: 'Sidney No. 1 Lake Park',
            tags: ['cool', 'teacher'],
        },
    ];

    export default {
        data() {
            return {
                loan_detail: {
                    person: '张三',
                    amount: 20,
                    time: '2020-04-01',
                },
                data,
                columns,
            };
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
</style>