package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void addAdmin() throws Exception {
        Admin admin = new Admin("justin","123456",3);
        System.out.println(adminService.addAdmin(admin));
    }

    @Test
    public void delAdmin() throws Exception {
        System.out.println(adminService.delAdmin("banana"));
    }

    @Test
    public void modifyAdmin() throws Exception {
    }

    @Test
    public void listAdmin() throws Exception {
        System.out.println(adminService.listAdmin(null));
    }

}