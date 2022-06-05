package com.Filters.cn;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter("/index.jsp")
public class ShowTimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        String userName = (String) request1.getSession().getAttribute("userName");
        String userPassword = (String) request1.getSession().getAttribute("userPassword");
        if (userName == null || userPassword == null) {
            chain.doFilter(request, response);
            return;
        }
        String dateFormat = new SimpleDateFormat("yyyy.MM.dd.hh:mm:ss").format(new Date());
        String userTime=userName+"Time";
        Cookie cookies=new Cookie(userTime,dateFormat);
        cookies.setMaxAge(60*60*24*10);
        response1.addCookie(cookies);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
