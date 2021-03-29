package com.alefeoliveira.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alefeoliveira.workshopmongo.domain.Post;
import com.alefeoliveira.workshopmongo.domain.User;
import com.alefeoliveira.workshopmongo.dto.AuthorDTO;
import com.alefeoliveira.workshopmongo.dto.CommentDTO;
import com.alefeoliveira.workshopmongo.repository.PostRepository;
import com.alefeoliveira.workshopmongo.repository.UserRepsitory;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	public UserRepsitory userRepsitory;
	
	@Autowired
	public PostRepository postRepsitory;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepsitory.deleteAll();
		postRepsitory.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
			
		userRepsitory.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null,sdf.parse("21/03/2021"),"partiu viagem", "vou viajar para sp, abraços!!!!", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2021"),"partiu viajar com a maria", "vou viajar para sp com meu amor, abraços!!!!", new AuthorDTO(alex));
		Post post3 = new Post(null,sdf.parse("22/03/2021"),"partiu voltar", "vou voltar para casa", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2021"), new AuthorDTO(bob));
		CommentDTO c2 = new CommentDTO("Obrigado meu mano!", sdf.parse("21/03/2021"), new AuthorDTO(alex));
		CommentDTO c3 = new CommentDTO("Vamos juntos *-*!", sdf.parse("21/03/2021"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(c2,c3));
		post2.getComments().addAll(Arrays.asList(c1));
		
		postRepsitory.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post3));
		userRepsitory.save(maria);
		
	}

}
