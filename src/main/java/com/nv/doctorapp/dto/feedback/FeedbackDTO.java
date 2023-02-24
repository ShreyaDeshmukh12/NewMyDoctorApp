package com.nv.doctorapp.dto.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {

              private int feedbackId;
              private String doctorName;
              private int rating;
              private String feedbackComment;
}
