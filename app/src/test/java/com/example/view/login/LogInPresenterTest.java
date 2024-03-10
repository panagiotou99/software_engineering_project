package com.example.view.login;
import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.domain.Student;
import com.example.domain.Teacher;
import com.example.domain.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogInPresenterTest {

    private Initializer tempData;
    private LogInPresenter presenter;
    private LogInViewStub view;

    @Before
    public void setUp() throws Exception{
        tempData = new MemoryInitializer();
        tempData.prepareData();
        view = new LogInViewStub();
    }

    @Test
    public void validLoginTest(){
        presenter = new LogInPresenter(view, tempData.getUserDAO());
        //Student login
        view.setEmail("panagiotis@aueb.gr");
        view.setPassword("Panagiotis1");
        User user = presenter.onLogIn();
        Assert.assertTrue(user instanceof Student);

        //Teacher login
        view.setEmail("zafeiris@aueb.gr");
        view.setPassword("Zafeiris1");
        user = presenter.onLogIn();
        Assert.assertTrue(user instanceof Teacher);
    }

    @Test
    public void emptyLoginTest(){
        presenter = new LogInPresenter(view, tempData.getUserDAO());
        Assert.assertNull(presenter.onLogIn());
        Assert.assertEquals(view.getAlertTitle(), "Κενά στοιχεία.");
        Assert.assertEquals(view.getErrorMessage(), "To email και ο κωδικός πρόσβασης δεν γίνεται να είναι κενά.");
    }

    @Test
    public void invalidUserTest(){
        presenter = new LogInPresenter(view, tempData.getUserDAO());
        view.setEmail("giorgos@aueb.gr");
        view.setPassword("Giorgos1");
        Assert.assertNull(presenter.onLogIn());
        Assert.assertEquals(view.getAlertTitle(), "Δε βρέθηκε χρήστης.");
        Assert.assertEquals(view.getErrorMessage(), "Δε βρέθηκε χρήστης με αυτό το συνδιασμό email και κωδικού. Δοκιμάστε κάτι άλλο.");
    }

    @Test
    public void invalidEmailTest(){
        presenter = new LogInPresenter(view, tempData.getUserDAO());
        view.setEmail("giorgosauebgr");
        view.setPassword("Giorgos1");
        Assert.assertNull(presenter.onLogIn());
        Assert.assertEquals(view.getAlertTitle(), "Μη έγκυρη διεύθυνση email.");
        Assert.assertEquals(view.getErrorMessage(), "Η διεύθυνση email δεν αντιστοιχεί σε πραγματική διεύθυνση ηλετρονικού ταχυδρομείου.");
    }

    @Test
    public void signupButtonTest(){
        presenter = new LogInPresenter(view, tempData.getUserDAO());
        presenter.onSignUp();
        Assert.assertEquals(view.getEtc(),"signup");
    }

    @Test
    public void remindButtonTest(){
        presenter = new LogInPresenter(view, tempData.getUserDAO());
        presenter.onRemindPassword();
        Assert.assertEquals(view.getEtc(),"remind");
    }
}