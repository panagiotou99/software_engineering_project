package com.example.view.question.addQuestions;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.domain.Question;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AddQuestionsPresenterTest {
    private Initializer tempData;
    private AddQuestionsPresenter presenter;
    private AddQuestionsStub view;

    @Before
    public void setUp() throws Exception {
        tempData = new MemoryInitializer();
        tempData.prepareData();
        view = new AddQuestionsStub();
    }

    @Test
    public void invalidQuestion1(){
        presenter = new AddQuestionsPresenter(view, tempData.getQuestionDAO());
        view.setType(3);
        view.setDifficulty(1);
        view.setDescription("Test");
        view.setCorrectAnswer("Hey");
        view.setFalseAnswer1("Hey");
        view.setFalserAnswer2("Lol");
        view.setFalseAnswer3("Hi");
        Question newQuestion = presenter.processQuestionRequest();
        Assert.assertTrue(newQuestion == null);
    }

    @Test
    public void invalidQuestion2(){
        presenter = new AddQuestionsPresenter(view, tempData.getQuestionDAO());
        view.setType(3);
        view.setDifficulty(2);
        view.setDescription("Test");
        view.setCorrectAnswer("Hey");
        view.setFalseAnswer1("Hello!");
        view.setFalseAnswer3("Hi");
        Question newQuestion = presenter.processQuestionRequest();
        Assert.assertTrue(newQuestion == null);
    }

    @Test
    public void invalidQuestion3(){
        presenter = new AddQuestionsPresenter(view, tempData.getQuestionDAO());
        view.setType(3);
        view.setDifficulty(3);
        view.setCorrectAnswer("Hey");
        view.setFalseAnswer1("Hey");
        view.setFalserAnswer2("Lol");
        view.setFalseAnswer3("Hi");
        Question newQuestion = presenter.processQuestionRequest();
        Assert.assertTrue(newQuestion == null);
    }

    @Test
    public void validQuestion1(){
        presenter = new AddQuestionsPresenter(view, tempData.getQuestionDAO());
        view.setType(3);
        view.setDifficulty(1);
        view.setDescription("1+1=?");
        view.setCorrectAnswer("2");
        view.setFalseAnswer1("11");
        view.setFalserAnswer2("3");
        view.setFalseAnswer3("4");
        Question newQuestion = presenter.processQuestionRequest();
        Assert.assertTrue(newQuestion!=null);
    }

    @Test
    public void validQuestion2(){
        presenter = new AddQuestionsPresenter(view, tempData.getQuestionDAO());
        view.setType(1);
        view.setDifficulty(1);
        view.setDescription("1+1=2");
        Question newQuestion = presenter.processQuestionRequest();
        Assert.assertTrue(newQuestion!=null);
    }

    @Test
    public void validQuestion3(){
        presenter = new AddQuestionsPresenter(view, tempData.getQuestionDAO());
        view.setType(2);
        view.setDifficulty(1);
        view.setDescription("1+1=11");
        Question newQuestion = presenter.processQuestionRequest();
        Assert.assertTrue(newQuestion!=null);
    }
}