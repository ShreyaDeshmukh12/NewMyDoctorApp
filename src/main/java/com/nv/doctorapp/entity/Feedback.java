package com.nv.doctorapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;

	private String doctorName;
	// private int patientId;
	private String feedbackComment;
	private int rating;

	public Feedback(String doctorName, String feedbackComment, int rating) {
		super();
		this.doctorName = doctorName;
		// this.patientId = patientId;
		this.feedbackComment = feedbackComment;
		this.rating = rating;
	}

}
