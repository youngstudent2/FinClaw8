<template>
  <div>
      <div>
          <a-table :columns="columns" :data-source="allLoanApplication">
              <span slot="action" slot-scope="record">
                  <a-button type="primary" ghost @click="addLendingWish(record)">
                      添加放贷意愿
                  </a-button>
              </span>
          </a-table>
      </div>
      <AddLendingWishModal></AddLendingWishModal>
  </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
import AddLendingWishModal from "./components/addLendingWishModal";
const columns = [
    {
        title: '申请方',
        dataIndex: 'companyName',
    },
    {
        title: '申请金额',
        dataIndex: 'amount'
    },
    {
        title: '联系电话',
        dataIndex: 'phoneNumber'
    },
    {
        title: '操作',
        key: 'action',
        scopedSlots: { customRender: 'action' },
    },
];
export default {
    name: 'lending',
    data(){
        return {
            columns,
        };
    },
    components: {
        AddLendingWishModal
    },
    computed: {
        ...mapGetters([
            'userId',
            'allLoanApplication'
        ])
    },
    async mounted() {
        await this.getAllLoanApplication()
    },
    methods: {
        ...mapMutations([
            'set_addLendingWishModalVisible',
            'set_currentLoanerInfo'
        ]),
        ...mapActions([
            'getAllLoanApplication'
        ]),
        addLendingWish(record) {
            this.set_currentLoanerInfo(record)
            this.set_addLendingWishModalVisible(true)
        }
    }
}
</script>

<style>

</style>