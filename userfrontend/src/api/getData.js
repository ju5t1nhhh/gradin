import fetch from '@/config/fetch'

/**
 * 登陆
 */

export const login = data => fetch('/login', data, 'POST');

/**
 * 退出
 */

export const signout = () => fetch('/logout');

export const checkId = data => fetch('/user/checkid/'+data, {}, 'POST');

export const checkEmail = data => fetch('/user/checkemail', data, 'POST');

export const register = data => fetch('/user/register', data, 'POST');

export const getMyInfo = () => fetch('/user/my', {}, 'POST');

export const getMyDetail = () => fetch('/user/detail', {}, 'POST');

export const changePwd = data => fetch('/user/modpwd', data, 'POST');

export const chargeCode = data => fetch('/payment/code', data, 'POST');

export const addPost = data => fetch('/post/add', data, 'POST');