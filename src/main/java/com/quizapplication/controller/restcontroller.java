package com.quizapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quizapplication.Exception.QuestionNotFoundException;
import com.quizapplication.entity.quiz;
import com.quizapplication.service.quizservices;

@RestController
public class restcontroller {
	@Autowired
	quizservices quizservice;
	
	
	@GetMapping("/getquestion/{id}")
	public ResponseEntity<quiz> getquestion(@PathVariable int id) throws QuestionNotFoundException {
		
		return ResponseEntity.ok(quizservice.getquestion(id));
		
		
		
	}
	

}
