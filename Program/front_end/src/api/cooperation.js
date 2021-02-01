import { axios } from '@/utils/request'

const api = {
    cooperation: '/api/cooperation'
}

export function attendProjectAPI(params) {
    return axios({
        url:`${api.cooperation}/attendProject/${params.projectID}`,
        method: 'POST',
        params
    })
}

export function quitProjectAPI(params) {
    return axios({
        url:`${api.cooperation}/quitProject/${params.projectID}`,
        method: 'POST',
        params
    })
}

export function uploadServiceInfoAPI(data) {
    return axios({
        url:`${api.cooperation}/uploadServiceInfo`,
        method: 'POST',
        data
    })
}

export function setReadyAPI(params) {
    return axios({
        url:`${api.cooperation}/setReady`,
        method: 'POST',
        params
    })
}

export function getAllAttendedProjectsAPI(params) {
    return axios({
        url:`${api.cooperation}/getAllAttendedProjects/${params.cooperationID}`,
        method: 'GET',
        params
    })
}

export function getAllUnattendedProjectsAPI(params) {
    return axios({
        url:`${api.cooperation}/getAllUnAttendedProjects/${params.cooperationID}`,
        method: 'GET',
        params
    })
}