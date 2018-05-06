package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.AdminDao;
import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.service.AdminService;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.util.PasswordUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private LogRecordDao logRecordDao;

    @Override
    public RestResponse addAdmin(Admin admin) {
        admin.setPwd(PasswordUtil.encryptPassword(admin.getLoginId(),admin.getPwd()));
        int rows = adminDao.insertOne(admin);
        if ( rows > 0 ) {
            LogRecordDaoUtil.insertLogRecord(logRecordDao,"新增管理员"+admin.getLoginId());
            return RestResponse.successWithMsg("新增管理员成功");
        } else {
            return RestResponse.errorWithMsg(1001, "新增管理员失败，检查用户名");
        }
    }

    @Override
    public RestResponse delAdmin(String id) {
        Admin admin = new Admin();
        admin.setLoginId(id);
        int rows = adminDao.deleteByDTO(admin);
        if ( rows > 0 ) {
            LogRecordDaoUtil.insertLogRecord(logRecordDao,"删除管理员"+admin.getLoginId());
            return RestResponse.successWithMsg("删除管理员成功");
        } else {
            return RestResponse.errorWithMsg(1004, "删除管理员失败");
        }
    }

    @Override
    public RestResponse modifyAdmin(Admin admin) {
        if ( admin.getPwd() != null && !admin.getPwd().equals("") )
            admin.setPwd(PasswordUtil.encryptPassword(admin.getLoginId(),admin.getPwd()));
        int rows = adminDao.updateOne(admin);
        if ( rows > 0 ) {
            return RestResponse.successWithMsg("修改管理员" + admin.getLoginId() + "成功");
        } else {
            return RestResponse.errorWithMsg(1004, "修改管理员" + admin.getLoginId() + "失败");
        }
    }

    @Override
    public RestResponse listAdmin(Admin admin) {
        Admin[] admins = adminDao.selectByDTO(admin,0,-1);
        return RestResponse.successWithData("查看管理员成功", admins);
    }

}
