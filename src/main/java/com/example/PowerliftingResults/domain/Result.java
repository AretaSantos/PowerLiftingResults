package com.example.PowerliftingResults.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	private String lift;
	private String kg;
	private String RPE;
	private String date;
	private String reps;
	
	public Result() {
		
	}
	
	public Result(String lift, String kg, String rPE, String date, String reps) {
	
		this.lift = lift;
		this.kg = kg;
		RPE = rPE;
		this.date = date;
		this.reps = reps;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Result [id=" + id + ", lift=" + lift + ", kg=" + kg + ", RPE=" + RPE + ", date=" + date + ", reps="
				+ reps + "]";
	}
	
	

}
