import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const manage = r => require.ensure([], () => r(require('@/page/manage')), 'manage');
const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
// const adminList = r => require.ensure([], () => r(require('@/page/adminList')), 'adminList');

// const adminMod = r => require.ensure([], () => r(require('@/page/adminMod')), 'adminMod');
// const adminAdd = r => require.ensure([], () => r(require('@/page/adminAdd')), 'adminAdd');
// const adminDelete = r => require.ensure([], () => r(require('@/page/adminDelete')), 'adminDelete');

// const roleList = r => require.ensure([], () => r(require('@/page/roleList')), 'roleList');
// const roleAdd = r => require.ensure([], () => r(require('@/page/roleAdd')), 'roleAdd');
// const roleDelete = r => require.ensure([], () => r(require('@/page/roleDelete')), 'roleDelete');
// const roleMod = r => require.ensure([], () => r(require('@/page/roleMod')), 'roleMod');

// const permissionList = r => require.ensure([], () => r(require('@/page/permissionList')), 'permissionList');

// const userList = r => require.ensure([], () => r(require('@/page/userList')), 'userList');
// const userMod = r => require.ensure([], () => r(require('@/page/userMod')), 'userMod');
// const userAdd = r => require.ensure([], () => r(require('@/page/userAdd')), 'userAdd');
// const userDelete = r => require.ensure([], () => r(require('@/page/userDelete')), 'userDelete');

// const commentList = r => require.ensure([], () => r(require('@/page/commentList')), 'commentList');
// const commentDelete = r => require.ensure([], () => r(require('@/page/commentDelete')), 'commentDelete');

// const complaintList = r => require.ensure([], () => r(require('@/page/complaintList')), 'complaintList');
// const complaintMod = r => require.ensure([], () => r(require('@/page/complaintMod')), 'complaintMod');

// const paymentList = r => require.ensure([], () => r(require('@/page/paymentList')), 'paymentList');
// const paymentAdd = r => require.ensure([], () => r(require('@/page/paymentAdd')), 'paymentAdd');

// const postList = r => require.ensure([], () => r(require('@/page/postList')), 'postList');
// const postDelete = r => require.ensure([], () => r(require('@/page/postDelete')), 'postDelete');

// const sectionList = r => require.ensure([], () => r(require('@/page/sectionList')), 'sectionList');
// const sectionMod = r => require.ensure([], () => r(require('@/page/sectionMod')), 'sectionMod');
// const sectionAdd = r => require.ensure([], () => r(require('@/page/sectionAdd')), 'sectionAdd');
// const sectionDelete = r => require.ensure([], () => r(require('@/page/sectionDelete')), 'sectionDelete');

// const swList = r => require.ensure([], () => r(require('@/page/swList')), 'swList');
// const swAdd = r => require.ensure([], () => r(require('@/page/swAdd')), 'swAdd');
// const swDelete = r => require.ensure([], () => r(require('@/page/swDelete')), 'swDelete');

const register = r => require.ensure([], () => r(require('@/page/register')), 'register');

const routes = [
	{
		path: '/',
		component: register
	},
	{
		path: '/manage',
		component: manage,
		name: '',
		children: [{
			path: '',
			component: home,
			meta: [],
		},{
			path: '/register',
			component: register,
			meta: [],
		},{
			path: '/login',
			component: login,
			meta: [],
		}
		]
	}
]

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})
