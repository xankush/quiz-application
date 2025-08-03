package com.quizapplication.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizId;

    private String quizText;

    private String correctAnswer;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<Option> options = new ArrayList<>();

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizText() {
		return quizText;
	}

	public void setQuizText(String quizText) {
		this.quizText = quizText;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Quiz(int quizId, String quizText, String correctAnswer, List<Option> options) {
		super();
		this.quizId = quizId;
		this.quizText = quizText;
		this.correctAnswer = correctAnswer;
		this.options = options;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    
}