package org.example.quiz.repository;

import org.example.quiz.entity.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
    QuizSession findByUserId(Long userId);
}