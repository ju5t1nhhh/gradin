package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface FollowService {

    RestResponse modFollow(long user);

    RestResponse listFlws(long user);

    RestResponse listFans(long user);

}
