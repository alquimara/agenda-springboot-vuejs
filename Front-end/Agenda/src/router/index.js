import Vue from 'vue'
import Router from 'vue-router'
import contatos from '@/components/contatos'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'contatos',
      component: contatos
    },
  ]
})
