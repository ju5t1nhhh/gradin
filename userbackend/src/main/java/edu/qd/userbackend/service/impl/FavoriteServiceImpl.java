package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.FavoriteDao;
import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.FavoriteService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

    @Override
    public RestResponse addFavor(long post) {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Favorite favorite = new Favorite(user.getAutoId(), post);
        Favorite[] favorites = favoriteDao.selectByDTO(favorite, 0, 1);
        if ( favorites.length == 0 ) {
            favoriteDao.insertOne(favorite);
            return RestResponse.successWithMsg("收藏成功");
        } else {
            return RestResponse.successWithMsg("已经收藏过了");
        }
    }

    @Override
    public RestResponse cancelFavor(long post) {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Favorite favorite = new Favorite(user.getAutoId(), post);
        int rows = favoriteDao.deleteByDTO(favorite);
        if ( rows > 0 ) {
            return RestResponse.successWithMsg("取消收藏成功");
        } else {
            return RestResponse.errorWithMsg(1702, "请稍后重试");
        }
    }

    @Override
    public RestResponse listFavor() {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        long[] posts = favoriteDao.getFavorite(user.getAutoId());
        return RestResponse.successWithData("查看成功", posts);
    }
}
