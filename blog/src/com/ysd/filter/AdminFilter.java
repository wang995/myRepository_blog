package com.ysd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器");
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;  
        HttpServletResponse response = (HttpServletResponse)arg1;  
		String path = request.getRequestURI();//获取请求的url
        String contentPath=request.getContextPath();//获取项目根目录
        String targetUrl=path.substring(contentPath.length());
        HttpSession session = request.getSession();
        if(!targetUrl.contains("admin.jsp")){  
        	chain.doFilter(request, response);  
        	return;
        }else {
        	System.out.println(session.getAttribute("isAdmin"));
        	if(session==null || session.getAttribute("isAdmin")==null) {
        		System.out.println("!admin");
        		response.sendRedirect("index.jsp");
        	}else {
        		chain.doFilter(request, response);  
            	return;
        	}
        }
	}
	
}
