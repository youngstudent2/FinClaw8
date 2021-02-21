import Vue from 'vue'
import { message } from 'ant-design-vue'

import {getAllOperationAPI} from "../../api/monitor";

const monitor = {
    state: {
        monitorInfo: []
    },

    mutations: {
        set_monitorInfo: function(state, data) {
            state.monitorInfo = data
        },
    },

    actions: {
        getAllOperation: async ({ commit }, data) => {
            const res = await getAllOperationAPI(data);
            if (res) {
                commit('set_monitorInfo', res);
            }
        },

    }
};

export default monitor