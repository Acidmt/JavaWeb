package com.Filters.cn;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter({"/CartShopping.jsp","/AddShoppong","/ShowUser.jsp","/SelectUser","/ShowUser.jsp"})
public class SelectUserBase implements Filter {
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
            response1.sendRedirect("/Web-Shopping/Login.jsp");
        }else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
    }
}
