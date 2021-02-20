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
    setLoanApplicationDealtAPI,
    getUserLoanHistoryAPI
} from '@/api/loaner'
import {
    getLendingHistoryByLoanApplicationIDAPI,
    setDealtAPI,
} from '@/api/lending'

const loaner = {
    state : {
        userLoanApplication: [],
        userLoanHistory: [],
        loanApplicationResponse: [],
    },

    mutations: {
        set_userLoanHistory: (state, data) => {
            state.userLoanHistory = data;
        },
        set_loanApplicationResponse: (state, data) => {
            state.loanApplicationResponse = data;
        },
        set_userLoanApplication: (state, data) => {
            state.userLoanApplication = data;
        }
    },

    actions: {
        addLoanApplication: async({commit}, data) => {
            const res = await addLoanApplicationAPI(data);
            if (!res) {
                message.success('借款申请成功');
            }
        },
        setDealt: async({commit}, params) => {
            message.success('接受成功!');
            var loanApplicationID = params[0];
            var lendingHistoryID = params[1];
            await setLoanApplicationDealtAPI(loanApplicationID);
            await setDealtAPI(lendingHistoryID);
            
        },
        getUserLoanApplication: async({commit}, userID) =>{
            const res = await getUserLoanApplicationAPI(userID);
            if (res) {
                commit('set_userLoanApplication', res);
            }
        },
        getUserLoanHistory: async({commit}, userID) => {
            const res = await getUserLoanHistoryAPI(userID);
            if (res) {
                commit('set_userLoanHistory', res);
            }
        },
        getLendingHistoryByLoanApplicationID: async({commit}, loanApplicationID) => {
             const res = await getLendingHistoryByLoanApplicationIDAPI(loanApplicationID);
             if (res) {
                 commit('set_loanApplicationResponse', res);
             }
        },
    }
}

export default loaner