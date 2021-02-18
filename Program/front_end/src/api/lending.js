import { axios } from '@/utils/request'

const api = {
    lendingPre: '/api/lending'
}

export function getBankLendingHistoryAPI(BankID){
    return axios({
        url:`${api.lendingPre}/getBankLendingHistory/${BankID}`,
        method: 'GET',
    })
}

export function addLendingFormAPI(data){
    return axios({
        url:`${api.lendingPre}/addLendingForm`,
        method: 'POST',
        data
    })
}