import Vue from 'vue'
import router from '@/router'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { message } from 'ant-design-vue'

import {
    addLoanApplicationAPI,
    deleteLoanApplicationAPI,
    getUserLoanApplicationAPI,
    getLoanApplicationAPI,
    setDealtAPI,
    getUserLoanHistoryAPI
} from '@/api/loaner'

const loaner = {
    state : {
        userLoanHistory: [],
    },

    mutations: {
        set_userLoanHistory: (state, data) => {
            state.userLoanHistory = data;
        }
    },

    actions: {
        addLoanApplication: async({commit}, data) => {
            const res = await addLoanApplicationAPI(data);
            if (!res) {
                message.success('申请成功');
            }
        },
        setDealt: async({commit}, loanApplicationID) => {
            const res = await setDealtAPI(loanApplicationID);
        },
        getUserLoanHistory: async({commit}, userID) => {
            const res = await getUserLoanHistoryAPI(userID);
            if (res) {
                commit('set_userLoanHistory', res);
            }
        }
    }
}

export default loaner