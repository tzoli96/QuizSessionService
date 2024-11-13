package com.tzsolutions.quiz.controller;

import com.tzsolutions.quiz.model.Session;
import com.tzsolutions.quiz.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/start")
    public ResponseEntity<SessionResponse> startSession() {
        Session session = sessionService.startNewSession();
        return ResponseEntity.ok(new SessionResponse(session.getSessionId()));
    }

    private static class SessionResponse {
        private final String sessionId;

        public SessionResponse(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}
