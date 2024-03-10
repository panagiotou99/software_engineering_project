package com.example.dao.daoMemory;

import com.example.dao.daoStub.CompletedQuizDAO;
import com.example.domain.CompletedQuiz;

import java.util.ArrayList;
import java.util.List;

public class CompletedQuizDAOMemory implements CompletedQuizDAO {
    protected static ArrayList<CompletedQuiz> completedQuizList = new ArrayList<>();
    private static int autoIncrementId = 0;

    @Override
    public CompletedQuiz find(String quizCode){
        for (CompletedQuiz quiz : completedQuizList) {
            if (quiz.getId().equals(quizCode)) {
                return quiz;
            }
        }
        return null;
    }

    @Override
    public void save(CompletedQuiz quiz){
        delete(quiz);
        quiz.setId((String.valueOf(nextId())));
        completedQuizList.add(quiz);
    }

    @Override
    public void delete(CompletedQuiz quiz){
        completedQuizList.remove(quiz);
    }

    @Override
    public List<CompletedQuiz> findAll(){
        ArrayList<CompletedQuiz> completedQuizes = new ArrayList<CompletedQuiz>();
        completedQuizes.addAll(completedQuizList);
        return completedQuizes;
    }

    public int nextId(){
        autoIncrementId++;
        return autoIncrementId;
    }
}
