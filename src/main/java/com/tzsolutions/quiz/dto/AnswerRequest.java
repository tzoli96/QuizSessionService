package com.tzsolutions.quiz.dto;

import jakarta.validation.constraints.NotNull;

public class AnswerRequest {

    @NotNull(message = "A kérdés ID megadása kötelező.")
    private Long questionId;

    @NotNull(message = "A válasz szövegének megadása kötelező.")
    private String answerText;

    @NotNull(message = "A helyesség jelzése kötelező.")
    private Boolean isCorrect;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
