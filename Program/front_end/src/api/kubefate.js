import { axios } from '@/utils/request'

const api = {
    kubefatePre: '/api/kubefate'
}

export function deployAPI(data) {
    return axios({
        url:`${api.kubefatePre}/deploy/${data}`,
        method: 'POST',
    })
}

export function uploadAPI(data) {
    return axios({
        url:`${api.kubefatePre}/upload/${data}`,
        method: 'POST',
    })
}

export function submitAPI(data) {
    return axios({
        url:`${api.kubefatePre}/submit/${data}`,
        method: 'POST',
    })
}

export function queryAPI(data) {
    return axios({
        url:`${api.kubefatePre}/query/${data}`,
        method: 'POST',
    })
}

export function loadBindAPI(data) {
    return axios({
        url:`${api.kubefatePre}/loadBind/${data}`,
        method: 'POST',
    })
}

export function predictAPI() {
    return axios({
        url:`${api.kubefatePre}/predict`,
        method: 'GET',
    })
}
