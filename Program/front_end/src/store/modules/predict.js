import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    predictAPI,
} from '@/api/predict'

const predict = {
    state: {
        predictScore: '',
    },

    mutations: {
        set_predictScore: function(state, data) {
            state.predictScore = data
        }
    },

    actions: {
        predict: async ({ commit },  data) => {
            const res = await predictAPI(data)
            if(res){
                commit('set_predictScore', res)
                message.success('预测成功')
                return res
            }
        },
    }
}

export default predict