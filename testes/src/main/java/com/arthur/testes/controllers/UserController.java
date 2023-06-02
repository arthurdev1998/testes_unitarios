package com.arthur.testes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.testes.domain.dto.UserDto;
import com.arthur.testes.services.UserService;



@RequestMapping(value="/api/user")
@RestController
public class UserController {

	@Autowired
	private UserService usuarioservice;
	
	@GetMapping(value="/{Id}")
	public ResponseEntity<UserDto> getById(@PathVariable(value="Id")Integer id) {
		var obj = usuarioservice.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}	
		
	@GetMapping
	public ResponseEntity<List<UserDto>> getAll(){
		return ResponseEntity.ok().body(usuarioservice.findAll());
	}
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
		var obj = usuarioservice.createUser(userdto);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userdto){
		var obj = usuarioservice.updateUser(userdto);
		return ResponseEntity.ok().body(obj);	
	}
	
	@DeleteMapping(value= "/{Id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "Id")Integer id){	
		usuarioservice.deleteUser(id);
		return ResponseEntity.noContent().build();

	}
	
	
}
