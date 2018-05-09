package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Section;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionDao extends BaseDao<Section> {

    int selectExists(int id);

}
