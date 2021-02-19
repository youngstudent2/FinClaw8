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
        url:`${api.projectPre}/deleteProject/${data}`,
        method: 'POST',
    })
}

export function modifyProjectAPI(data) {
    return axios({
        url:`${api.projectPre}/modifyProject/${data.projectID}`,
        method: 'POST',
        data: data.projectData
    })
}

export function getProjectInfoAPI(params) {
    return axios({
        url:`${api.projectPre}/getProjectInfo/${params.projectID}`,
        method: 'GET',
        params
    })
}

export function getAllProjectInfoAPI() {
    return axios({
        url:`${api.projectPre}/getAllProjectInfo`,
        method: 'GET',
    })
}

export function getAllBankProjectInfoAPI(data) {
    return axios({
        url:`${api.projectPre}/getAllBankProjectInfo/${data}`,
        method: 'GET',
    })
}