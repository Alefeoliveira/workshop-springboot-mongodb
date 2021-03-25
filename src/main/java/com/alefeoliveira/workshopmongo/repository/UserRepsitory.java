package com.alefeoliveira.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alefeoliveira.workshopmongo.domain.User;

@Repository
public interface UserRepsitory extends MongoRepository<User, String>{

}
