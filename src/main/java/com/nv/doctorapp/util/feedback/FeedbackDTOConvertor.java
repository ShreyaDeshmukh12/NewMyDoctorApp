package com.nv.doctorapp.util.feedback;

import org.springframework.stereotype.Component;

import com.nv.doctorapp.dto.feedback.FeedbackDTO;
import com.nv.doctorapp.entity.Feedback;

@Component
public class FeedbackDTOConvertor {

              
              public FeedbackDTO convertTo(Feedback feedback) {
                             
                             return new FeedbackDTO(feedback.getFeedbackId(),feedback.getDoctorName(), feedback.getRating(),feedback.getFeedbackComment());
                             
              }
}
