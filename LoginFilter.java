package com.neusoft.ehr.sys;

import com.neusoft.ehr.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="LoginFilter",urlPatterns="/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对所有请求进行过滤，检测是否含有session和user
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;
        String requestURI=request.getRequestURI();
        if(!requestURI.equals("/")&&!requestURI.startsWith(request.getContextPath()+"/login")&&!requestURI.startsWith(request.getContextPath()+"/assets")){
            HttpSession session=request.getSession(false);
            if(session!=null) {
                User principal=(User)session.getAttribute("principal");
                if(principal!=null) {
                    chain.doFilter(request, response);
                    return;
                }else {
                    session.invalidate();
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/WEB-INF/login.jsp");
            }
        }else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
