import Vue from 'vue'
import router from '@/router'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { message } from 'ant-design-vue'

import {
    loginAPI,
    getUserInfoAPI,
    getAllUserInfoAPI,
    updateUserInfoAPI,
    registerDataManagerAPI,
    registerCooperationAPI,
    getAllDataManagersAPI,
    deleteUserAPI
} from '@/api/account'

const getDefaultState = () => {
    return {
        userId: '',
        userInfo: {},
        AllUsers:[],
        DataManagerRegistrationModalVisible: false ,
    }
};

const user = {
    state : getDefaultState(),

    mutations: {
        reset_state: function(state) {
            state.token = '';
            state.userId = '';
            state.userInfo = {
                
            }
        },
        set_token: function(state, token){
            state.token = token
        },
        set_userId: (state, data) => {
            state.userId = data
        },
        set_userInfo: (state, data) => {
            state.userInfo = {
                ...state.userInfo,
                ...data
            }
        },
        set_AllUsers: function(state, data) {
            state.AllUsers = data;
        },
        set_DataManagerRegistrationModalVisible: function(state,data) {
            state.DataManagerRegistrationModalVisible = data
        },
    },

    actions: {
        login: async ({ dispatch, commit }, userData) => {
            const res = await loginAPI(userData)
            if(res){
                setToken(res.userID)
                commit('set_userId', res.userID)
                dispatch('getUserInfo')
                if(res.role == "Cooperation"){
                    router.push('/cooperator')
                }
                else if (res.role == "Bank"){
                    router.push('/bank')
                }
                else if (res.role == 'loaner'){
                    router.push('/loaner')
                }
                else if (res.role == 'Admin') {
                    router.push('/manager')
                }
                else if(res.role == "Bank") {
                    router.push('/bank')
                }
                else {
                    router.push('/')
                }
            }
        },
        registerDataManager: async({ commit, dispatch }, data) => {
            const res = await registerDataManagerAPI(data)
            if(typeof(res) != "undefined"){
                commit('set_DataManagerRegistrationModalVisible',false)
                message.success('注册成功')
                dispatch('getAllDataManagers')
            }
            // else
        },
        getAllDataManagers: async({ commit }) => {
            const res = await getAllDataManagersAPI()
            if(res){
                commit('set_AllDataManagers',res)
            }
        },
        registerCooperation: async({ commit }, data) => {
            const res = await registerCooperationAPI(data)
            if(typeof(res) != undefined){
                message.success('注册成功')
            }
        },
        getUserInfo({ state, commit }) {
            return new Promise((resolve, reject) => {
              getUserInfoAPI(state.userId).then(response => {
                const data = response
                if (!data) {
                  reject('登录已过期，请重新登录')
                }
                commit('set_userInfo', data)
                commit('set_userId', data.userID)
                resolve(data)
              }).catch(error => {
                reject(error)
              })
            })
        },
        getAllUserInfo: async({ state, commit }) => {
            const res = await getAllUserInfoAPI();
            if(res){
                commit('set_AllUsers', res);
            }
        },
        updateUserInfo: async({ state, dispatch }, data) => {
            const params = {
                id: state.userId,
                ...data,
            }
            const res = await updateUserInfoAPI(params)
            if(res){
                await message.success('修改成功')
                dispatch('getUserInfo')
            }
        },
        deleteUser: async({dispatch},userID) => {
            const res = await deleteUserAPI(userID)
            if(res){
                dispatch('getAllDataManagers')
                message.success('删除成功')
            }
            // else{
            //     message.error('删除失败')
            // }
        },
        logout: async({ commit }) => {
            removeToken()
            resetRouter()
            commit('reset_state')
        },
          // remove token
        resetToken({ commit }) {
            return new Promise(resolve => {
                removeToken() // must remove  token  first
                commit('reset_state')
                resolve()
            })
        },
    }
}

export default user