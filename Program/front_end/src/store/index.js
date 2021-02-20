import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import file from './modules/file'
import monitor from "./modules/monitor"
import authority from  "./modules/authority"
import cooperation from "./modules/cooperation";
import project from "./modules/project";
import loaner from "./modules/loaner"
import lender from "./modules/lender"
import kubefate from "./modules/kubefate"

import getters from './getters'
Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    user,
    file,
    monitor,
    authority,
    cooperation,
    project,
    loaner,
    lender,
    kubefate
  },
  state: {
  },
  mutations: {
  },
  actions: {
  },
  getters
})
