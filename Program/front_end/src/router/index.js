import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'

Vue.use(VueRouter)
const routes = [
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/home',
    name: 'homePage',
    component: () => import('@/views/home')
  },
  {
    path: '/detail/:projectId',
    name: 'detail',
    component: () => import('@/views/detail')
  },
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('@/views/register')
  },
  {
    path: '/user/info/:userId',
    name: 'userInfo',
    component: () => import('@/views/user/info')
  },

  // 平台管理者相关路由
  {
    path: '/manager',
    name: 'manager',
    redirect: '/manager/accountReview',
    component: () => import('@/views/manager/layout'),
    children: [
      {
        path: 'accountReview',
        name: 'accountReview',
        component: () => import('@/views/manager/accountReview')
      },
      {
        path: 'accountManage',
        name: 'accountManage',
        component: () => import('@/views/manager/accountManager')
      },
      {
        path: 'monitor',
        name: 'monitor',
        component: () => import('@/views/manager/monitor')
      }
    ]
  },

  // 数据提供方相关路由
  {
    path: '/cooperator',
    name: 'cooperator',
    redirect: '/cooperator/home',
    component: () => import('@/views/cooperator/layout'),
    children: [
      {
        path: 'home',
        name: 'cooperatorHome',
        component: ()=> import('@/views/cooperator/home')
      },
      {
        path: 'projectManage/:projectID',
        name: 'projectManage',
        component: ()=> import('@/views/cooperator/manage')
      },
      {
        path: 'signup/:projectID',
        name: 'signup',
        component: ()=> import('@/views/cooperator/signup')
      },
      {
        path: 'config/:projectID',
        name: 'config',
        component: ()=> import('@/views/cooperator/config')
      },
      {
        path: 'user/info/:userId',
        name: 'cooperatorUserInfo',
        component: ()=> import('@/views/user/info')
      },
      {
        path: 'ready/:projectID',
        name: 'ready',
        component: ()=> import('@/views/cooperator/ready')
      }
    ]
  },

  // 银行相关路由
  {
    path: '/bank',
    name: 'bank',
    redirect: '/bank/review',
    component: () => import('@/views/bank/home'),
    children: [
      {
        path: 'review',
        name: 'projectReview',
        component: () => import('@/views/bank/review')
      },
      {
        path: 'lending',
        name: 'lendingHandle',
        component: () => import('@/views/bank/lending')
      },
      {
        path: 'history',
        name: 'lendingHistory',
        component: () => import('@/views/bank/history')
      }
    ]
  },
  {
    path: '/project/:projectId',
    name: 'projectManage',
    redirect: '/project/:projectId/data/dataView',
    component: () => import('@/views/bank/project'),
    children: [
      {
        path: 'authority/manage',
        name: 'authorityManage',
        component: () => import('@/views/bank/authority/authority')
      },
      {
        path: 'data/dataView',
        name: 'dataView',
        component: () => import('@/views/bank/data/data')
      },
      {
        path: 'predict/predict',
        name: 'predict',
        component: () => import('@/views/bank/predict/predict')
      },
      {
        path: 'config/config',
        name: 'projectConfig',
        component: () => import('@/views/bank/config/config')
      }
    ]
  },
  // 借款方路由相关
  {
    path: '/loaner',
    name: 'loaner',
    redirect: '/loaner/request',
    component: () => import('@/views/loaner/layout'),
    children : [
      {
        path: 'request',
        name: 'request',
        component: () => import('@/views/loaner/request')
      },
      {
        path: 'requestManage',
        name: 'requestManage',
        component: () => import('@/views/loaner/requestManage')
      },
      {
        path: 'responseReview',
        name: 'responseReview',
        component: () => import('@/views/loaner/responseReview')
      },

    ]
  }
]
const createRouter = () => new VueRouter({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes
})
const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
