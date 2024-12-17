package org.example.quiz.controller;

import org.example.quiz.dto.QuestionDTO;
import org.example.quiz.dto.QuizSummaryDTO;
import org.example.quiz.entity.Question;
import org.example.quiz.entity.QuizSession;
import org.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public String startSession() {
        quizService.startNewSession(1L); // Fixed user ID for simplicity
        return "Quiz session started!";
    }

    @GetMapping("/question")
    public ResponseEntity<QuestionDTO> getQuestion() {
        QuestionDTO question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long questionId, @RequestParam String option) {
        quizService.submitAnswer(1L, questionId, option);
        return "Answer submitted!";
    }

    @GetMapping("/summary")
    public ResponseEntity<QuizSummaryDTO> getSummary(@RequestParam Long userId) {
        QuizSummaryDTO summary = quizService.getSummary(userId);
        return ResponseEntity.ok(summary);
    }

}
