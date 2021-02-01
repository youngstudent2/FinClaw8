import { axios } from '@/utils/request'

const api = {
    dataPre: '/api/data'
}

export function getFileMetadataAPI(params) {
    return axios({
        url: `${api.dataPre}/getFileMetadata/${params.operatorID}`,
        method: 'GET',
        params
    })
}

export function getProjectDataAPI(params) {
    return axios({
        url:`${api.dataPre}/getProjectData/${params.operatorID}`,
        method: 'GET',
        params
    })
}

