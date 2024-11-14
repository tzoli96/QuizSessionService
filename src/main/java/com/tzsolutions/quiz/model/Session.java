package com.tzsolutions.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;

    public Session() {
        this.sessionId = UUID.randomUUID().toString();
    }

    public Long getId() {
        return id;
    }

    public String getSessionId() {
        return sessionId;
    }
}
