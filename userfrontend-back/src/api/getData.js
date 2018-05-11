import fetch from '@/config/fetch'

export const checkId = data => fetch('/user/checkid/'+data, {}, 'POST');

export const checkEmail = data => fetch('/user/checkemail', data, 'POST');

export const register = data => fetch('/user/register', data, 'POST');

export const getMyInfo = data => fetch('/user/my', {}, 'POST');

/**
 * 登陆
 */

export const login = data => fetch('/login', data, 'POST');

/**
 * 退出
 */

export const signout = () => fetch('/logout');

/**
 * 获取用户信息
 */

export const getAdminInfo = () => fetch('/admin/myinfo', {}, 'POST');

export const getMyPermissions = () => fetch('/permission/my', {}, 'POST');

export const listAdmins = () => fetch('/admin/list',{},'POST');

export const listRoles = () => fetch('/role/list',{}, 'POST');

export const listPayments = data => fetch('/payment/list', data, 'POST');

export const listPermission = () => fetch('/permission/list', {}, 'POST');

export const addAdmin = data => fetch('/admin/add', data, 'POST');

export const delAdmin = data => fetch('/admin/del/'+data, {}, 'POST');

export const modAdmin = data => fetch('/admin/mod', data, 'POST');

export const addRole = data => fetch('/role/add/'+data, {}, 'POST');

export const delRole = data => fetch('/role/del/'+data, {}, 'POST');

export const addPayment = data => fetch('/payment/add', data, 'POST');

export const listUser = data => fetch('/user/list', data, 'POST');

export const listComment = data => fetch('/comment/list', data, 'POST');

export const addUser = data => fetch('/user/add', data, 'POST');

export const delUser = data => fetch('/user/del', data, 'POST');

export const getUser = data => fetch('/user/get', data, 'POST');

export const modUser = data => fetch('/user/mod', data ,'POST');

export const delComment = data => fetch('/comment/del', data, 'POST');

export const listPost = data => fetch('/post/list', data, 'POST');

export const listLogrecord = data => fetch('/logrecord/list/'+data, {}, 'POST');

export const delPost = data => fetch('/post/del/'+data, {}, 'POST');

export const listComplaintPost = data => fetch('/complaint/list', data, 'POST');

export const listComplaint = data => fetch('/complaint/list/post', data, 'POST');

export const listSection = data => fetch('/section/list', data, 'POST');

export const listSW = data => fetch('/sw/list', data, 'POST');

export const modComplaint = data => fetch('/complaint/deal', data, 'POST');

export const addSW = data => fetch('/sw/add', data, 'POST');

export const delSW = data => fetch('/sw/del', data, 'POST');

export const addSection = data => fetch('/section/add', data, 'POST');

export const delSection = data => fetch('/section/del/'+data, {}, 'POST');

export const modSection = data => fetch('/section/mod', data, 'POST');

export const listRolePermission = data => fetch('/permission/'+data, {}, 'POST');

export const modRolePermission = (role, perms) => fetch('/role/perm/'+role, perms, 'POST');