package edu.qd.userbackend.service;

import edu.qd.userbackend.domain.Gain;
import edu.qd.userbackend.vo.RestResponse;

public interface GainService {

    RestResponse addGain(Gain gain);

    RestResponse myGains();

    RestResponse listGivers(long post);

}
