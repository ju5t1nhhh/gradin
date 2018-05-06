package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface TagService {

    RestResponse search(String word);

    RestResponse getPosts(String word, int page);

}
