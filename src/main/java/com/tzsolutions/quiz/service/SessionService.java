package com.tzsolutions.quiz.service;

import com.tzsolutions.quiz.model.Session;
import com.tzsolutions.quiz.repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session startNewSession() {
        Session session = new Session();
        return sessionRepository.save(session);
    }
}
