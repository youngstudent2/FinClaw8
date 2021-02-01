import router from './router'
import store from './store'
import { getToken } from '@/utils/auth'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
const whiteList = ['/login', '/home', '/navigator', '/NJUFINCLAW'] // no redirect whitelist
router.beforeEach(async(to, from, next) => {
    // start progress bar
    NProgress.start()
    // determine whether the user has logged in
    const hasToken = getToken()
    // if (hasToken) {
    //     store.commit('set_userId', hasToken)
    //   if (to.path === '/login') {
    //     // if is logged in, redirect to the home page
    //     // next({path: '/'})
    //     // NProgress.done()
    //     next()
    //   } else {
    //     next()
    //     NProgress.done()
    //   }
    // } else {
    //   /* has no token*/
    //   // alert('notoken')
    //   console.log(to.path)
    //   if (whiteList.indexOf(to.path) !== -1) {
    //     // in the free login whitelist, go directly
    //     next()
    //   } else {
    //     // other pages that do not have permission to access are redirected to the login page.
    //     next(`/login?redirect=${to.path}`)
    //     NProgress.done()
    //   }
    // }
    // 去除掉很多安全机制，方便开发
    next()
  })
  
  router.afterEach(() => {
    // finish progress bar
    NProgress.done()
  })
  