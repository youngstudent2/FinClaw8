import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    deployAPI,
    uploadAPI,
    submitAPI,
    queryAPI,
    loadBindAPI,
    predictAPI,
} from '@/api/kubefate'

const kubefate = {
    state: {
        bindStatus: false,
        predictPoint: 80,
    },

    mutations: {
        set_bindStatus: function(state, data) {
            state.bindStatus = data
        },
        set_predictPoint: function(state, data) {
            state.predictPoint = data
        },
    },

    actions: {
        deploy: async ( {commit}, data ) => {
            const res = await deployAPI(data)
            if (res) {
                message.success("部署成功")
            }
            else {
                message.error("部署失败")
            }
        },
        upload: async ( {commit}, data ) => {
            const res = await uploadAPI(data)
            if (res) {
                message.success("上传成功")
            }
            else {
                message.error("上传失败")
            }
        },
        train: async ( {commit}, data ) => {
            const res = await submitAPI(data)
            if (res) {
                message.success("开始训练")
            }
            else {
                message.error("训练错误")
            }
        },
        query: async ( { commit }, data ) => {
            const res = await queryAPI(data)
            if (res) {
                message.info(res)
            }
        },
        loadBind: async ( { commit }, data ) => {
            const res = await loadBindAPI(data)
            if (res) {
                commit('set_bindStatus', true)
                message.success("绑定成功")
            }
            else {
                message.error("绑定失败")
            }
        },
        predict: async ({ commit }) => {
            const res = await predictAPI()
            if (res) {
                //console.log(res)
                commit('set_predictPoint', res)
            }
        },
    }
}

export default kubefate