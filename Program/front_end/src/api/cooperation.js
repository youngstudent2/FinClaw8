import { axios } from '@/utils/request'

const api = {
    cooperation: '/api/attendance'
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

export function getProjectCooperationAPI(projectID){
    return axios({
        url:`${api.cooperation}/getProjectCooperation/${projectID}`,
        method: 'GET',
    })
}

export function getServerInfoAPI(projectID, cooperationID) {
    return axios({
        url:`${api.cooperation}/getServerInfo/${projectID}/${cooperationID}`,
        method: 'GET',
    })
}

export function setChosenStatusAPI(projectID, cooperationID, isChosen) {
    return axios({
        url:`${api.cooperation}/setChosenStatus/${projectID}/${cooperationID}`,
        method: 'POST',
        isChosen,
    })
}