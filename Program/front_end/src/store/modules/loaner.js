import Vue from 'vue'
import router from '@/router'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { message } from 'ant-design-vue'

import {
    addLoanApplicationAPI,
    deleteLoanApplicationAPI,
    getAllLoanApplicationAPI,
    getLoanApplicationAPI,
    setDealtAPI,
    getUserLoanHistoryAPI
} from '@/api/loaner'

const loaner = {
    state : {

    },

    mutations: {

    },

    actions: {
        addLoanApplication: async({commit}, data) => {
            const res = await addLoanApplicationAPI(data)
            if (!res) {
                message.success('申请成功')
            }
        }
    }
}

export default loaner