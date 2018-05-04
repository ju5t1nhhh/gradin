package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface LikesService {

    RestResponse addLikes(long post, int cmtId);

    RestResponse disLikes(long post, int cmtId);

    RestResponse myLikes(int page);

}
