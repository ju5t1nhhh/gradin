package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface LikesService {

    RestResponse modLikes(long post, int cmtId);

    RestResponse myLikes(int page);

}
