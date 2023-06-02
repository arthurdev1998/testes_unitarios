package com.arthur.testes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.arthur.testes.services.DbServices;

@Configuration
@Profile("testes")
public class LocalConfig {
	@Autowired
	private DbServices dbservice;
	
	public void instanciaDB()throws Exception {
		this.dbservice.instanciaDB();
		
	}

}
