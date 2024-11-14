package com.tzsolutions.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tzsolutions.quiz.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    // Egyedi lekérdezésekhez itt adhatunk meg metódusokat
}
