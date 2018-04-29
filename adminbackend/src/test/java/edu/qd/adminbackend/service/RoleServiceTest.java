package edu.qd.adminbackend.service;

import edu.qd.adminbackend.vo.RestResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void addRole() throws Exception {
        RestResponse restResponse = null;
//        restResponse = roleService.addRole("用户管理员");
//        System.out.println(restResponse);
        restResponse = roleService.addRole("火区管理员");
        System.out.println(restResponse);
        restResponse = roleService.addRole("热区管理员");
        System.out.println(restResponse);
    }

    @Test
    public void delRole() throws Exception {
    }

    @Test
    public void listRoles() throws Exception {
        System.out.println(roleService.listRoles());
    }

    @Test
    public void modRoleToPerm() throws Exception {

    }

}