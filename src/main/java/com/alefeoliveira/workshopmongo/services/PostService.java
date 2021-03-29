package com.alefeoliveira.workshopmongo.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		 maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		 return repository.fullSearch(text, minDate, maxDate);
	}
	
}
