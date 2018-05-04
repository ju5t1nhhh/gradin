package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.service.LikesService;
import edu.qd.userbackend.vo.RestResponse;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {
    @Override
    public RestResponse addLikes(long post, int cmtId) {
        return null;
    }

    @Override
    public RestResponse disLikes(long post, int cmtId) {
        return null;
    }

    @Override
    public RestResponse myLikes(int page) {
        return null;
    }
}
