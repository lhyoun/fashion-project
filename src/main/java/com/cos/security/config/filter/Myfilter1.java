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
		
		System.out.println(TAG+"doFilter()탐");
		chain.doFilter(request, response);
		// 이걸 넣어줘야 다음 필터도 탄다
	}
}

// 등록 된 config에서 설정한 상황에서 dofilter가 작동