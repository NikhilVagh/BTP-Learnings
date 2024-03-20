package com.question.service;

import com.question.entities.Question;
import com.question.repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionImp implements  QuestionService {

    private QuestionRepo questionRepo;

    public QuestionImp(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question not found."));
    }

    @Override
    public List<Question> getQuestionByQuizId(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
