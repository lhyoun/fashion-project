package com.cos.security.config.filter;

interface JwtProps {
	// public static final
	String secret = "비밀키";
	String auth = "Bearer ";
	String header = "Authorization";
}