package com.quizapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	private int ansid;
	
	private String selectedanswer;
	
	@ManyToOne
	private Quiz quiz;
	
	@ManyToOne
	private Participant participant;

	public int getAnsid() {
		return ansid;
	}

	public void setAnsid(int ansid) {
		this.ansid = ansid;
	}

	public String getSelectedanswer() {
		return selectedanswer;
	}

	public void setSelectedanswer(String selectedanswer) {
		this.selectedanswer = selectedanswer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Answer(int ansid, String selectedanswer, Quiz quiz, Participant participant) {
		super();
		this.ansid = ansid;
		this.selectedanswer = selectedanswer;
		this.quiz = quiz;
		this.participant = participant;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Answer [ansid=" + ansid + ", selectedanswer=" + selectedanswer + ", quiz=" + quiz + ", participant="
				+ participant + "]";
	}
	
	
}
