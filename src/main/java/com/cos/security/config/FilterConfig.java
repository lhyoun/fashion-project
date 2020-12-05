package com.cos.security.config;

import javax.servlet.FilterRegistration;	// javax로 시작하는 건 다 tomcat lib

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cos.security.config.filter.JwtAuthenticationFilter;
import com.cos.security.config.filter.JwtAuthorizationFilter;
import com.cos.security.config.filter.Myfilter1;
import com.cos.security.domain.user.repository.UserRepository;

@Configuration
public class FilterConfig{
// configuration 달면 FilterConfig만 memory에 뜨고 
	
	@Autowired
	private UserRepository userRepository;

	// bean을 달아주면 return 값이 IoC로 등록
	@Bean
	public FilterRegistrationBean<Myfilter1> myFilter1(){
		FilterRegistration exFilter; 	// 얘는 서블릿 필터라서 ioc필터를 사용할 수 없다
		
		System.out.println("서버 실행 될 때 실행");
		FilterRegistrationBean<Myfilter1> bean = new FilterRegistrationBean<>(new Myfilter1());
		// 이렇게 하면 스프링 필터에 등록이 된다 (실행 되면)
		 
		bean.addUrlPatterns("/*");	// 주소 요청이 있을 때 마다 실행
		bean.setOrder(0);	// 낮은 번호부터 실행됨
		return bean;
		// return 해주는 이유 : 만들어진 빈이 IoC로 등록이 되어야 해서
	}
	/*
	@Bean
	public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilter(){
		System.out.println("JwtAuthenticationFilter 필터 등록");
		FilterRegistrationBean<JwtAuthenticationFilter> bean = 
				new FilterRegistrationBean<>(new JwtAuthenticationFilter(userRepository));
		bean.addUrlPatterns("/loginProc");
		bean.setOrder(1);
		return bean; 
	}
	
	@Bean
	public FilterRegistrationBean<JwtAuthorizationFilter> jwtAuthorizationFilter(){
		System.out.println("JwtAuthorizationFilter 필터 등록");
		FilterRegistrationBean<JwtAuthorizationFilter> bean = 
				new FilterRegistrationBean<>(new JwtAuthorizationFilter(userRepository));
		bean.addUrlPatterns("/user/*");
		bean.setOrder(2);
		return bean;
	}
	*/
}
// 일단 IoC로 등록되어서 메모리에는 뜨고 함수는 강제로 실행되어서? IoC에 등록

// 이 페이지의 역할은 서버가 최초 등록 될 때 필터 등록하는 역할