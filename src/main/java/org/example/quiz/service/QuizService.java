package org.example.quiz.service;

import org.example.quiz.dto.QuestionDTO;
import org.example.quiz.dto.QuizSummaryDTO;
import org.example.quiz.entity.Question;
import org.example.quiz.entity.QuizSession;
import org.example.quiz.repository.QuestionRepository;
import org.example.quiz.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    // Start a new session
    public QuizSession startNewSession(Long userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        session.setTotalQuestionsAnswered(0);
        session.setCorrectAnswers(0);
        return quizSessionRepository.save(session);
    }

    // Get a random question (DTO format)
    public QuestionDTO getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new IllegalStateException("No questions available");
        }

        // Randomly pick a question
        Question question = questions.get(new Random().nextInt(questions.size()));

        // Convert to DTO (hide correct answer)
        return new QuestionDTO(
                question.getId(),
                question.getQuestionText(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD()
        );
    }

    // Submit an answer
    public void submitAnswer(Long userId, Long questionId, String selectedOption) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        QuizSession session = quizSessionRepository.findByUserId(userId);
        if (session == null) throw new RuntimeException("Session not started");

        session.setTotalQuestionsAnswered(session.getTotalQuestionsAnswered() + 1);

        boolean isCorrect = question.getCorrectOption().equalsIgnoreCase(selectedOption);
        session.getAnswers().put(questionId, isCorrect);

        if (isCorrect) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        }

        quizSessionRepository.save(session);
    }

    public QuizSummaryDTO getSummary(Long userId) {
        QuizSession session = quizSessionRepository.findByUserId(userId);
        if (session == null) {
            throw new IllegalArgumentException("No quiz session found for user ID: " + userId);
        }

        long totalQuestions = questionRepository.count();

        // Fetch detailed question status
        Map<Long, String> questionResults = new HashMap<>();
        for (Map.Entry<Long, Boolean> entry : session.getAnswers().entrySet()) {
            questionResults.put(entry.getKey(), entry.getValue() ? "Correct" : "Incorrect");
        }

        return new QuizSummaryDTO(
                totalQuestions,
                session.getTotalQuestionsAnswered(),
                session.getCorrectAnswers(),
                session.getCorrectAnswerPercentage(),
                questionResults
        );
    }

}
