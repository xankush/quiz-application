package com.quizapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quizapplication.entity.Participant;
import com.quizapplication.service.Participantservices;

import jakarta.servlet.http.HttpSession;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Participantservices participantservice;
	
	@GetMapping("")
	public String getMethodName() {
		return "redirect:/loginpage.html";
	}
	
	
	
	@PostMapping("/quiz")
	public String setquizez(@RequestBody Participant participant,HttpSession session){
		System.out.println("participant from js"+participant);
		participantservice.addParticipant(participant);
		session.setAttribute("username", participant.getParticipantname());
		session.setAttribute("firsttimecreated","true");
		List<Participant> getallparticipant = participantservice.getallparticipant();
		getallparticipant.forEach(System.out::println); 
		return "redirect:/quizpage";	
	}
	
	@GetMapping("/quizpage")
	public String getquizpage() {
		return "redirect:/quizpage.html";
	}
	
}
