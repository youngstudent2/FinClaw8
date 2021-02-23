import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Antd from 'ant-design-vue'
import ElementUI from 'element-ui';
import dataV from '@jiaminghi/data-view'
import 'element-ui/lib/theme-chalk/index.css';
import 'ant-design-vue/dist/antd.css'
import moment from 'moment'
import store from './store'

import '@/permission'
Vue.config.productionTip = false
Vue.prototype.$moment = moment
const options = {
  namespace: 'pro__',
  name: 'ls',
  storage: 'local'
}
Vue.use(Antd)
Vue.use(ElementUI)
Vue.use(dataV)
Vue.directive('title', {
  inserted: function (el, binding) {
    document.title = el.dataset.title
  }
})
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
