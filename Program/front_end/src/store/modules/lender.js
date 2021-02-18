import Vue from 'vue'
import router from '@/router'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { message } from 'ant-design-vue'

import {
    getAllLoanApplicationAPI,
} from '@/api/loaner'
import {
    getBankLendingHistoryAPI,
    addLendingFormAPI
} from "@/api/lending";

const lender = {
    state : {
        lendingHistory: [],
        allLoanApplication: [],
        addLendingWishModalVisible: false,
        currentLoanerInfo: []
    },

    mutations: {
        set_lendingHistory: function(state, data) {
            state.lendingHistory = data
        },
        set_allLoanApplication: function(state, data) {
            state.allLoanApplication = data
        },
        set_addLendingWishModalVisible: function(state, data) {
            state.addLendingWishModalVisible = data
        },
        set_currentLoanerInfo: function(state, data) {
            state.currentLoanerInfo = data
        },
    },

    actions: {
        getAllLoanApplication: async({commit}, data) => {
            const res = await getAllLoanApplicationAPI(data)
            if (res) {
                //console.log(res)
                commit('set_allLoanApplication', res)
            }
        },
        getBankLendingHistory: async({commit}, data) => {
            const res = await getBankLendingHistoryAPI(data)
            if (res) {
                //console.log(res)
                commit('set_lendingHistory', res)
            }
        },
        addLendingWish: async({dispatch}, data) => {
            const res = await addLendingFormAPI(data)
            if (res) {
                //console.log(res)
                message.success("添加成功")
            }
        },
    }
}

export default lender