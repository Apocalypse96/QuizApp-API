package org.example.quiz.dto;

import java.util.Map;

public class QuizSummaryDTO {
    private long totalQuestionsInDB;
    private int totalQuestionsAnswered;
    private int correctAnswers;
    private double correctAnswerPercentage;
    private Map<Long, String> questionResults;

    public QuizSummaryDTO(long totalQuestionsInDB, int totalQuestionsAnswered, int correctAnswers,
                          double correctAnswerPercentage, Map<Long, String> questionResults) {
        this.totalQuestionsInDB = totalQuestionsInDB;
        this.totalQuestionsAnswered = totalQuestionsAnswered;
        this.correctAnswers = correctAnswers;
        this.correctAnswerPercentage = correctAnswerPercentage;
        this.questionResults = questionResults;
    }

    // Getters
    public long getTotalQuestionsInDB() { return totalQuestionsInDB; }
    public int getTotalQuestionsAnswered() { return totalQuestionsAnswered; }
    public int getCorrectAnswers() { return correctAnswers; }
    public double getCorrectAnswerPercentage() { return correctAnswerPercentage; }
    public Map<Long, String> getQuestionResults() { return questionResults; }
}
