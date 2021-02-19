import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    predictAPI,
} from '@/api/kubefate'

const kubefate = {
    state: {
        predictPoint: 80,
    },

    mutations: {
        set_predictPoint: function(state, data) {
            state.predictPoint = data
        },
    },

    actions: {
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