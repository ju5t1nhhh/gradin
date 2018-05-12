import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const explore = r => require.ensure([], () => r(require('@/page/explore')), 'explore');
const home = r => require.ensure([], () => r(require('@/page/home')), 'home');

const routes = [
	{
		path: '/',
		component: home
	},
	{
		path: '/login',
		component: login,
	},
	{
		path: '/explore',
		component: explore
	},
]

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})
