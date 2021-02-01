import { axios } from '@/utils/request'

const api = {
    trainPre: '/api/train'
}

export function startTrainAPI(data) {
    return axios({
        url:`${api.trainPre}/startTrain/${data}`,
        method: 'POST',
    })
}

