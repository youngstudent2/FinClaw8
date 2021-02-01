import { axios } from '@/utils/request'

const api = {
    predictPre: '/api/predict'
}


export function predictAPI(data){
    return axios({
        url: `${api.predictPre}/predictCredit/`,
        method: 'POST',
        data
    })
}



