package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface ScoreService {

    RestResponse addScore(long post, int score);

    RestResponse delScore(long post);

    RestResponse listScore(int page);
}
