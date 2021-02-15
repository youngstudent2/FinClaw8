import { axios } from '@/utils/request'

const api = {
    accountPre: '/api/account'
}

export function loginAPI(data){
    return axios({
        url:`${api.accountPre}/login`,
        method: 'POST',
        data
    })
}

export function getUserInfoAPI(userID){
    console.log(userID)
    return axios({
        url: `${api.accountPre}/${userID}/getUserInfo`,
        method: 'GET'
    })
}

export function getAllUserInfoAPI() {
    return axios({
        url: `${api.accountPre}/getAllUsers`,
        method: 'GET',
    })
}

export function getUnauthorizedUsersAPI() {
    return axios({
        url: `${api.accountPre}/getUnauthorizedUsers`,
        method: `GET`,
    })
}

export function updateUserInfoAPI(data) {
    return axios({
        url: `${api.accountPre}/${data.userID}/updateUserInfo`,
        method: 'POST',
        data
    })
}

export function updatePasswordAPI(params) {
    return axios({
        url: `${api.accountPre}/${params.userID}/updatePassword`,
        method: 'POST',
        params
    })
}


export function registerDataManagerAPI(data){
    return axios({
        url: `${api.accountPre}/registerDataManager`,
        method: 'POST',
        data
    })
}

export function registerCooperationAPI(data){
    return axios({
        url: `${api.accountPre}/registerCooperation`,
        method:'POST',
        data
    })
}

export function deleteUserAPI(params) {
    return axios({
        url: `${api.accountPre}/${params}/deleteUser`,
        method: 'POST',
        params
    })
}

export function reviewUserAPI(userID){
    return axios({
        url: `${api.accountPre}/${userID}/reviewUser`,
        method: `POST`,
        userID
    })
}

export function getAllDataManagersAPI(){
    return axios({
        url: `${api.accountPre}/getAllDataManagers`,
        method: 'GET'
    })
}

