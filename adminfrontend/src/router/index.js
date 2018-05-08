import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const manage = r => require.ensure([], () => r(require('@/page/manage')), 'manage');
const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
const addShop = r => require.ensure([], () => r(require('@/page/addShop')), 'addShop');
const addGoods = r => require.ensure([], () => r(require('@/page/addGoods')), 'addGoods');
const userList = r => require.ensure([], () => r(require('@/page/userList')), 'userList');
const shopList = r => require.ensure([], () => r(require('@/page/shopList')), 'shopList');
const foodList = r => require.ensure([], () => r(require('@/page/foodList')), 'foodList');
const orderList = r => require.ensure([], () => r(require('@/page/orderList')), 'orderList');
const adminList = r => require.ensure([], () => r(require('@/page/adminList')), 'adminList');
const visitor = r => require.ensure([], () => r(require('@/page/visitor')), 'visitor');
const newMember = r => require.ensure([], () => r(require('@/page/newMember')), 'newMember');
const uploadImg = r => require.ensure([], () => r(require('@/page/uploadImg')), 'uploadImg');
const vueEdit = r => require.ensure([], () => r(require('@/page/vueEdit')), 'vueEdit');
const adminSet = r => require.ensure([], () => r(require('@/page/adminSet')), 'adminSet');
const sendMessage = r => require.ensure([], () => r(require('@/page/sendMessage')), 'sendMessage');
const explain = r => require.ensure([], () => r(require('@/page/explain')), 'explain');

const adminMod = r => require.ensure([], () => r(require('@/page/adminMod')), 'adminMod');
const adminAdd = r => require.ensure([], () => r(require('@/page/adminAdd')), 'adminAdd');
const adminDelete = r => require.ensure([], () => r(require('@/page/adminDelete')), 'adminDelete');

const roleList = r => require.ensure([], () => r(require('@/page/roleList')), 'roleList');
const roleAdd = r => require.ensure([], () => r(require('@/page/roleAdd')), 'roleAdd');
const roleDelete = r => require.ensure([], () => r(require('@/page/roleDelete')), 'roleDelete');
const roleMod = r => require.ensure([], () => r(require('@/page/roleMod')), 'roleMod');

const permissionList = r => require.ensure([], () => r(require('@/page/permissionList')), 'permissionList');

// const userList = r => require.ensure([], () => r(require('@/page/userList')), 'userList');
const userMod = r => require.ensure([], () => r(require('@/page/userMod')), 'userMod');
const userAdd = r => require.ensure([], () => r(require('@/page/userAdd')), 'userAdd');
const userDelete = r => require.ensure([], () => r(require('@/page/userDelete')), 'userDelete');

const commentList = r => require.ensure([], () => r(require('@/page/commentList')), 'commentList');
const commentDelete = r => require.ensure([], () => r(require('@/page/commentDelete')), 'commentDelete');

const complaintList = r => require.ensure([], () => r(require('@/page/complaintList')), 'complaintList');
const complaintMod = r => require.ensure([], () => r(require('@/page/complaintMod')), 'complaintMod');

const logrecordList = r => require.ensure([], () => r(require('@/page/logrecordList')), 'logrecordList');

const paymentList = r => require.ensure([], () => r(require('@/page/paymentList')), 'paymentList');
const paymentAdd = r => require.ensure([], () => r(require('@/page/paymentAdd')), 'paymentAdd');

const postList = r => require.ensure([], () => r(require('@/page/postList')), 'postList');
const postDelete = r => require.ensure([], () => r(require('@/page/postDelete')), 'postDelete');

const sectionList = r => require.ensure([], () => r(require('@/page/sectionList')), 'sectionList');
const sectionMod = r => require.ensure([], () => r(require('@/page/sectionMod')), 'sectionMod');
const sectionAdd = r => require.ensure([], () => r(require('@/page/sectionAdd')), 'sectionAdd');
const sectionDelete = r => require.ensure([], () => r(require('@/page/sectionDelete')), 'sectionDelete');

const swList = r => require.ensure([], () => r(require('@/page/swList')), 'swList');
const swAdd = r => require.ensure([], () => r(require('@/page/swAdd')), 'swAdd');
const swDelete = r => require.ensure([], () => r(require('@/page/swDelete')), 'swDelete');

