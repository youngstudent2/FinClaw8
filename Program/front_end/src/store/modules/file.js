import Vue from 'vue'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { message } from 'ant-design-vue'

import {
    uploadAPI,
    downloadAPI,
    viewAllFileAPI,
    getFileMetadataAPI
} from '@/api/file'

const file = {
    state: {
        uploadedFileList: [],
        uploadState: false,
        downloadState: false,
        metadataVisible: false,
        metadata: []
    },

    mutations: {
        set_uploadedFileList: function(state, data) {
            state.uploadedFileList = data
        },
        set_uploadState: function(state, data) {
            state.uploadState = data
        },
        set_downloadState: function(state, data) {
            state.downloadState = data
        },
        set_metadataVisible: function(state, data) {
            state.metadataVisible = data
        },
        set_metadata: function(state, data) {
            state.metadata = data
        },
    },

    actions: {
        uploadFile: async ({ dispatch, commit }, data) => {
            commit('set_uploadState', true)
            const res = await uploadAPI(data)
            if (res) {
                var temp = {
                    operatorID: data.get("operatorID"),
                    projectID: data.get("projectID")
                }
                dispatch("getAllFiles", temp)
                message.success("文件上传成功")
            } else {
                message.error("文件上传失败")
            }
            commit('set_uploadState', false)
        },
        downloadFile: async ({ dispatch, commit }, data) => {
            commit('set_downloadState', true)
            const res = await downloadAPI(data)
            if (res != null) {
                message.success("文件下载成功")
            } else {
                message.error("文件下载失败")
            }
            commit('set_downloadState', false)
        },
        getAllFiles: async ({ commit, state }, data) => {
            const res = await viewAllFileAPI(data)
            if (res) {
                commit('set_uploadedFileList', res)
            }
        },
        getMetadata: async ({ commit }, data) => {
            const res = await getFileMetadataAPI(data)
            if (res) {
                commit('set_metadata', res)
            } else {
                commit('set_metadata', null)
                message.error("查看失败")
            }
        },
    }
}

export default file