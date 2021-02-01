//用于测试

import {startTrainAPI} from '@/api/train';

const train = {
    state:{},
    mutations:{},
    actions:{
        submit: async({commit},data) =>{
            console.log("in submit")
            console.log(data)
            const res = await startTrainAPI(data)
            console.log("after submit")
            console.log(res)
        }
    }
}

export default train