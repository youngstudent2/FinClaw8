import { axios } from '@/utils/request'

const api = {
    monitorPre: '/api/monitor'
}

export function getProjectMonitorInfoAPI(params) {
    return axios({
        url:`${api.monitorPre}/getProjectMonitorInfo`,
        method: 'GET',
        params
    })
}


