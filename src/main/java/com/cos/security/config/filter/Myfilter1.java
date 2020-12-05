package com.cos.security.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Myfilter1 implements Filter{

	public static final String TAG = "MyFilter1:";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpServletResponse ss = (HttpServletResponse)response;
		ss.setHeader("Access-Control-Allow-Origin", "*");
		
		ss.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		ss.setHeader("Access-Control-Max-Age", "3600");
		ss.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
		ss.setHeader("Access-Control-Allow-Credentials", "true");
		ss.setHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials");

		System.out.println(TAG+"doFilter()탐");
		chain.doFilter(request, response);
		// 이걸 넣어줘야 다음 필터도 탄다
	}
}

// 등록 된 config에서 설정한 상황에서 dofilter가 작동