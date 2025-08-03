package com.quizapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapplication.Exception.QuestionNotFoundException;
import com.quizapplication.dao.Quizdao;
import com.quizapplication.entity.Quiz;

@Service
public class quizservices {
	@Autowired
	Quizdao quizdao;
	
	public Quiz getquestion(int id) throws QuestionNotFoundException {
		
		
		for(Quiz q1:quizdao.findAll()) {
			if(q1.getQuizId()==id) {
				return q1;
			}
			
		}
		
		throw new QuestionNotFoundException("invalid or undefined Quizid");
		
	}
	
	
	
}
