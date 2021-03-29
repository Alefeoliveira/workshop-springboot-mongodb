package com.alefeoliveira.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alefeoliveira.workshopmongo.domain.Post;
import com.alefeoliveira.workshopmongo.repository.PostRepository;
import com.alefeoliveira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	public PostRepository repository;
	
	
	
	public Post findById(String id) {
		Post user = repository.findById(id).get();
		if(user == null) {
			throw new ObjectNotFoundException(id);
		}
		return user;
	}
	
}
