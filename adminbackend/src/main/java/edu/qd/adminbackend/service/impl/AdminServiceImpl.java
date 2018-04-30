package edu.qd.adminbackend.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.qd.adminbackend.dao.AdminDao;
import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.service.AdminService;
import edu.qd.adminbackend.util.PasswordUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addAdmin(Admin admin) {
        admin.setPwd(PasswordUtil.encryptPassword(admin.getLoginId(),admin.getPwd()));
        int rows = adminDao.insertOne(admin);
        if ( rows > 0 ) {
            admin.setPwd(null);
            redisTemplate.opsForList().rightPush("admins", JSON.toJSONString(admin));
            return RestResponse.successWithMsg("新增管理员成功");
        } else {
            return RestResponse.errorWithMsg(1001, "新增管理员失败，检查用户名");
        }
    }

    @Override
    public RestResponse delAdmin(String id) {
        Admin admin = new Admin();
        admin.setLoginId(id);
        admin = adminDao.selectByDTO(admin,0,1)[0];
        int rows = adminDao.deleteByDTO(admin);
        if ( rows > 0 ) {
            redisTemplate.opsForList().remove("admins",1, JSON.toJSONString(admin));
            return RestResponse.successWithMsg("删除管理员成功");
        } else {
            return RestResponse.errorWithMsg(1004, "删除管理员失败");
        }
    }

    @Override
    public RestResponse modifyAdmin(Admin admin) {
        Admin condition = new Admin();
        condition.setLoginId(admin.getLoginId());
        if ( admin.getPwd() != null && !admin.getPwd().equals("") )
            admin.setPwd(PasswordUtil.encryptPassword(admin.getLoginId(),admin.getPwd()));
        Admin oldAdmin = adminDao.selectByDTO(condition,0,1)[0];
        int rows = adminDao.updateOne(admin);
        if ( rows > 0 ) {
            admin.setPwd(null);
            redisTemplate.opsForList().remove("admins",1, JSON.toJSONString(oldAdmin));
            redisTemplate.opsForList().rightPush("admins", JSON.toJSONString(admin));
            return RestResponse.successWithMsg("修改管理员" + admin.getLoginId() + "成功");
        } else {
            return RestResponse.errorWithMsg(1004, "修改管理员" + admin.getLoginId() + "失败");
        }
    }

    @Override
    public RestResponse listAdmin(Admin admin) {
        RestResponse restResponse = null;
        List<String> adminStrings = redisTemplate.opsForList().range("admins",0,-1);
        if ( adminStrings.size() == 0 ) {
            Admin[] admins = adminDao.selectByDTO(admin,0,-1);
            Thread thread = new Thread(() -> {
                for ( Admin adm : admins )
                    redisTemplate.opsForList().rightPush("admins", JSON.toJSONString(adm));
            });
            thread.start();
            restResponse = RestResponse.successWithData("查看管理员成功", admins);
        } else {
            List<Admin> adminList = new LinkedList<>();
            for ( String str : adminStrings )
                adminList.add(JSON.parseObject(str,Admin.class));
            restResponse = RestResponse.successWithData("查看管理员成功", adminList.toArray());
        }
        return restResponse;
    }

}
