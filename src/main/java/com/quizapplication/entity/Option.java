package com.quizapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz_option") 
public class Option {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int optionId;

	    private String optionText;

	    @ManyToOne
	    @JoinColumn(name = "quiz_id") // foreign key column
	    @JsonBackReference
	    private Quiz quiz;
	    
		public int getOptionId() {
			return optionId;
		}

		public void setOptionId(int optionId) {
			this.optionId = optionId;
		}

		public String getOptionText() {
			return optionText;
		}

		public void setOptionText(String optionText) {
			this.optionText = optionText;
		}

		public Quiz getQuiz() {
			return quiz;
		}

		public void setQuiz(Quiz quiz) {
			this.quiz = quiz;
		}

		public Option(int optionId, String optionText, com.quizapplication.entity.Quiz quiz) {
			super();
			this.optionId = optionId;
			this.optionText = optionText;
			this.quiz = quiz;
		}

		public Option() {
			super();
			// TODO Auto-generated constructor stub
		}
		

	    

	
	
}
