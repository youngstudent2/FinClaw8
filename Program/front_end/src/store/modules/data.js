import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    getProjectDataAPI,
} from '@/api/data'

const data = {
    state: {
        projectData: []
    },

    mutations: {
        set_projectData: function(state, data) {
            state.projectData = data
        },
    },

    actions: {
        getProjectData: async ({ commit }, data) => {
            const res = await getProjectDataAPI(data)
            if (res) {
                commit('set_projectData', res)
            }
        },
    }
}

export default data