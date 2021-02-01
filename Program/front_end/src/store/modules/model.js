import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    getAllModelsAPI,
} from '@/api/model'

const model = {
    state: {
        modelList: []
    },

    mutations: {
        set_modelList: function(state, data) {
            state.modelList = data
        },
    },

    actions: {
        getModels: async ({ commit }) => {
            const res = await getAllModelsAPI()
            if (res) {
                commit('set_modelList', res)
            }
        },
    }
}

export default model