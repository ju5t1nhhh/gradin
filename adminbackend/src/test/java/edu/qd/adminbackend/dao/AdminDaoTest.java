package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void insertOne() throws Exception {
        Admin admin = new Admin("jijiji","asdasd",2);
        adminDao.insertOne(admin);
    }

    @Test
    public void updateOne() throws Exception {
        Admin admin = new Admin("justin","wwwwww",2);
        adminDao.updateOne(admin);
    }

    @Test
    public void deleteByDTO() throws Exception {
        Admin admin = new Admin("jijiji",null,0);
        adminDao.deleteByDTO(admin);
    }

    @Test
    public void selectByDTO() throws Exception {
        Admin admin = new Admin("justin",null,0);
        Admin[] admins = adminDao.selectByDTO(admin,0,1);
        for ( Admin adm : admins )
            System.out.println(adm);
    }

}