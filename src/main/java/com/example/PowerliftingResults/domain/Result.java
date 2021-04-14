package com.example.PowerliftingResults.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long resultid;
	private String lift;
	private String kg;
	private String RPE;
	private String date;
	private String reps;
	
	@ManyToOne
	@JoinColumn(name = "id")
		private User user;
	
	public Result() {
		
	}
	
	
	public Result(String lift, String kg, String rPE, String date, String reps) {
		super();
	
		this.lift = lift;
		this.kg = kg;
		RPE = rPE;
		this.date = date;
		this.reps = reps;
		this.user = user;
	}


	
	public Long getResultid() {
		return resultid;
	}


	public void setResultid(Long resultid) {
		this.resultid = resultid;
	}


	public String getLift() {
		return lift;
	}
	public void setLift(String lift) {
		this.lift = lift;
	}
	public String getKg() {
		return kg;
	}
	public void setKg(String kg) {
		this.kg = kg;
	}
	public String getRPE() {
		return RPE;
	}
	public void setRPE(String rPE) {
		RPE = rPE;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReps() {
		return reps;
	}
	public void setReps(String reps) {
		this.reps = reps;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Result [resultid=" + resultid + ", lift=" + lift + ", kg=" + kg + ", RPE=" + RPE + ", date=" + date + ", reps="
				+ reps + "]";
	}
	
	

}
