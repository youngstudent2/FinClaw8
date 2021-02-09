import Vue from 'vue'
import { message } from 'ant-design-vue'

import{
    getProjectCooperationAPI,
    getServerInfoAPI,
    setChosenStatusAPI
} from '@/api/attendance'


const authority = {
    state: {
        cooperationList: [],
    },

    mutations: {
        set_cooperationList: function(state, data) {
            state.cooperationList = data
        },

    },

    actions: {
        controlAuthority: async ({commit}, data) =>{
            console.log(data)
            const res = await getServerInfoAPI(data.projectID, data.cooperationID)
            if(res){
                console.log(res)
            }
        },
        getProjectCooperation: async ({commit}, data) =>{
            const res = await getProjectCooperationAPI(data)
            if(res){
                console.log(res)
                commit('set_cooperationList', res)
            }
        },
    }
}

export default authority