package com.alefeoliveira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alefeoliveira.workshopmongo.domain.User;
import com.alefeoliveira.workshopmongo.repository.UserRepsitory;

@Service
public class UserService {
	
	@Autowired
	public UserRepsitory repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
