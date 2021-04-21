package com.example.PowerliftingResults.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long resultid;
	private String lift;
	private float kg;
	private String RPE;
	private String reps;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "id")
		private User user;
	
	public Result() {
		
	}
	
	public Result(String lift, float kg, String rPE, String reps, LocalDate date, User user) {
		super();
		this.lift = lift;
		this.kg = kg;
		RPE = rPE;
		this.reps = reps;
		this.date = date;
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

	public float getKg() {
		return kg;
	}

	public void setKg(float kg) {
		this.kg = kg;
	}

	public String getRPE() {
		return RPE;
	}

	public void setRPE(String rPE) {
		RPE = rPE;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Result [resultid=" + resultid + ", lift=" + lift + ", kg=" + kg + ", RPE=" + RPE + ", reps=" + reps
				+ ", date=" + date + ", user=" + user + "]";
	}



	
	

}
