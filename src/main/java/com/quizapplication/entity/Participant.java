package com.quizapplication.entity;

public class Participant {
	String participantname;
	
	String course ;
	
	String year;

	public String getParticipantname() {
		return participantname;
	}

	public void setParticipantname(String participantname) {
		this.participantname = participantname;
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

	public Participant(String participantname, String course, String year) {
		super();
		this.participantname = participantname;
		this.course = course;
		this.year = year;
	}

	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Participant [participantname=" + participantname + ", course=" + course + ", year=" + year + "]";
	}
	
	
	

}
