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

export function getAllLoanApplicationAPI() {
    return axios({
        url: `${api.loanPre}/getAllLoanApplication`,
        method: 'GET'
    })
}

export function getLoanApplicationAPI(loanApplicationID) {
    return axios({
        url: `${api.loanPre}/getLoanApplication/${loanApplicationID}`,
        method: 'GET'
    })
}

export function setLoanApplicationDealtAPI(loanApplicationID) {
    return axios({
        url: `${api.loanPre}/setDealt/${loanApplicationID}`,
        method: 'POST'
    })
}

// 获取所有的借款申请记录
export function getUserLoanApplicationAPI(userID) {
    return axios({
        url: `${api.loanPre}/getUserLoanApplication/${userID}`,
        method: 'GET'
    })
}

// 获取所有已完成的借款记录
export function getUserLoanHistoryAPI(userID) {
    return axios({
        url: `${api.loanPre}/getUserLoanHistory/${userID}`,
        method: 'GET'
    })
}