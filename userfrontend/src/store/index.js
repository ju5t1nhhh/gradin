import Vue from 'vue'
import Vuex from 'vuex'
import {getMyInfo} from '@/api/getData'

Vue.use(Vuex)

const state = {
	myInfo: {
		id: null,
	},
}

const mutations = {
	saveMyInfo(state, myInfo){
		state.myInfo = myInfo;
	},
	clearMyInfo(state){
		state.myInfo = null;
	}
}

const actions = {
	async getMyData({commit}){
		try{
			const res = await getMyInfo()
			if (res.code == 200) {
				console.log("commit200:"+res)
				commit('saveMyInfo', res.data);
			}else{
				throw new Error(res)
			}
		}catch(err){
			console.log('您尚未登陆或者session失效')
		}
	},
	async clearMyData({commit}){
		commit('clearMyIndo');
	}
}

export default new Vuex.Store({
	state,
	actions,
	mutations,
})