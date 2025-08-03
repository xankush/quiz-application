package com.quizapplication.entity;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Participant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int participantid;
	
	String participantName;
	
	String course ;
	
	String year;
	
	@OneToMany
	List<Answer> answer; 
	
	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public String getParticipantname() {
		return participantName;
	}

	public void setParticipantname(String participantname) {
		this.participantName = participantname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Participant [participantid=" + participantid + ", participantname=" + participantName + ", course="
				+ course + ", year=" + year + ", answer=" + answer + "]";
	}

	public Participant(int participantid, String participantname, String course, String year, List<Answer> answer) {
		super();
		this.participantid = participantid;
		this.participantName = participantname;
		this.course = course;
		this.year = year;
		this.answer = answer;
	}
	
	
	

}
