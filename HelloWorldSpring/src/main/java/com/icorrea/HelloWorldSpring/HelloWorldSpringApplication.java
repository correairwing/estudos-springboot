package com.icorrea.HelloWorldSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringApplication.class, args);
		System.out.println("Primeiro projeto Spring boot");
	}
	
	@GetMapping("/")
	public String init() {
		return (
				"<h1> Hello World Spring boot <h1 />" +
				"<a href=\"create\"> Create <a/><br />" +
				"<a href=\"read\"> Read <a/><br />" +
				"<a href=\"update\"> Update <a/><br />" +
				"<a href=\"delete\"> Delete <a/><br />"
				);
		
	}
	
	@GetMapping("/create")
	public String create() {
		return ("Criação de um registro");
	}
	
	@GetMapping("/read")
	public String read() {
		return ("Leitura de um registro");
	}
	
	@GetMapping("/update")
	public String update() {
		return ("Atualização de um registro");
	}
	
	@GetMapping("/delete")
	public String delete() {
		return ("Exclusão de um registro");
	}
}
