package org.example.quiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.example.quiz.repository.QuestionRepository;
import org.example.quiz.repository.QuizSessionRepository;
import org.example.quiz.service.QuizService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuizApplicationTests {

    @Autowired(required = false)
    private ApplicationContext context;

    @Autowired(required = false)
    private QuestionRepository questionRepository;

    @Autowired(required = false)
    private QuizSessionRepository quizSessionRepository;

    @Autowired(required = false)
    private QuizService quizService;

    @Test
    void contextLoads() {
        System.out.println("Attempting to load application context...");
        assertThat(context).isNotNull();
        assertThat(questionRepository).isNotNull();
        assertThat(quizSessionRepository).isNotNull();
        assertThat(quizService).isNotNull();
        System.out.println("Context loaded successfully!");
    }
}