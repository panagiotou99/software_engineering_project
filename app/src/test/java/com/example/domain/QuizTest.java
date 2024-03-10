package com.example.domain;

import com.example.util.SchoolCourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class QuizTest {

    Teacher teacher1;
    Course course1;
    Quiz quiz1;
    Set<Question> temp;
    Question question1;

    @Before
    public void setUp() throws Exception {
        teacher1 = new Teacher("Antonis", "Antoniadou", 48, "antant@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXN", "iHateThisGravity","Maths","I'm good at teaching", 123456789);
        course1 = new Course("MATH4DUMMIES", new SchoolCourse(1,"MATHS"),0.0f, "Easiest Math Ever");

        quiz1 = new Quiz(teacher1);
        quiz1.setQuizCode("MATH4DUMMIES_QUIZ1");
        quiz1.setCourse(course1);

        question1= new Question("1+2=?","Easy",teacher1,course1);
        question1.questionInitMulti("3","1","2","0");
        quiz1.addQuestion(question1);
    }

    @Test
    public void testQuizGetterSetter(){
        Assert.assertEquals("Antonis",quiz1.getTeacher().getFirstName());
        Assert.assertEquals("MATH4DUMMIES_QUIZ1",quiz1.getQuizCode());
        Assert.assertEquals("MATH4DUMMIES",quiz1.getCourse().getId());
        Assert.assertEquals(1,quiz1.getQuizQuestions().size());
    }

    @Test
    public void testQuizIsOK(){
        Assert.assertEquals(false,quiz1.isOK());
    }
}