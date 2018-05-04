package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class SectionDaoTest {
    @Autowired
    private SectionDao sectionDao;

    @Test
    public void selectById() throws Exception {
        Section section = new Section(12,"asdasd","asdd","daedasd");
        sectionDao.insertOne(section);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}