package org.example.Handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
@Component
public class WebInterceptorHandler implements HandlerInterceptor {
    private final String USER_TOKEN_NAME = "token";

    private final String USER_TOKEN_VALUE = "ymx";

    private final String AUTH_HEADER = "ymx-name";

    private final String PRIVATE_URL = "/user/getUserPrivateInfo";

    private final String REDIRECT_URL = "/user/noAuth";

    /**
     * 预处理回调方法
     * @param request
     * @param response
     * @param handler
     * @return 返回true为继续处理，false为中断处理
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getParameter(USER_TOKEN_NAME);
        String headerValue = request.getHeader(AUTH_HEADER);
        String requestURI = request.getRequestURI();

        //用户个人隐私
        //带上请求参数token加请求头ymx-name
        if (PRIVATE_URL.equals(requestURI)) {
            if (USER_TOKEN_VALUE.equals(headerValue) && USER_TOKEN_VALUE.equals(token)) {
                return true;
            } else {
                //拦截后跳转路径
                response.sendRedirect(REDIRECT_URL);
                return false;
            }
        }

        //一般隐私
        //带上请求参数token
        if (USER_TOKEN_VALUE.equals(token)) {
            return true;
        }

        //拦截后跳转路径
        response.sendRedirect(REDIRECT_URL);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
