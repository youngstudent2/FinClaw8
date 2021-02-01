import { axios } from '@/utils/request'

const api = {
    authorityPre: '/api/authority'
}

export function closeAuthorityAPI(params) {
    console.log(params)
    return axios({
        url:`${api.authorityPre}/closeAuthority/${params.userId}`,
        method: 'POST',
        params,
    })
}

export function openAuthorityAPI(params) {
    return axios({
        url:`${api.authorityPre}/openAuthority/${params.userId}`,
        method: 'POST',
        params,
    })
}

export function getAuthorityAPI(projectID,cooperationID) {
    return axios({
        url:`${api.authorityPre}/getAuthority`,
        method: 'GET',
        data: {
            projectID: projectID,
            cooperationID: cooperationID,
        },
    })
}
