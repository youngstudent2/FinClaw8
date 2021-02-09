import { axios } from '@/utils/request'

const api = {
    projectPre: '/api/project'
}

export function addProjectAPI(data) {
    return axios({
        url:`${api.projectPre}/addProject`,
        method: 'POST',
        data
    })
}

export function deleteProjectAPI(data) {
    return axios({
        url:`${api.projectPre}/deleteProject`,
        method: 'POST',
        data
    })
}

export function modifyProjectAPI(data) {
    return axios({
        url:`${api.projectPre}/modifyProject`,
        method: 'POST',
        data
    })
}

export function getProjectInfoAPI(params) {
    return axios({
        url:`${api.projectPre}/getProjectInfo/${params.projectID}`,
        method: 'GET',
        params
    })
}

export function getAllProjectAPI() {
    return axios({
        url:`${api.projectPre}/getAllProjectInfo`,
        method: 'GET',
    })
}
