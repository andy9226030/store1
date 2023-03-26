package com.store1.config;

import com.store1.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加Configuration 讓springboot管理
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /**
     * 添加白名單跟黑名單
     *
     * @param registry
     */
    @Override
    /**
     * addInterceptors 意思為添加攔截器
     */
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor handlerInterceptor = new LoginInterceptor();

        /**
         * 建立一個array來存可以通行的白名單
         */
        List paper = new ArrayList();

        paper.add("/bootstrap3/**");
        paper.add("/css/**");
        paper.add("/images/**");
        paper.add("/js/**");
        paper.add("/web/Login.html");
        paper.add("/web/register.html");
        paper.add("/web/index.html");
        paper.add("/users/reg");
        paper.add("/users/Login");
        paper.add("/district/**");

        /**
         * addInterceptor 添加配置把剛剛寫好用ｕｉｄ 判斷通行的
         * addPathPatterns 把所有的路境都設成黑名單
         * excludePathPatterns 設定白名單 通行的網頁
         */
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**").excludePathPatterns(paper);
    }

    /**
     * @Override
     *     public void addViewControllers(ViewControllerRegistry registry) {
     *         registry.addViewController("/bootstrap3").setViewName("/web/Login.html");
     *         registry.addViewController("/css").setViewName("/web/Login.html");
     *         registry.addViewController("/js").setViewName("/web/Login.html");
     *         registry.addViewController("/images").setViewName("/web/Login.html");
     *         registry.addViewController("/web/Login.html").setViewName("/web/Login.html");
     *         registry.addViewController("/web/register.html").setViewName("/web/register.html");
     *         registry.addViewController("/user/Login").setViewName("users/Login");
     *         registry.addViewController("/users/reg").setViewName("users/reg");
     *         registry.addViewController("/web/index.html").setViewName("/web/index.html");
     *     }
     * @param registry
     */
}

