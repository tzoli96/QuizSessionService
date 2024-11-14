package com.tzsolutions.quiz.service;

import com.tzsolutions.quiz.dto.AnswerRequest;
import com.tzsolutions.quiz.model.Answer;
import com.tzsolutions.quiz.repository.AnswerRepository;
import com.tzsolutions.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public Answer createAnswer(AnswerRequest request) {
        if (!questionRepository.existsById(request.getQuestionId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A megadott kérdés nem található.");
        }

        Answer answer = new Answer();
        answer.setQuestionId(request.getQuestionId());
        answer.setAnswerText(request.getAnswerText());
        answer.setIsCorrect(request.getIsCorrect());
        return answerRepository.save(answer);
    }
}
