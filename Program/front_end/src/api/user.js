import { axios } from '@/utils/request'

const api = {
    userPre: '/api/user'
}

export function loginAPI(data){
    return axios({
        url:`${api.userPre}/login`,
        method: 'POST',
        data
    })
}
export function registerDataManagerAPI(data){
    return axios({
        url: `${api.userPre}/registerDataManager`,
        method: 'POST',
        data
    })
}
export function registerCooperationAPI(data){
    return axios({
        url: `${api.userPre}/registerCooperation`,
        method:'POST',
        data
    })
}
export function getUserInfoAPI(id){
    return axios({
        url: `${api.userPre}/${id}/getUserInfo`,
        method: 'GET'
    })
}
export function updateUserInfoAPI(data) {
    return axios({
        url: `${api.userPre}/${data.id}/userInfo/update`,
        method: 'POST',
        data
    })
}
