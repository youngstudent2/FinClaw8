<template>
    <div>
        <a-steps v-model="current" type="navigation" :style="stepStyle" @change="onChange">
            <a-step
                title="部署"
                sub-title="deploy"
                status="wait"
                description="搭建训练环境"
            />
            <a-step
                title="上传"
                sub-title="upload"
                status="wait"
                description="上传相关文件"
            />
            <a-step
                title="训练"
                sub-title="train"
                status="wait"
                description="开始训练"
            />
        </a-steps>
        <a-space>
            <a-button size="large" type="primary" :disabled="current !== 0" @click="deploy(projectID)">
                <a-icon type="deployment-unit" /> 部 署
            </a-button>
            <a-button size="large" type="primary" :disabled="current !== 1" @click="upload(projectID)">
                <a-icon type="upload" /> 上 传
            </a-button>
            <a-button size="large" type="primary" :disabled="current !== 2" @click="train(projectID)">
                <a-icon type="cloud" /> 训 练
            </a-button>
            <a-button size="large" @click="query(projectID)">
                <a-icon type="search" /> 查询训练状态
            </a-button>
        </a-space>
    </div>
</template>

<script>
import {mapActions, mapGetters, mapMutations} from "vuex";

export default {
    name: 'config',
    data() {
        return {
            current: 0,
            stepStyle: {
                marginBottom: '60px',
                boxShadow: '0px -1px 0 0 #e8e8e8 inset',
            },
        };
    },
    computed: {
        ...mapGetters([
            'projectID',
        ])
    },
    methods: {
        ...mapMutations([
        ]),
        ...mapActions([
            'deploy',
            'upload',
            'train',
            'query'
        ]),
        onChange(current) {
            this.current = current;
        },
    },
}
</script>

<style>

</style>