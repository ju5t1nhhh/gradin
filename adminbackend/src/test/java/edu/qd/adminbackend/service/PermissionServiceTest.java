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
public class PermissionServiceTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void addPerm() throws Exception {
    }

    @Test
    public void delPerm() throws Exception {
    }

    @Test
    public void modifyPerm() throws Exception {
    }

    @Test
    public void listPerm() throws Exception {
    }

    @Test
    public void listPermByRole() throws Exception {
        RestResponse restResponse = permissionService.listPermByRole(1);
        System.out.println(restResponse);
    }

}