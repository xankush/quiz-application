package com.quizapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapplication.entity.Answer;

public interface Answerdao extends JpaRepository<Answer, Integer> {

}
