CREATE TABLE questions (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           question_text TEXT,
                           html_content TEXT,
                           image_url VARCHAR(255),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE answers (
                         id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         question_id BIGINT,
                         answer_text VARCHAR(255),
                         is_correct BOOLEAN,
                         FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE
);

CREATE TABLE user_answers (
                              id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                              session_id VARCHAR(36),
                              user_id BIGINT,
                              question_id BIGINT,
                              selected_answer_id BIGINT,
                              is_correct BOOLEAN,
                              FOREIGN KEY (question_id) REFERENCES questions(id),
                              FOREIGN KEY (selected_answer_id) REFERENCES answers(id)
);
