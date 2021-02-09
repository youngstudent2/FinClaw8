import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    attendProjectAPI,
    quitProjectAPI,
    uploadServiceInfoAPI,
    setReadyAPI,
    getAllAttendedProjectsAPI,
    getAllUnattendedProjectsAPI
} from '@/api/attendance'

const cooperation = {
    state: {
        attendedProjects: [],
        unattendedProjects: []
    },

    mutations: {
        set_attendedProjects: function(state, data) {
            state.attendedProjects = data
        },
        set_unattendedProjects: function(state,data) {
            state.unattendedProjects = data
        }
    },
    getters: {
        getUnattendedProjectInfoByID: (state) => (id) => {
            return state.unattendedProjects.find(project => project.projectID === id)
        }
    },
    actions: {
        attendProject: async ({dispatch,commit},data) => {
            const res = await attendProjectAPI(data)
            message.loading('正在加入',0.25)
            if (typeof(res)!=undefined) {               
                message.success('成功加入')
                dispatch('getAllAttendedProjects',{cooperationID:data.cooperationID})
                dispatch('getAllUnattendedProjects',{cooperationID:data.cooperationID})
            }
            
        },
        quitProject: async ({ dispatch,commit },data) => {
            const res = await quitProjectAPI(data)
            message.loading('正在退出',0.25)
            if (typeof(res)!=undefined) {
                message.success('成功退出')
                dispatch('getAllAttendedProjects',{cooperationID:data.cooperationID})
                dispatch('getAllUnattendedProjects',{cooperationID:data.cooperationID})
            }
        },
        uploadServiceInfo: async ({commit},data) => {
            const res = await uploadServiceInfoAPI(data)
            message.loading('正在上传',0.25)
            if (typeof(res)!=undefined) {
                message.success('成功上传')
            }
        },
        setReady: async ({commit},data) => {
            const res = await setReadyAPI(data)
            message.loading('请稍等',0.25)
            if (typeof(res)!=undefined) {
                message.success('准备好了')
            }
        },
        getAllAttendedProjects: async ({ commit }, data) => {
            const res = await getAllAttendedProjectsAPI(data)

            if (res) {
                commit('set_attendedProjects', res)
            }
        },
        getAllUnattendedProjects: async ({ commit }, data) => {
            const res = await getAllUnattendedProjectsAPI(data)

            if (res) {             
                commit('set_unattendedProjects', res)
            }
        },
    }
}

export default cooperation