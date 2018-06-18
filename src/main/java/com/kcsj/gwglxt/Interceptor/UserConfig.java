package com.kcsj.gwglxt.Interceptor;

import com.kcsj.gwglxt.DTO.LoginCustom;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object handler) throws Exception{
        System.out.println("getContextPath:" + httpServletRequest.getContextPath());
        System.out.println("getServletPath:" + httpServletRequest.getServletPath());
        System.out.println("getRequestURI:" + httpServletRequest.getRequestURI());
        System.out.println("getRequestURL:" + httpServletRequest.getRequestURL());
        System.out.println("getRealPath:" + httpServletRequest.getSession().getServletContext().getRealPath("image"));
        LoginCustom loginCustom = (LoginCustom) httpServletRequest.getSession().getAttribute("LoginInformation");
        if(null==loginCustom||"".equals(loginCustom)){
            httpServletResponse.sendRedirect("addDocument.html");
            return  false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws  Exception{

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) throws  Exception{

    }
}
