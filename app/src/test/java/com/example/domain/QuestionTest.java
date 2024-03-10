package com.example.domain;

import com.example.util.SchoolCourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    Question question1, question2, question3, question4, question5,questionCopy;
    Answer answer1, answer2, answer3,answer4;
    Teacher teacher1;
    Course course1;

    @Before
    public void setUp() throws Exception {
        teacher1 = new Teacher("Antonis", "Antoniadou", 48, "antant@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXN", "iHateThisGravity","Maths","I'm good at teaching", 123456789);
        course1 = new Course("MATH4DUMMIES", new SchoolCourse(1,"MATHS") ,0.0f, "Easiest Math Ever");

        question1= new Question();
        question1.setDescription("1+2=?");
        question1.setLevel("Easy");
        question1.setTeacher(teacher1);
        question1.setCourse(course1);
        question1.setID("TEST");

        answer1= new Answer("3",true);
        answer2 = new Answer("2", false);
        answer3 = new Answer("6", false);
        answer4 = new Answer("12", false);
        question1.questionInitMulti(answer1,answer2,answer3,answer4);

        question2= new Question("1+0=?","Easy",teacher1,course1);
        question2.questionInitMulti("0","1","2","3");

        question3= new Question("5+1=?","Easy",teacher1,course1);

        question4 = new Question("10+0=100","Easy",teacher1,course1);
        question4.questionInitTF(false);

        question5 = new Question("1+9=10","Easy",teacher1,course1);
        question5.questionInitTF(true);

        questionCopy = new Question("One + Zero = ","Easy",teacher1,course1);
        questionCopy.setPossibleAnswers(question5.getPossibleAnswers());
    }
    @Test
    public void testQuestionGetterSetter() {
        Assert.assertEquals("1+2=?",question1.getDescription());
        Assert.assertEquals("Easy",question1.getLevel());
        Assert.assertEquals(teacher1,question1.getTeacher());
        Assert.assertEquals(course1,question1.getCourse());
        Assert.assertEquals("TEST",question1.getID());
    }

    @Test
    public void testisOkforQuiz() {
        assertTrue(question1.isOKforQuiz());
        assertTrue(question2.isOKforQuiz());
        assertFalse(question3.isOKforQuiz());
        assertTrue(question4.isOKforQuiz());
        assertTrue(question5.isOKforQuiz());
        assertTrue(questionCopy.isOKforQuiz());
    }
}