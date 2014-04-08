package com.bitcup.spring.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        // added: Authorization to list of allowed headers in order to make HMAC authorization work in cross domain
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Origin, Accept, Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "1800"); //30 min
        filterChain.doFilter(request, response);
    }

}