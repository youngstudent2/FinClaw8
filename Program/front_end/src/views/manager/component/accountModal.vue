<template>
    <a-modal
            :visible="accountModalVisible"
            width="600px"
            okText="通过"
            cancelText="取消"
            @ok="handleOk"
            @cancel="cancel">
        <div class="a">
            <span class="l">用户编号：</span>
            <span class="r">{{temp.userID}}</span>
        </div>
        <div class="a">
            <span class="l">用户名：</span>
            <span class="r">{{temp.username}}</span>
        </div>
        <div class="a">
            <span class="l">用户邮箱：</span>
            <span class="r">{{temp.email}}</span>
        </div>
        <div class="a">
            <span class="l">密码：</span>
            <span class="r">{{temp.password}}</span>
        </div>
        <div class="a">
            <span class="l">联系电话：</span>
            <span class="r">{{temp.phoneNumber}}</span>
        </div>
        <div class="a">
            <span class="l">角色：</span>
            <span class="r">{{temp.role}}</span>
        </div>
        <a-table :columns="fileColumns" :data-source="userFiles">
            <span slot="uploadTime" slot-scope="text">
                <span>{{text.substring(0, 19).replace('T', ' ')}}</span>
            </span>
            <span slot="action" slot-scope="record">
                <a-button type="primary" size="small" @click="download(record)">下载</a-button>
            </span>
        </a-table>
    </a-modal>
</template>

<script>
    import {mapGetters, mapMutations, mapActions} from 'vuex'
    const fileColumns =[
        {
            title: '文件编号',
            dataIndex: 'fileID',
        },
        {
            title: '用户编号',
            dataIndex: 'userID',
        },
        {
            title: '文件名',
            dataIndex: 'fileName',
        },
        {
            title: '文件路径',
            dataIndex: 'filePath',
        },
        {
            title: '上传时间',
            dataIndex: 'uploadTime',
            scopedSlots: {customRender: 'uploadTime'},
        },
        {
            title: '操作',
            key: 'action',
            scopedSlots: {customRender: 'action'},
        },
    ];
    export default {
        name: "accountModal",
        data(){
            return {
                fileColumns,
            }
        },
        computed: {
            ...mapGetters([
                'temp',
                'accountModalVisible',
                'userFiles',
            ])
        },
        async mounted() {
            //console.log(this.temp);
            await this.getUserFiles(this.temp.userID);
        },
        methods: {
            ...mapMutations([
                'set_accountModalVisible',
            ]),
            ...mapActions([
                'reviewUser',
                'getUserFiles',
                'downloadFile',
            ]),
            cancel(){
                this.set_accountModalVisible(false);
            },
            handleOk(){
                this.reviewUser(this.temp.userID);
                this.set_accountModalVisible(false);
            },
            download(record){
                this.downloadFile(record.fileID);
            }
        },
    }

</script>

<style scoped>
    .a{
        padding-top: 10px;
        padding-bottom: 10px;
    }
    .l{
        display: inline-block;
        width: 100px;
        margin-left: 40px;
        font-size: 15px;
    }
    .r{
        margin-left: 10px;
        font-size: 15px;
    }
</style>