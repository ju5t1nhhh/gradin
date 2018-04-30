package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.SensitiveWord;
import edu.qd.adminbackend.vo.RestResponse;

public interface SensitiveWordService {

    RestResponse addSensitiveWord(SensitiveWord sensitiveWord);

    RestResponse delSensitiveWord(SensitiveWord sensitiveWord);

    RestResponse listSensitiveWord(SensitiveWord sensitiveWord);

}
