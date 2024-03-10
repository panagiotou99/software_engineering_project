package com.example.dao;

import com.example.dao.daoMemory.CompletedQuizDAOMemory;
import com.example.dao.daoMemory.CourseDAOMemory;
import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoMemory.QuestionDAOMemory;
import com.example.dao.daoMemory.QuizDAOMemory;
import com.example.dao.daoMemory.UserDAOMemory;
import com.example.dao.daoStub.CompletedQuizDAO;
import com.example.dao.daoStub.CourseDAO;
import com.example.dao.daoStub.Initializer;
import com.example.dao.daoStub.QuestionDAO;
import com.example.dao.daoStub.QuizDAO;
import com.example.dao.daoStub.UserDAO;
import com.example.domain.CompletedQuiz;
import com.example.domain.Course;
import com.example.domain.Question;
import com.example.domain.Quiz;
import com.example.domain.Teacher;
import com.example.domain.User;
import com.example.util.SchoolCourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DAOTest {

    private Initializer initializer;
    private UserDAO userDAO;
    private CourseDAO courseDAO;
    private QuestionDAO questionDAO;
    private QuizDAO quizDAO;
    private CompletedQuizDAO completedquizDAO;
    private Question question;
    private Teacher teacher4;
    private Course course4;

    @Before
    public void setUp() throws Exception {
        initializer = new MemoryInitializer();
        initializer.prepareData();
        userDAO = new UserDAOMemory();
        courseDAO = new CourseDAOMemory();
        quizDAO = new QuizDAOMemory();
        questionDAO = new QuestionDAOMemory();
        completedquizDAO = new CompletedQuizDAOMemory();
        teacher4 = new Teacher("Alexandros", "Alexandrou", 50, "alexandros@aueb.gr", "GRXYXXXXXXXXXXXXXXXXXXXXXXM", "Alexandros1", "Languages", "I'm good at languages", 192537465);
        course4 = new Course("LANGUAGES", new SchoolCourse(1,"LANGUAGE"),0.0f, "Easiest greek Ever");
        question= new Question("1+0=?","Easy",teacher4,course4);
        question.setID("test");

    }

    @Test
    public void saveUsertest(){
        Assert.assertEquals(userDAO.findAll().size(),6);
        userDAO.registerUser(teacher4);
        Assert.assertEquals(userDAO.findAll().size(),7);
    }

    @Test
    public void deleteUsertest(){
        User user = userDAO.getUserfromCredentials("olga@aueb.gr","Olga1");
        Assert.assertNotNull(user);
        userDAO.delete(user);
        Assert.assertEquals(userDAO.findAll().size(),5);
    }

    @Test
    public void saveCoursetest(){
        Assert.assertEquals(courseDAO.findAll().size(),3);
        Course course =  new Course("GREEK", new SchoolCourse(1,"GREEK"),0.0f, "Easiest greek Ever");
        courseDAO.save(course);
        Assert.assertEquals(courseDAO.findAll().size(),4);
    }

    @Test
    public void deleteCoursetest(){
        Course course = courseDAO.find("MATHS");
        Assert.assertNotNull(course);
        courseDAO.delete(course);
        Assert.assertEquals(courseDAO.findAll().size(),2);
    }

    @Test
    public void saveQuiztest(){
        Assert.assertEquals(quizDAO.findAll().size(),3);
        Quiz quiz4 = new Quiz("INTRO: LANGUAGE",teacher4,course4);
        quizDAO.save(quiz4);
        Assert.assertEquals(quizDAO.findAll().size(),4);
    }

    @Test
    public void savedeleteQuestiontest() {
        questionDAO.save(question);
        Assert.assertEquals(questionDAO.findAll().size(), 23);
        questionDAO.delete(question);
        Assert.assertEquals(questionDAO.findAll().size(), 22);
    }

    @Test
    public void deleteQuiztest() {
        Quiz quiz = quizDAO.find("INTRO: MATHS");
        Assert.assertNotNull(quiz);
        quizDAO.delete(quiz);
        Assert.assertEquals(quizDAO.findAll().size(),2);
    }

    @Test
    public void testCompletedQuiz(){
        CompletedQuiz completedQuiz = new CompletedQuiz();
        completedquizDAO.save(completedQuiz);
        Assert.assertEquals(completedquizDAO.findAll().size(), 1);
        completedquizDAO.delete(completedquizDAO.find("1"));
        Assert.assertEquals(completedquizDAO.findAll().size(), 0);
    }


}

