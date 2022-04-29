package com.microservicios.eventos.interceptors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Date;

@Component
class LoggerInterceptor implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Autowired
    HandlerInterceptor yourInjectedInterceptor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("x-auth-token");
        return true;
        /*if(token == null || token == "") {
            log.info("[authentication falied] " + "(" + request.getMethod() + ") - " + request.getRequestURI() + " --> " + new Date());
            return false;
        }*/

        /*
        try {
            String urlHttp = "https://www.paseshow.com.ar/";
            CloseableHttpClient httpclient = HttpClients.createDefault();

            HttpGet requestPS = new HttpGet(urlHttp);

            CloseableHttpResponse responsePS = httpclient.execute(requestPS);
            log.info("[authentication verificate] " + "(" + request.getMethod() + ") - " + request.getRequestURI() + " --> " + new Date());

            return true;
        }catch (Exception e) {
            throw new Exception();
        }*/

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoggerInterceptor());
    }

}