package com.quizapplication.entity;

import java.util.List;

public class quiz {
	private int quizid;
	private String quiztext;
	private String correctanswer;

	private List<String> options;

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public String getQuiztext() {
		return quiztext;
	}

	public void setQuiztext(String quiztext) {
		this.quiztext = quiztext;
	}

	public String getCorrectanswer() {
		return correctanswer;
	}

	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public quiz(int quizid, String quiztext, String correctanswer, List<String> options) {
		super();
		this.quizid = quizid;
		this.quiztext = quiztext;
		this.correctanswer = correctanswer;
		if(options.size()==4) {			
			this.options = options;
		}else {
			System.out.println("only five option allowed");
		}
	}

	public quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "quiz [quizid=" + quizid + ", quiztext=" + quiztext + ", correctanswer=" + correctanswer + ", options="
				+ options + "]";
	}



}
