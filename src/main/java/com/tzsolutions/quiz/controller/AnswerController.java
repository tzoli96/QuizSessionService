package com.tzsolutions.quiz.controller;

import com.tzsolutions.quiz.dto.ApiResponse;
import com.tzsolutions.quiz.service.AnswerService;
import com.tzsolutions.quiz.model.Answer;
import com.tzsolutions.quiz.dto.AnswerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Answer>> createAnswer(@Valid @RequestBody AnswerRequest request) {
        Answer answer = answerService.createAnswer(request);
        ApiResponse<Answer> response = new ApiResponse<>("Sikeres entitás létrehozása", answer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
