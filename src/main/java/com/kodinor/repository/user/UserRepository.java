package com.kodinor.repository.user;

import org.springframework.data.repository.CrudRepository;

import com.kodinor.entity.user.User;

public interface UserRepository extends CrudRepository<User, Long> {
	//
}
