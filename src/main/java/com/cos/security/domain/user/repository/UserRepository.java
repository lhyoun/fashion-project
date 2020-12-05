package com.cos.security.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.security.domain.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
	int countByUsername(String username);	//count = 결과 레코드수 반환

	User findByUsernameAndPassword(String username, String password);

}
