package com.quiz.services;

import com.quiz.entities.Quiz;
import com.quiz.repository.Repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Imp implements QuizService {

    private Repo repo;

    private QuestionClient questionClient;

    public Imp(Repo repo, QuestionClient questionClient) {
        this.repo = repo;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return repo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = repo.findAll();

        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = repo.findById(id).orElseThrow(()->new RuntimeException("Quiz not found."));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