const routes = [
	{
		path: '/',
		component: login
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
			path: '/adminList',
			component: adminList,
			meta: ['管理员管理','查看管理员'],
		},{
			path: '/adminMod',
			component: adminMod,
			meta: ['管理员管理','修改管理员'],
		},{
			path: '/adminAdd',
			component: adminAdd,
			meta: ['管理员管理','添加管理员'],
		},{
			path: '/adminDelete',
			component: adminDelete,
			meta: ['管理员管理','删除管理员'],
		},{
			path: '/roleList',
			component: roleList,
			meta: ['角色管理','查看角色'],
		},{
			path: '/roleAdd',
			component: roleAdd,
			meta: ['角色管理','添加角色'],
		},{
			path: '/roleDelete',
			component: roleDelete,
			meta: ['角色管理','删除角色'],
		},{
			path: '/roleMod',
			component: roleMod,
			meta: ['角色管理','角色权限管理'],
		},{
			path: '/permissionList',
			component: permissionList,
			meta: ['权限管理','查看权限'],
		},{
			path: '/userList',
			component: userList,
			meta: ['用户管理','查看用户'],
		},{
			path: '/userMod',
			component: userMod,
			meta: ['用户管理','修改用户'],
		},{
			path: '/userAdd',
			component: userAdd,
			meta: ['用户管理','新增用户'],
		},{
			path: '/userDelete',
			component: userDelete,
			meta: ['用户管理','删除用户'],
		},{
			path: '/commentList',
			component: commentList,
			meta: ['评论管理','查看评论'],
		},{
			path: '/commentDelete',
			component: commentDelete,
			meta: ['评论管理','删除评论'],
		},{
			path: '/complaintList',
			component: complaintList,
			meta: ['举报管理','查看举报'],
		},{
			path: '/complaintMod',
			component: complaintMod,
			meta: ['举报管理','处理举报'],
		},{
			path: '/logrecordList',
			component: logrecordList,
			meta: ['日志管理','查看日志'],
		},{
			path: '/paymentList',
			component: paymentList,
			meta: ['订单管理','查看订单'],
		},{
			path: '/paymentAdd',
			component: paymentAdd,
			meta: ['订单管理','新增订单'],
		},{
			path: '/postList',
			component: postList,
			meta: ['作品管理','查看作品'],
		},{
			path: '/postDelete',
			component: postDelete,
			meta: ['作品管理','删除作品'],
		},{
			path: '/sectionList',
			component: sectionList,
			meta: ['版区管理','查看版区'],
		},{
			path: '/sectionMod',
			component: sectionMod,
			meta: ['版区管理','更新版区'],
		},{
			path: '/sectionAdd',
			component: sectionAdd,
			meta: ['版区管理','新增版区'],
		},{
			path: '/sectionDelete',
			component: sectionDelete,
			meta: ['版区管理','删除版区'],
		},{
			path: '/swList',
			component: swList,
			meta: ['敏感词管理','查看敏感词'],
		},{
			path: '/swAdd',
			component: swAdd,
			meta: ['敏感词管理','新增敏感词'],
		},{
			path: '/swDelete',
			component: swDelete,
			meta: ['敏感词管理','删除敏感词'],
		}
		// {
		// 	path: '/addShop',
		// 	component: addShop,
		// 	meta: ['添加数据', '添加商铺'],
		// },{
		// 	path: '/addGoods',
		// 	component: addGoods,
		// 	meta: ['添加数据', '添加商品'],
		// },{
		// 	path: '/userList',
		// 	component: userList,
		// 	meta: ['数据管理', '用户列表'],
		// },{
		// 	path: '/shopList',
		// 	component: shopList,
		// 	meta: ['数据管理', '商家列表'],
		// },{
		// 	path: '/foodList',
		// 	component: foodList,
		// 	meta: ['数据管理', '食品列表'],
		// },{
		// 	path: '/orderList',
		// 	component: orderList,
		// 	meta: ['数据管理', '订单列表'],
		// },{
		// 	path: '/adminList',
		// 	component: adminList,
		// 	meta: ['数据管理', '管理员列表'],
		// },{
		// 	path: '/visitor',
		// 	component: visitor,
		// 	meta: ['图表', '用户分布'],
		// },{
		// 	path: '/newMember',
		// 	component: newMember,
		// 	meta: ['图表', '用户数据'],
		// },{
		// 	path: '/uploadImg',
		// 	component: uploadImg,
		// 	meta: ['文本编辑', 'MarkDown'],
		// },{
		// 	path: '/vueEdit',
		// 	component: vueEdit,
		// 	meta: ['编辑', '文本编辑'],
		// },{
		// 	path: '/adminSet',
		// 	component: adminSet,
		// 	meta: ['设置', '管理员设置'],
		// },{
		// 	path: '/sendMessage',
		// 	component: sendMessage,
		// 	meta: ['设置', '发送通知'],
		// },{
		// 	path: '/explain',
		// 	component: explain,
		// 	meta: ['说明', '说明'],
		// }
		]
	}
]

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})
