import Vue from 'vue'
import Vuex from 'vuex'
import {getAdminInfo} from '@/api/getData'

Vue.use(Vuex)

const state = {
	adminInfo: {
		avatar: 'default.jpg',
		loginId: null,
		rolename: null
	},
}

const mutations = {
	saveAdminInfo(state, adminInfo){
		// state.adminInfo.loginId = adminInfo.loginId;
		// state.adminInfo.rolename = adminInfo.rolename;
		state.adminInfo = adminInfo;
	},
	clearAdminInfo(state){
		state.adminInfo = null;
	}
}

const actions = {
	async getAdminData({commit}){
		try{
			const res = await getAdminInfo()
			if (res.code == 200) {
				console.log("commit200:"+res)
				commit('saveAdminInfo', res.data);
			}else{
				throw new Error(res)
			}
		}catch(err){
			console.log('您尚未登陆或者session失效')
		}
	},
	async clearAdminData({commit}){
		commit('clearAdminIndo');
	}
}

export default new Vuex.Store({
	state,
	actions,
	mutations,
})