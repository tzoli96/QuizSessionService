package com.tzsolutions.quiz.repository;

import com.tzsolutions.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
