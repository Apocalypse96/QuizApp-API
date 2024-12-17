package org.example.quiz.entity;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private int totalQuestionsAnswered;
    private int correctAnswers;

    @ElementCollection
    @CollectionTable(name = "quiz_session_answers", joinColumns = @JoinColumn(name = "session_id"))
    @MapKeyColumn(name = "question_id")
    @Column(name = "is_correct")
    private Map<Long, Boolean> answers = new HashMap<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Map<Long, Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, Boolean> answers) {
        this.answers = answers;
    }

    public double getCorrectAnswerPercentage() {
        return totalQuestionsAnswered == 0 ? 0 : (correctAnswers * 100.0) / totalQuestionsAnswered;
    }
}
