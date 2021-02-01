import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    closeAuthorityAPI,
    openAuthorityAPI,
    getAuthorityAPI,
} from '@/api/authority'
import{
    getProjectCooperationsAPI,
} from '@/api/project'


const authority = {
    state: {
        cooperationsList: [],
    },

    mutations: {
        set_cooperationsList: function(state, data) {
            state.cooperationsList = data
        },

    },

    actions: {
        getAuthority: async ({commit}, projectID, cooperationID) =>{
            const res = await getAuthorityAPI(projectID,cooperationID)
            if(res){
                commit()
            }
        },
        OpenAuthority: async ({dispatch}, params) =>{
            const res = await openAuthorityAPI(params)
            console.log(res)
            if(res){
                dispatch('getProjectCooperations',params.projectID)
                message.success("打开成功")
            }else{
                message.error(res.message)
            }
        },
        CloseAuthority: async ({dispatch}, params) =>{
            const res = await closeAuthorityAPI(params)
            console.log(res)
            if(res){
                dispatch('getProjectCooperations',params.projectID)
                message.success("关闭成功")
            }else{
                message.error(res.message)
            }
        },
        getProjectCooperations: async ({commit}, data) =>{
            const res = await getProjectCooperationsAPI(data)
            if(res){
                commit('set_cooperationsList', res)
            }
        },
    }
}

export default authority