import { axios } from '@/utils/request'

const api = {
    filePre: '/api/file'
}

export function uploadAPI(params) {
    return axios({
        url:`${api.filePre}/upload/${params.get('operatorID')}`,
        method: 'POST',
        enctype: "multipart/form-data",
        data: params
    })
}

export function downloadAPI(params) {
    return axios({
        url: `${api.filePre}/download/${params.operatorID}`,
        method: 'GET',
        params
    })
}

export function viewAllFileAPI(params) {
    return axios({
        url: `${api.filePre}/viewAllFile/${params.operatorID}`,
        method: 'GET',
        params
    })
}
