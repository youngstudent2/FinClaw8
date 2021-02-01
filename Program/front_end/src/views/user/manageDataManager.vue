<template>
    <div>
        <div style="width: 100%; text-align: right; margin:20px 0">
          <a-button type="primary" @click="addDataManager"><a-icon type="user-add" />添加数据操作员</a-button>
        </div>
        <a-table
            :columns="dataManagerColumns"
            :dataSource="AllDataManagers"
            style="margin-top: 16px"
            bordered>
              <span slot="action" slot-scope="record">
                <a-popconfirm
                  title="确定想删除该数据操作员？"
                  @confirm="delUser(record)"
                  okText="确定"
                  cancelText="取消"
                >
                  <a-button type="danger">删除用户</a-button>
                </a-popconfirm>
              </span>
        </a-table>
        <!-- 条件隐藏 -->
        <DataManagerRegistrationModal></DataManagerRegistrationModal>
    </div>
</template>

<script>
  import { mapGetters, mapMutations, mapActions } from 'vuex'
  import DataManagerRegistrationModal from './components/DataManagerRegistrationModal'
  const dataManagerColumns = [
    {
      title:'用户编号',
      dataIndex: 'userID'
    },
    {
      title:'用户名',
      dataIndex: 'username'
    },
    {
      title:'邮箱',
      dataIndex: 'email'
    },
    {
      title:'手机号',
      dataIndex: 'phoneNumber'
    },
    {
      title: '操作',
      key: 'action',
      scopedSlots: { customRender: 'action' },
    },
  ]
  export default {
    name: 'manageDataManager',
    data(){
      return {
        dataManagerColumns
      }
    },
    components: {
      DataManagerRegistrationModal,
    },
    computed: {
        ...mapGetters([
            'AllDataManagers'
        ])
    },
    async mounted() {
      await this.getAllDataManagers()
    },
    methods: {
      ...mapActions([
        'getAllDataManagers',
        'deleteUser',
        'registerDataManager'
      ]),

      ...mapMutations([
        'set_DataManagerRegistrationModalVisible'
      ]),

      delUser(record){
        console.log(record.userID)
        this.deleteUser(record.userID)
      },

      addDataManager(){
        this.set_DataManagerRegistrationModalVisible(true)
      },

    },
  }
</script>

<style scoped lang="less">
</style>