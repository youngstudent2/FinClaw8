import { axios } from '@/utils/request'

const api = {
    modelPre: '/api/model'
}

export function getAllModelsAPI() {
    return axios({
        url:`${api.modelPre}/getAllModels`,
        method: 'GET'
    })
}

