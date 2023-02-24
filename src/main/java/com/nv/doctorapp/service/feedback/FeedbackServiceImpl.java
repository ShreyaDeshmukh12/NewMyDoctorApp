package com.nv.doctorapp.service.feedback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Feedback;
import com.nv.doctorapp.entity.Patient;
import com.nv.doctorapp.exception.feedback.InvalidDataException;
import com.nv.doctorapp.repository.feedback.IFeedbackRepository;
import com.nv.doctorapp.repository.patient.IPatientRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IFeedbackRepository feedbackRepository;

	@Autowired
	IPatientRepository patientRepository;

	@Override
	public Feedback addFeedback(Feedback feedback) throws Exception {

		if (feedback.getDoctorName().equals("")) {
			throw new InvalidDataException("Doctor Name cannot be null");
		} else
			return feedbackRepository.save(feedback);
	}

	@Override
	public List<Feedback> listOfAllFeedbacks() {

		return feedbackRepository.findAll();
	}

	/*
	 * @Override public List<Feedback> getFeedbackByPatientId(int patientId) throws
	 * NullPointerException {
	 * 
	 * if(patientId == 0) { throw new NullPointerException("Invalid Id"); }
	 * 
	 * 
	 * return feedbackRepository.getFeedbackByPatientId(patientId); }
	 */

	@Override
	public List<Feedback> getFeedbackByDoctorName(String doctorName) {

		return feedbackRepository.getFeedbackByDoctorName(doctorName);
	}

	/*
	 * @Override public Feedback updateFeedbackByPatientId(int feedbackId, int
	 * PatientId) {
	 * 
	 * 
	 * Feedback feedbackFromDB = feedbackRepository.getReferenceById(feedbackId);
	 * //Feedback feedbackFromDB = getFeedbackId(feedbackId); Patient patientFromDB
	 * = patientRepository.getReferenceById(PatientId);
	 * 
	 * if(feedbackFromDB !=null & patientFromDB !=null) { List<Feedback>
	 * allFeedbacks = patientFromDB.getFeedback();
	 * 
	 * if(allFeedbacks!=null && allFeedbacks.isEmpty()==false) {
	 * allFeedbacks.add(feedbackFromDB); patientFromDB.setFeedback(allFeedbacks); }
	 * else { List<Feedback> newFeedbackList = new ArrayList<>();
	 * newFeedbackList.add(feedbackFromDB);
	 * patientFromDB.setFeedback(newFeedbackList);
	 * 
	 * }
	 * 
	 * patientRepository.saveAndFlush(patientFromDB);
	 * feedbackRepository.save(feedbackFromDB); return feedbackFromDB;
	 * 
	 * }
	 * 
	 * 
	 * return null; }
	 */

	@Override
	public Feedback getFeedbackId(int feedbackId) {

		if (feedbackId >= 1) {
			feedbackRepository.getReferenceById(feedbackId);
		}

		return null;
	}

	/*
	 * @Override public Feedback updateFeedback(int feedbackId) {
	 * 
	 * Feedback updatedFeedback = feedbackRepository.getById(feedbackId);
	 * feedbackRepository.save(updatedFeedback); return updatedFeedback; }
	 */

	/*
	 * @Override public void removePatientDetailsByfeedbackComment(String
	 * feedbackComment) {
	 * 
	 * feedbackRepository.deleteAll();
	 * 
	 * }
	 * 
	 */

}
