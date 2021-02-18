import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import file from './modules/file'
import model from './modules/model'
import monitor from "./modules/monitor"
import data from "./modules/data"
import authority from  "./modules/authority"
import cooperation from "./modules/cooperation";
import predict from "./modules/predict";
import project from "./modules/project";
import train from "./modules/train";
import loaner from "./modules/loaner"
import lender from "./modules/lender"

import getters from './getters'
Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    user,
    file,
    model,
    monitor,
    data,
    authority,
    cooperation,
    predict,
    project,
    loaner,
    lender,
    //测试用的train
    train,
  },
  state: {
  },
  mutations: {
  },
  actions: {
  },
  getters
})
