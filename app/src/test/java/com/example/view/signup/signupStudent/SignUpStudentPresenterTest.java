package com.example.view.signup.signupStudent;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.domain.Student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SignUpStudentPresenterTest {


    private Initializer tempData;
    private SignUpStudentPresenter presenter;
    private SignUpStudentStub view;


    @Before
    public void setUp() throws Exception {
        tempData = new MemoryInitializer();
        tempData.prepareData();
        view = new SignUpStudentStub();
    }

    @Test
    public void validSignUpStudentTest(){
        presenter = new SignUpStudentPresenter(view, tempData.getUserDAO());
        //Student signup
        view.setEmail("p3180139@aueb.gr");
        view.setPassword("Alexis2021");
        view.setAge("10");
        view.setfirstName("Panagiotis");
        view.setLastName("Panagiotou");
        view.setGrade("2");
        view.setIban("GR7701720110005011000009849");
        Student student = presenter.onSignUp();
        Assert.assertEquals(view.getEtc(),"Valid Registration");
        Assert.assertTrue(student !=null);
    }

    @Test
    public void invalidEmtpyFieldsTest(){
        presenter = new SignUpStudentPresenter(view, tempData.getUserDAO());
        //Student signup
        view.setEmail("p3180139@aueb.gr");
        view.setPassword("Alexis2021");
        Student student = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Συμπλήρωσε όλα τα στοιχεία της φόρμας.");
        Assert.assertEquals(view.getErrorMessage(),"Όλα τα πεδία είναι υποχρεωτικά.");
    }

    @Test
    public void invalidWrongPasswordTest(){
        presenter = new SignUpStudentPresenter(view, tempData.getUserDAO());
        //Student signup
        view.setEmail("p3180139@aueb.gr");
        view.setPassword("lol");
        view.setAge("10");
        view.setfirstName("Panagiotis");
        view.setLastName("Panagiotou");
        view.setGrade("2");
        view.setIban("GR7701720110005011000009849");
        Student student = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Άλλαξε τον κωδικό σου και ξαναπροσπάθησε.");
        Assert.assertEquals(view.getErrorMessage(),"O κωδικός πρέπει να έχει λατινικά, 1 ψηφίο,1 κεφαλαίο και 1 μικρό γράμμα.");
    }

    @Test
    public void invalidAgeTest(){
        presenter = new SignUpStudentPresenter(view, tempData.getUserDAO());
        view.setEmail("p3180139@aueb.gr");
        view.setPassword("Panagiotis1");
        view.setAge("3");
        view.setfirstName("Panagiotis");
        view.setLastName("Panagiotou");
        view.setGrade("2");
        view.setIban("GR7701720110005011000009849");
        Student student = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Πρέπει να είσαι τουλ. 6 ετών για να κάνεις εγγραφή.");
        Assert.assertEquals(view.getErrorMessage(),"Δεν επιτρέπονται χρήστες κάτω των 6 ετών να χρησιμοποιούν την εφαρμογή αυτή.");
    }

    @Test
    public void invalidGradeTest(){
        presenter = new SignUpStudentPresenter(view, tempData.getUserDAO());
        view.setEmail("p3180139@aueb.gr");
        view.setPassword("Panagiotis1");
        view.setAge("7");
        view.setfirstName("Panagiotis");
        view.setLastName("Panagiotou");
        view.setGrade("15");
        view.setIban("GR7701720110005011000009849");
        Student student = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"1η Δημοτικού = 1, .... 3η Λυκείου = 12");
        Assert.assertEquals(view.getErrorMessage(),"Γράψε τον αριθμό που αντιστοιχεί με την τάξη σου. Το 1 αντιστοιχεί στην 1η Δημοτικού. Το 12 στην 3η Λυκείου.");
    }

    @Test
    public void invalidIbanTest(){
        presenter = new SignUpStudentPresenter(view, tempData.getUserDAO());
        view.setEmail("p3180139@aueb.gr");
        view.setPassword("Panagiotis1");
        view.setAge("7");
        view.setfirstName("Panagiotis");
        view.setLastName("Panagiotou");
        view.setGrade("6");
        view.setIban("sadasdsada");
        Student student = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"To IBAN δεν είναι έγκυρο.");
        Assert.assertEquals(view.getErrorMessage(),"Άλλαξε το IBAN σου και ξανα προσπάθησε.");
    }

    @Test
    public void invalidEmailTest(){
        presenter = new SignUpStudentPresenter(view, tempData.getUserDAO());
        view.setEmail("aueb.gr");
        view.setPassword("Panagiotis1");
        view.setAge("7");
        view.setfirstName("Panagiotis");
        view.setLastName("Panagiotou");
        view.setGrade("6");
        view.setIban("sadasdsada");
        Student student = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Μη έγκυρη διεύθυνση email.");
        Assert.assertEquals(view.getErrorMessage(),"Η διεύθυνση email δεν αντιστοιχεί σε πραγματική διεύθυνση ηλετρονικού ταχυδρομείου.");
    }
}