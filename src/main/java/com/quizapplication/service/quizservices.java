package com.quizapplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.quizapplication.Exception.QuestionNotFoundException;
import com.quizapplication.entity.quiz;

@Service
public class quizservices {
	private List<quiz> quizlist = new ArrayList<>(Arrays.asList(new quiz(1,"what is my name","ankush",Arrays.asList("ankush","ayush","riya","himanshu")),
			new quiz(2,"what is my favorite food","aloo paratha",Arrays.asList("aloo paratha","raiyata","rumali roti","ice cream"))
			));
	
	public quiz getquestion(int id) throws QuestionNotFoundException {
		
		for(quiz q1:quizlist) {
			if(q1.getQuizid()==id) {
				return q1;
			}
			
		}
		
		throw new QuestionNotFoundException("invalid or undefined Quizid");
		
	}
	
	
	
}
