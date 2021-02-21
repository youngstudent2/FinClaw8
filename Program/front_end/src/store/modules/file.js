import Vue from 'vue'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { message } from 'ant-design-vue'

import {
    uploadAPI,
    downloadAPI,
    getUserFilesAPI,
} from '@/api/file'


const file = {
    state: {
        uploadedFileList: [],
        uploadState: false,
        downloadState: false,
        metadataVisible: false,
        metadata: [],
        userFiles: [],
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
        set_userFiles: function (state, data) {
            state.userFiles = data;
        }
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
        downloadFile: async ({ dispatch, commit }, fileID) => {
            commit('set_downloadState', true);
            const res = await downloadAPI(fileID);
            console.log(res)
            if (res != null) {
                message.success("文件下载成功")
            } else {
                message.error("文件下载失败")
            }
            commit('set_downloadState', false)
        },
        getUserFiles: async ({commit}, userID) => {
            console.log(userID);
            const res = await getUserFilesAPI(userID);
            console.log(res);
            if(res){
                commit('set_userFiles', res);
            }
            else{
                message.error("获取文件列表失败");
            }
        }
    }
}

export default file