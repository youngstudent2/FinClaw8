<template>
    <a-modal
            :visible="accountModalVisible"
            width="600px"
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

    </a-modal>
</template>

<script>
    import {mapGetters, mapMutations, mapActions} from 'vuex'
    export default {
        name: "accountModal",
        computed: {
            ...mapGetters([
                'temp',
                'accountModalVisible',
            ])
        },
        mounted() {
            console.log(this.temp);
        },
        methods: {
            ...mapMutations([
                'set_accountModalVisible',
            ]),
            ...mapActions([
                'reviewUser',
            ]),
            cancel(){
                this.set_accountModalVisible(false);
            },
            handleOk(){
                this.reviewUser(this.temp.userID);
                this.set_accountModalVisible(false);
            },
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