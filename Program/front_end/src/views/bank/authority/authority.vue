<template>
    <div>
        <a-table :columns="columns" :data-source="cooperationList">
        <span slot="action" slot-scope="record">
            <a-button type="primary" ghost @click="control(record.userID)">
                权限控制
            </a-button>
        </span>
        </a-table>
        <ControlModal ref="controlModal"></ControlModal>
    </div>
</template>


<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
import ControlModal from "./components/controlModal";
const columns = [
    {
        title: '数据提供方',
        dataIndex: 'username',
    },
    {
        title: '联系电话',
        dataIndex: 'phoneNumber'
    },
    {
        title: '邮件地址',
        dataIndex: 'email'
    },
    {
        title: '操作',
        key: 'action',
        scopedSlots: { customRender: 'action' },
    },
];


export default {
    name: 'authority',
    data(){
        return {
            columns,
        };
    },
    components: {
        ControlModal
    },
    computed: {
        ...mapGetters([
            'cooperationList',
            'projectID',
            'userId',
            'currentAttendanceInfo'
        ])
    },
    async mounted() {
        console.log(Number(this.projectID))
        await this.getProjectCooperation(1)
    },
    methods: {
        ...mapMutations([
            'set_controlModalVisible',
        ]),
        ...mapActions([
            "getCooperationInfo",
            "getProjectCooperation",
        ]),
        control(cooperationID) {
            const data = {
                cooperationID: cooperationID,
                projectID: 1
            }
            this.getCooperationInfo(data)
            this.$refs.controlModal.chosen = this.currentAttendanceInfo.chosen
            this.set_controlModalVisible(true)
        }
    }
}
</script>

<style scoped lang="less">
</style>