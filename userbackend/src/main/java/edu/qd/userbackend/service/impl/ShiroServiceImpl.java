package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.service.ShiroService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


@Service
public class ShiroServiceImpl implements ShiroService {

    @Override
    public RestResponse login(String id, String password) {
        RestResponse restResponse = null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(id, password);
        try {
            subject.login(token);
            restResponse = RestResponse.successWithData("登录成功", subject.getSession().getId());
        } catch (IncorrectCredentialsException ice){
            restResponse = RestResponse.errorWithMsg(1011,"密码错误");
        } catch (AuthenticationException ae) {
            restResponse = RestResponse.errorWithMsg(1012,"用户不存在");
        } catch (Exception e) {
            restResponse = RestResponse.errorWithMsg(1013,"未知错误");
            e.printStackTrace();
        }
        return restResponse;
    }
}
