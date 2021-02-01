import Vue from 'vue'
import { message } from 'ant-design-vue'

import {
    addProjectAPI,
    deleteProjectAPI,
    modifyProjectAPI,
    getProjectInfoAPI,
    getAllProjectAPI,
} from '@/api/project'

const getDefaultState = () => {
    return {
        currentProjectID: null,
        currentProjectInfo: {},
        projectList: [],
        addProjectModalVisible: false,
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
    },

    actions: {
        getAllProject : async ({ commit }) => {
            const res = await getAllProjectAPI()
            if (res) {
                commit('set_projectList', res)
            }
        },
        getProjectInfo : async ({ commit }, data) => {
            const res = await getProjectInfoAPI(data)
            if (res) {
                commit('set_currentProjectInfo', res)
            }
        },
        addProject : async ({ commit, dispatch }, data) => {
            const res = await addProjectAPI(data)
            if (res) {
                message.success("项目添加成功")
                dispatch('getAllProject')
            }
        }
    }
}

export default project