import { axios } from '@/utils/request'

const api = {
    monitorPre: '/api/monitor'
}

export function getAllOperationAPI() {
    return axios({
        url:`${api.monitorPre}/getAllOperation`,
        method: 'GET',
    })
}

export function getProjectOperationAPI(projectID){
    return axios({
        url:`${api.monitorPre}/getProjectOperation`,
        method: 'GET',
        projectID,
    })
}

export function getUserOperationAPI(userID) {
    return axios({
        url:`${api.monitorPre}/getUserOperation`,
        method: 'GET',
        userID,
    })
}


