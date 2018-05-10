package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.dao.RoleDao;
import edu.qd.adminbackend.dao.RolePermissionDao;
import edu.qd.adminbackend.domain.Role;
import edu.qd.adminbackend.service.RoleService;
import edu.qd.adminbackend.util.ArrayToListUtil;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private LogRecordDao logRecordDao;

    @Override
    public RestResponse addRole(String role) {
        Role instants = new Role();
        instants.setName(role);
        int rows = roleDao.insertOne(instants);
        if ( rows > 0 ) {
            Thread thread = new Thread(()->{
                rolePermissionDao.insertOne(instants.getId(),1);
                rolePermissionDao.insertOne(instants.getId(),5);
                rolePermissionDao.insertOne(instants.getId(),6);
                rolePermissionDao.insertOne(instants.getId(),9);
                rolePermissionDao.insertOne(instants.getId(),11);
                rolePermissionDao.insertOne(instants.getId(),15);
                rolePermissionDao.insertOne(instants.getId(),16);
                rolePermissionDao.insertOne(instants.getId(),18);
                rolePermissionDao.insertOne(instants.getId(),19);
                rolePermissionDao.insertOne(instants.getId(),21);
                rolePermissionDao.insertOne(instants.getId(),22);
                rolePermissionDao.insertOne(instants.getId(),23);
                rolePermissionDao.insertOne(instants.getId(),24);
                rolePermissionDao.insertOne(instants.getId(),26);
                rolePermissionDao.insertOne(instants.getId(),27);
                rolePermissionDao.insertOne(instants.getId(),29);
                rolePermissionDao.insertOne(instants.getId(),30);
                rolePermissionDao.insertOne(instants.getId(),34);
                rolePermissionDao.insertOne(instants.getId(),35);
                rolePermissionDao.insertOne(instants.getId(),38);
                rolePermissionDao.insertOne(instants.getId(),39);
                rolePermissionDao.insertOne(instants.getId(),43);
            });
            thread.start();
            LogRecordDaoUtil.insertLogRecord(logRecordDao, "新增角色:"+role);
            return RestResponse.successWithMsg("添加角色成功");
        } else {
            return RestResponse.errorWithMsg(1006, "添加角色失败");
        }
    }

    @Override
    public RestResponse delRole(String role) {
        Role instants = new Role();
        instants.setName(role);
        int rows = roleDao.deleteByDTO(instants);
        if ( rows > 0 ) {
            LogRecordDaoUtil.insertLogRecord(logRecordDao,"删除角色:"+role);
            return RestResponse.successWithMsg("删除角色" + role + "成功");
        } else {
            return RestResponse.errorWithMsg(1007, "删除角色" + role + "失败");
        }
    }

    @Override
    public RestResponse listRoles() {
        Role[] roles = roleDao.selectByDTO(null, 0, -1);
        return RestResponse.successWithData("查看角色成功", roles);
    }

    @Override
    @Transactional
    public RestResponse modRoleToPerm(int role, List<Integer> perms) {
        int[] oldPerms = rolePermissionDao.selectPermByRole(role);
        List<Integer> oldPermsList = new ArrayList();
        for ( int oldPerm : oldPerms )
            oldPermsList.add(oldPerm);
        List<Integer> removeList = ArrayToListUtil.listARemoveListB(oldPermsList, perms);
        List<Integer> addList = ArrayToListUtil.listARemoveListB(perms,oldPermsList);
        int delNum = 0, addNum = 0;
        for ( Integer perm : removeList )
            delNum += rolePermissionDao.deleteOne(role, perm.intValue());
        for ( Integer perm : addList )
            addNum += rolePermissionDao.insertOne(role, perm.intValue());
        String msg = "成功给角色" + role + "添加" + addNum + "项权限，移除" + delNum + "项权限";
        LogRecordDaoUtil.insertLogRecord(logRecordDao, msg);
        return RestResponse.successWithMsg(msg);
    }

}
