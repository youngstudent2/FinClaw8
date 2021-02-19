import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    addProjectAPI,
    deleteProjectAPI,
    modifyProjectAPI,
    getProjectInfoAPI,
    getAllProjectInfoAPI,
    getAllBankProjectInfoAPI
} from '@/api/project'
import {getToken} from "@/utils/auth";

const getDefaultState = () => {
    return {
        currentProjectID: null,
        currentProjectInfo: {},
        projectList: [],
        addProjectModalVisible: false,
        modifyProjectModalVisible: false,
        bankProjectList: []
    }
}
const project = {
    state: getDefaultState(),

    mutations: {
        reset_state: function(state) {
            state.currentProjectID = null,
            state.currentProjectInfo = {},
            state.projectList = []
        },
        set_currentProject: (state, project) => {
            state.currentProjectID = project.projectID
            state.currentProjectInfo = project
        },
        set_projectList: (state, data) => {
            state.projectList = data
        },
        set_addProjectModalVisible: (state, data) => {
            state.addProjectModalVisible = data
        },
        set_modifyProjectModalVisible: (state, data) => {
            state.modifyProjectModalVisible = data
        },
        set_bankProjectList: (state, data) => {
            state.bankProjectList = data
        },
    },

    actions: {
        getAllProject : async ({ commit }) => {
            const res = await getAllProjectInfoAPI()
            if (res) {
                commit('set_projectList', res)
            }
        },
        getBankProject : async ({ commit }, data) => {
            const res = await getAllBankProjectInfoAPI(data)
            if (res) {
                console.log(res)
                commit('set_bankProjectList', res)
            }
        },
        getProjectInfo : async ({ commit }, data) => {
            const res = await getProjectInfoAPI(data)
            if (res) {
                commit('set_currentProjectInfo', res)
            }
        },
        addProject : async ({ state, dispatch }, data) => {
            const res = await addProjectAPI(data)
            dispatch('getBankProject', getToken())
        },
        modifyProject : async ({ state, dispatch }, data) => {
            const res = await modifyProjectAPI(data)
            dispatch('getBankProject', getToken())
        },
        deleteProject : async ({ state, dispatch }, data) => {
            const res = await deleteProjectAPI(data)
            dispatch('getBankProject', getToken())
        }
    }
}

export default project