<template>
    <div>
        
        <div>
            <h2>历史贷款信息</h2>
            <a-table :columns="columns" :data-source="data">
                <a slot="bank" slot-scope="text">{{ text }}</a>
                <span slot="customTitle">
                    <a-icon type="bank" /> 银行
                </span>

                <span slot="action">
                    <a>accept</a>
                    <a-divider type="vertical" />
                    <a>Delete</a>
                </span>
            </a-table>
        </div>

    </div>
</template>

<script>
const columns = [
  {
    dataIndex: 'bank',
    key: 'bank',
    slots: { title: 'customTitle' },
    scopedSlots: { customRender: 'bank' },
  },
  {
    title: '贷款金额',
    dataIndex: 'amount',
    key: 'amount',
  },
  {
    title: '贷款利息',
    dataIndex: 'rate',
    key: 'rate',
  },
  {
    title: '贷款时间',
    dataIndex: 'time',
    key: 'time',
  },
  {
    title: '申请人',
    dataIndex: 'person',
    key: 'person',
  },
];

const data = [
  {
    key: '1',
    bank: '花旗银行',
    amount: 32,
    rate: '5%',
    time: '2020-04-01',
    person: '王经理',
  },
  {
    key: '2',
    bank: '中国银行',
    amount: 42,
    rate: '5%',
    time: '2020-04-01',
    person: '李经理',
  },
  {
    key: '3',
    bank: '中国建设银行',
    amount: 32,
    rate: '5%',
    time: '2020-04-01',
    person: '张经理',
  },
];

export default {
  data() {
    return {
      data,
      columns,
    };
  },
};
</script>

<style>

</style>