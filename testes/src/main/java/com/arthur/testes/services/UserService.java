package com.arthur.testes.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.testes.domain.User;
import com.arthur.testes.domain.dto.UserDto;
import com.arthur.testes.exceptions.ResourcesNotFoundException;
import com.arthur.testes.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public UserDto findById(Integer id){
		
		User entity = userRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("usuario nao encontrado"));
		
		UserDto obj = mapper.map(entity, UserDto.class);
		return obj;	
	}
	
	public List<UserDto> findAll(){
		
		List<User> entitys = userRepository.findAll();
		
		TypeToken<List<UserDto>> typeToken = new TypeToken<>() {
		};	
			List<UserDto> obj = mapper.map(entitys, typeToken.getType());
			
			return obj;
	}
	
	public UserDto createUser(UserDto userdto) {
		var entity = findByEmail(userdto);
		System.out.println(userdto.getSenha());
		
	
		
		if(entity != null) { 
			throw new ResourcesNotFoundException("Email já cadastrado");
		}
		else {
			

			var obj = userRepository.save(mapper.map(userdto, User.class));
			System.out.println(obj.getSenha());

			return mapper.map(obj, UserDto.class);
		}
		
	}
	
	public UserDto updateUser(UserDto userdto) {
		
		User obj = new User();
		UserDto entity = new UserDto();
		
		try {
			 obj = userRepository.save(mapper.map(userdto, User.class));
			 entity = mapper.map(obj, UserDto.class);
				

		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		return entity;
	}
	
	
	
	public User findByEmail(UserDto userdto) {
		var obj = userRepository.findByEmail(userdto.getEmail());
		if(obj != null) {
			return obj;
		}
		else {
			return null;
		}
		
	}
	
	public void deleteUser(Integer id) {
		var entity = userRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Usuário nao encontrado"));
		userRepository.delete(entity);
		
		
	}
	
}
