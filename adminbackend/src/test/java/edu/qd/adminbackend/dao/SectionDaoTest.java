package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)

public class SectionDaoTest {
    @Autowired
    private SectionDao sectionDao;

    @Test
    public void insertOne() throws Exception {
        Section section = new Section(1,"jijissi","asdaaaaaaaaaaasd","dsdasd");
        sectionDao.updateOne(section);
    }


}