package com.quizapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapplication.entity.Quiz;

public interface Quizdao extends JpaRepository<Quiz, Integer> {
	
}
