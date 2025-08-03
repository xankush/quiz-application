package com.quizapplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapplication.entity.Participant;

public interface Participantdao extends JpaRepository<Participant, Integer>{
	 Optional<Participant> findByParticipantName(String participantName);

}
