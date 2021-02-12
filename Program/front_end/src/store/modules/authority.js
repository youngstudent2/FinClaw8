import Vue from 'vue'
import { message } from 'ant-design-vue'

import{
    getProjectCooperationAPI,
    getServerInfoAPI,
    setChosenStatusAPI,
    getAttendanceInfoAPI
} from '@/api/cooperation'


const authority = {
    state: {
        cooperationList: [],
        controlModalVisible: false,
        currentServerInfo: [],
        currentAttendanceInfo: [],
    },

    mutations: {
        set_cooperationList: function(state, data) {
            state.cooperationList = data
        },
        set_controlModalVisible: function(state, data) {
            state.controlModalVisible = data
        },
        set_currentServerInfo: function(state, data) {
            state.currentServerInfo = data
        },
        set_currentAttendanceInfo: function(state, data) {
            state.currentAttendanceInfo = data
        },
    },

    actions: {
        getProjectCooperation: async ({commit}, data) => {
            const res = await getProjectCooperationAPI(data)
            if (res) {
                //console.log(res)
                commit('set_cooperationList', res)
            }
        },
        getCooperationInfo: async ({commit}, data) => {
            const res1 = await getServerInfoAPI(data.projectID, data.cooperationID)
            const res2 = await getAttendanceInfoAPI(data.projectID, data.cooperationID)
            if (res1 && res2) {
                //console.log(res1)
                commit('set_currentServerInfo', res1)
                //console.log(res2)
                commit('set_currentAttendanceInfo', res2)
            }
        },
        setChosenStatus: async ({commit}, data) => {
            const res = await setChosenStatusAPI(data.projectID, data.cooperationID, data.isChosen)
            if (res) {
                console.log(res)

            }
        },
    }
}

export default authority