package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface FavoriteService {

    RestResponse addFavor(long post);

    RestResponse cancelFavor(long post);

    RestResponse listFavor();

}
