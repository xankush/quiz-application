package com.quizapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.quizapplication.entity.Participant;

@Service
public class Participantservices {

	private final List<Participant> users = new ArrayList<>() ;
	
	
	public void addParticipant(Participant p) {
		this.users.add(p);
	}
	
	public List<Participant> getallparticipant(){
		return this.users;
	}
	
	
	
}
