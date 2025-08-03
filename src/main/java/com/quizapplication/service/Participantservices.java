package com.quizapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapplication.dao.Participantdao;
import com.quizapplication.entity.Participant;

@Service
public class Participantservices {

	@Autowired
	Participantdao participantdao;
	
	public Participant getParticipantByName(String name) {
	    return participantdao.findByParticipantName(name)
	           .orElseThrow(() -> new RuntimeException("Participant not found"));
	}

	
	public void addParticipant(Participant p) {
		participantdao.save(p);
	}
	
	public List<Participant> getallparticipant(){
		return participantdao.findAll();
	}
	
	
	
}
