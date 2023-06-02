package com.arthur.testes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.arthur.testes.domain.User;
import com.arthur.testes.repositories.UserRepository;



@Service
public class DbServices {
	
	@Autowired
	 private UserRepository userrepository;


	
	
	@Bean
	public void instanciaDB() {
		
		
		User user1 = new User(null, "Yone","Yone@gmail.com", "123456");
		User user2 = new User(null, "Yasuo","Yasuo@gmail.com", "123456");
		User user3 = new User(null, "Riven","Riven@gmail.com", "123456");
		
		
		userrepository.saveAll(List.of(user1,user2,user3));
	}

}
