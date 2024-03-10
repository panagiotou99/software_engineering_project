package com.example.dao.daoMemory;
import com.example.dao.daoStub.QuizDAO;
import com.example.domain.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizDAOMemory implements QuizDAO {
    protected static ArrayList<Quiz> quizList = new ArrayList<>();

    public Quiz find(String quizCode) {
        for (Quiz q : quizList) {
            if (q.getQuizCode().equals(quizCode))
                return q;
        }
        return null;
    }

    public void save(Quiz quiz) {
        delete(quiz);
        quizList.add(quiz);
    }

    public void delete(Quiz quiz){
        quizList.remove(quiz);
    }

    public List<Quiz> findAll() {
        return new ArrayList<>(quizList);
    }
}
