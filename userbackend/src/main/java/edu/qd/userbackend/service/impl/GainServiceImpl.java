package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.domain.Gain;
import edu.qd.userbackend.service.GainService;
import edu.qd.userbackend.vo.RestResponse;
import org.springframework.stereotype.Service;

@Service
public class GainServiceImpl implements GainService {
    @Override
    public RestResponse addGain(Gain gain) {
        return null;
    }

    @Override
    public RestResponse myGains() {
        return null;
    }

    @Override
    public RestResponse listGivers(long post) {
        return null;
    }
}
