package com.cos.security.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.security.domain.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
}
