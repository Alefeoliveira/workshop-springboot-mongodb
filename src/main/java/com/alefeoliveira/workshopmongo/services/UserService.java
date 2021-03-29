package com.alefeoliveira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alefeoliveira.workshopmongo.domain.User;
import com.alefeoliveira.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User update(User obj) {
		User objNew = repository.findById(obj.getId()).get();
		updateData(objNew, obj);
		return repository.save(objNew);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}
