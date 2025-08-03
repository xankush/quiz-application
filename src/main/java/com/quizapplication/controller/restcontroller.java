package com.quizapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizapplication.DTO.AnswerDto;
import com.quizapplication.Exception.QuestionNotFoundException;
import com.quizapplication.dao.Answerdao;
import com.quizapplication.entity.Answer;
import com.quizapplication.entity.Participant;
import com.quizapplication.entity.Quiz;
import com.quizapplication.service.Participantservices;
import com.quizapplication.service.quizservices;

import jakarta.servlet.http.HttpSession;


@RestController
public class restcontroller {
	@Autowired
	quizservices quizservice;
	
	@Autowired
	Answerdao answerdao;
	
	@Autowired
	Participantservices participantservice;
	
	
	@GetMapping("/getquestion/{id}")
	public ResponseEntity<Quiz> getquestion(@PathVariable int id) throws QuestionNotFoundException {
		
		return ResponseEntity.ok(quizservice.getquestion(id));
		
		
		
	}
	@PostMapping("/saveanswer")
	public ResponseEntity<Answer> postMethodName(@RequestBody AnswerDto answerdto,HttpSession session) throws NumberFormatException, QuestionNotFoundException {
		//TODO: process POST request
		
		Quiz question = quizservice.getquestion(Integer.parseInt(answerdto.getQuizid()));
		Participant participantByName = participantservice.getParticipantByName(session.getAttribute("username").toString());
		String ans= answerdto.getAnswer();
		Answer answer = new Answer();
		
		answer.setParticipant(participantByName);
		answer.setQuiz(question);
		answer.setSelectedanswer(ans);
		
		
		answerdao.save(answer);
		
		return ResponseEntity.ok(answer);
	}
	

}
