package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Section;
import edu.qd.adminbackend.vo.RestResponse;

public interface SectionService {

    RestResponse addSection(Section section);

    RestResponse delSection(int id);

    RestResponse modSection(Section section);

    RestResponse listSection();

}
