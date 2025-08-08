package com.quizapplication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	
	@GetMapping("/checksessionstatus")
	public ResponseEntity<String> checksessionstatus(HttpSession session) {
	    Object participant = session.getAttribute("firsttimecreated");
	    System.out.println(session.getAttribute("username"));
	    if (participant == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
	    }
	    else if (participant.toString().equals("true")){
	    	session.setAttribute("firsttimecreated", "false");
	    	return ResponseEntity.ok("session is found but it is created first time");
	    }
	    else {
	        return ResponseEntity.ok("Session active");
	    }
	}
	
	@GetMapping("/getquizid")
	public Integer getquizid(HttpSession session) {
		Object quizid = session.getAttribute("quizid");
		Integer nullquizid =0;
		if(quizid instanceof Integer && quizid!=null) {
			nullquizid = (Integer)quizid;
			return nullquizid;
		}
		return nullquizid;	
	}
	
	@GetMapping("/getquizarray")
	public Integer[] getquizarray(HttpSession session) {
		Object quizarr = session.getAttribute("quizarray");
		Integer[] quizarray=null;
		
		Integer[] basicarray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		if(quizarr instanceof Integer[] && quizarr !=null) {
			quizarray = (Integer[])quizarr;
			return quizarray;
		}
		return basicarray;
	 
		
	}
	@PostMapping("/submitquizid")
	public String savethequizid(@RequestBody Map<String,Integer> quizid,HttpSession session) {
		Integer quiznumber = quizid.get("id");
		session.setAttribute("quizid", quiznumber);
		return "the quiz id successfully save";
	}
	@PostMapping("/submitquizarray")
	public String savethequizarray(@RequestBody Integer[] quizarray,HttpSession session) {
		session.setAttribute("quizarray", quizarray);
		
		return "the quiz array successfully save";
	}
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
	    session.invalidate();
	    return ResponseEntity.ok("Logged out");
	}


}
