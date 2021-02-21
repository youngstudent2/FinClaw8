<template>
    <div>
        <a-table
            :columns="monitorInfoColumns"
            :dataSource="monitorInfo"
            style="margin-top: 16px"
            bordered>
            <span slot="operateTime" slot-scope="text">
                <span>{{text.substring(0, 19).replace('T', ' ')}}</span>
            </span>
        </a-table>
    </div>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
const monitorInfoColumns = [
    {
        title: '用户编号',
        dataIndex: 'userID'
    },
    {
        title: '项目编号',
        dataIndex: 'projectID'
    },
    {
        title: '操作时间',
        dataIndex: 'operateTime',
        scopedSlots: {customRender: 'operateTime'},
    },
    {
        title: '操作行为',
        dataIndex: 'operation'
    },
];
export default {
    name: 'monitor',
    data(){
        return {
            monitorInfoColumns,
        }
    },
    components: {

    },
    computed: {
        ...mapGetters([
            'monitorInfo',
        ])
    },
    async mounted() {
        await this.getAllOperation();
    },
    methods: {
        ...mapActions([
            'getAllOperation',
        ]),
    }
}
</script>
<style scoped lang="less">
</style>