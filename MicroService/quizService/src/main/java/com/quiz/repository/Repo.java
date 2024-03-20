package com.quiz.repository;

import com.quiz.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Quiz, Long> {
}
