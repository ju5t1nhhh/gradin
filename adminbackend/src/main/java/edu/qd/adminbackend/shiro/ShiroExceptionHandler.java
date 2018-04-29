package edu.qd.adminbackend.shiro;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ShiroExceptionHandler implements HandlerExceptionResolver {

    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> map = new HashMap<>();
        if (e instanceof AuthenticationException) {
            map.put("code", "999");
            map.put("msg", "用户名或密码错误");
        }
        else if (e instanceof UnauthenticatedException) {
            map.put("code", "1003");
            map.put("msg", "token错误");
        } else if (e instanceof UnauthorizedException) {
            map.put("code", "1002");
            map.put("msg", "无权限");
        } else {
            map.put("code", "1999");
            map.put("msg", e.getMessage());
        }
        view.setAttributesMap(map);
        mv.setView(view);
        return mv;
    }
}
