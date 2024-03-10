package com.example.dao.daoMemory;

import com.example.dao.daoStub.QuestionDAO;
import com.example.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAOMemory implements QuestionDAO {
    protected static ArrayList<Question> questionsList = new ArrayList<>();
    private static int autoIncrementId = 0;

    public QuestionDAOMemory(){

    }

    public Question find(String code){
        for (Question question : questionsList) {
            if (question.getID().equals(code)) {
                return question;
            }
        }
        return null;
    }

    public void save(Question question){
        delete(question);
        question.setID((String.valueOf(nextId())));
        questionsList.add(question);
    }


    public void delete(Question question) {
        questionsList.remove(question);
    }

    public List<Question> findAll() {
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.addAll(questionsList);
        return questions;
    }

    public int nextId(){
        autoIncrementId++;
        return autoIncrementId;
    }
}
