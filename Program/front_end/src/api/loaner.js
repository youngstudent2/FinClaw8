import { axios } from '@/utils/request'

const api = {
    loanPre: '/api/loan'
}


export function addLoanApplicationAPI(data){
    return axios({
        url:`${api.loanPre}/addLoanApplication`,
        method: 'POST',
        data
    })
}

export function deleteLoanApplicationAPI(loanApplicationID) {
    return axios({
        url: `${api.loanPre}/deleteLoanApplication/${loanApplicationID}`,
        method: 'POST'
    })
}

export function getAllLoanApplicationAPI(userID) {
    return axios({
        url: `${api.loanPre}/getAllLoanApplication/${userID}`,
        method: 'GET'
    })
}

export function getLoanApplicationAPI(loanApplicationID) {
    return axios({
        url: `${api.loanPre}/getLoanApplication/${loanApplicationID}`,
        method: 'GET'
    })
}

export function setDealtAPI(loanApplicationID) {
    return axios({
        url: `${api.loanPre}/setDealt/${loanApplicationID}`,
        method: 'POST'
    })
}

export function getUserLoanHistoryAPI(userID) {
    return axios({
        url: `${api.loanPre}/getUserLoanHistory/${userID}`,
        method: 'GET'
    })
}