package com.quizapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quizapplication.entity.Participant;
import com.quizapplication.service.Participantservices;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Participantservices participantservice;
	
	@GetMapping("")
	public String getMethodName() {
		return "redirect:/loginpage.html";
	}
	
	
	
	@PostMapping("/quiz")
	public String setquizez(@ModelAttribute Participant participant){
		participantservice.addParticipant(participant);
		List<Participant> getallparticipant = participantservice.getallparticipant();
		getallparticipant.forEach(System.out::println); 
		return "redirect:/quizpage.html";	
	}
	
}
