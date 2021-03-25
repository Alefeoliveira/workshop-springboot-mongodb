package com.alefeoliveira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alefeoliveira.workshopmongo.domain.User;
import com.alefeoliveira.workshopmongo.repository.UserRepsitory;
import com.alefeoliveira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	public UserRepsitory repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException(id);
		}
		return user.get();
	}
}
