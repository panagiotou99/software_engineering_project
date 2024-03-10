package com.example.view.signup.signupTeacher;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.domain.Student;
import com.example.domain.Teacher;
import com.example.view.signup.signupStudent.SignUpStudentPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignUpTeacherPresenterTest {

    private Initializer tempData;
    private SignUpTeacherPresenter presenter;
    private SignUpTeacherStub view;

    @Before
    public void setUp() throws Exception{
        tempData = new MemoryInitializer();
        tempData.prepareData();
        view = new SignUpTeacherStub();
    }

    @Test
    public void validSignUpTeacherTest(){
        presenter = new SignUpTeacherPresenter(view, tempData.getUserDAO());
        //Teacher signup
        view.setEmail("andreas@aueb.gr");
        view.setPassword("Andreas1");
        view.setAge("20");
        view.setfirstName("Andreas");
        view.setLastName("Panagiotou");
        view.setIban("GR7701720110005011000009849");
        view.setBio("Maths");
        view.setProfession("I'm good at teaching.");
        view.setSsn("123456789");
        Teacher teacher = presenter.onSignUp();
        Assert.assertEquals(view.getEtc(),"Valid Registration");
        Assert.assertTrue(teacher !=null);
    }

    @Test
    public void invalidEmtpyFieldsTest(){
        presenter = new SignUpTeacherPresenter(view, tempData.getUserDAO());
        //Student signup
        view.setEmail("andreas@aueb.gr");
        view.setPassword("Andreas1");
        Teacher teacher = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Συμπλήρωσε όλα τα στοιχεία της φόρμας.");
        Assert.assertEquals(view.getErrorMessage(),"Όλα τα πεδία είναι υποχρεωτικά.");
    }

    @Test
    public void invalidWrongPasswordTest(){
        presenter = new SignUpTeacherPresenter(view, tempData.getUserDAO());
        //Student signup
        view.setEmail("p3180139@aueb.gr");
        view.setPassword("lol");
        view.setAge("19");
        view.setfirstName("Panagiotis");
        view.setLastName("Panagiotou");
        view.setSsn("123456789");
        view.setProfession("Maths");
        view.setBio("I'm good at maths");
        view.setIban("GR7701720110005011000009849");
        Teacher teacher = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Άλλαξε τον κωδικό σου και ξαναπροσπάθησε.");
        Assert.assertEquals(view.getErrorMessage(),"O κωδικός πρέπει να έχει λατινικά, 1 ψηφίο,1 κεφαλαίο και 1 μικρό γράμμα.");
    }

    @Test
    public void invalidAgeTest(){
        presenter = new SignUpTeacherPresenter(view, tempData.getUserDAO());
        view.setEmail("andreas@aueb.gr");
        view.setPassword("Andreas1");
        view.setAge("15");
        view.setfirstName("Andreas");
        view.setLastName("Panagiotou");
        view.setIban("GR7701720110005011000009849");
        view.setBio("Maths");
        view.setProfession("I'm good at teaching.");
        view.setSsn("123456789");
        Teacher teacher = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Πρέπει να είσαι τουλ. 18 ετών για να κάνεις εγγραφή.");
        Assert.assertEquals(view.getErrorMessage(),"Για να έχεις την ιδιότητα του καθηγητή πρέπει να είσαι τουλάχιστον ενήλικας.");
    }

    @Test
    public void invalidIbanTest(){
        presenter = new SignUpTeacherPresenter(view, tempData.getUserDAO());
        view.setEmail("andreas@aueb.gr");
        view.setPassword("Andreas1");
        view.setAge("20");
        view.setfirstName("Andreas");
        view.setLastName("Panagiotou");
        view.setIban("rfefrf");
        view.setBio("Maths");
        view.setProfession("I'm good at teaching.");
        view.setSsn("123456789");
        Teacher teacher = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"To IBAN δεν είναι έγκυρο.");
        Assert.assertEquals(view.getErrorMessage(),"Άλλαξε το IBAN σου και ξανα προσπάθησε.");
    }

    @Test
    public void invalidEmailTest(){
        presenter = new SignUpTeacherPresenter(view, tempData.getUserDAO());
        view.setEmail("andreasaueb.gr");
        view.setPassword("Andreas1");
        view.setAge("20");
        view.setfirstName("Andreas");
        view.setLastName("Panagiotou");
        view.setIban("GR7701720110005011000009849");
        view.setBio("Maths");
        view.setProfession("I'm good at teaching.");
        view.setSsn("123456789");
        Teacher teacher = presenter.onSignUp();
        Assert.assertEquals(view.getAlertTitle(),"Μη έγκυρη διεύθυνση email.");
        Assert.assertEquals(view.getErrorMessage(),"Η διεύθυνση email δεν αντιστοιχεί σε πραγματική διεύθυνση ηλετρονικού ταχυδρομείου");
    }
}