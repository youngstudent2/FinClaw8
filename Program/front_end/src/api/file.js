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

export function downloadAPI(fileID) {
    return axios({
        url: `${api.filePre}/download/${fileID}`,
        method: 'POST',
        responseType: 'blob'
    })
}

export function getUserFilesAPI(userID) {
    return axios({
        url: `${api.filePre}/getUserFiles/${userID}`,
        method: 'GET',
    })
}
