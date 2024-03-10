package com.example.domain;

import com.example.util.SchoolCourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TeacherTest {

    Teacher teacher1;
    SchoolCourse schoolCourse;
    Course course1;
    Question question1;
    Quiz quiz1;
    Set<Course> temp;
    @Before
    public void setUp() throws Exception {
        teacher1 = new Teacher();
        teacher1.setFirstName("Antonis");
        teacher1.setLastName("Antoniadou");
        teacher1.setAge(48);
        teacher1.setEmail("antant@aueb.gr");
        teacher1.setIban("GRXXXXXXXXXXXXXXXXXXXXXXXXN");
        teacher1.setPassword("iHateThisGravity");
        teacher1.setProfession("Maths");
        teacher1.setResume("I'm good at teaching");
        teacher1.setSsn(123456789);

        schoolCourse = new SchoolCourse(1,"MATHS");
        course1 = teacher1.createCourse("MATHS_1_ANTONIADOU",schoolCourse,0.0f,"Mathimatika 1hs Dhmotikoy, gia to 1o Dimotiko Sxoleio Nafpaktou");
        temp = new HashSet<Course>();
        temp.add(course1);
        question1 = teacher1.createQuestion("1+0=?","Easy", course1);
        question1.questionInitMulti("1","0","3","4");
        course1.addQuestion(question1);
        quiz1 = teacher1.createQuiz("ENOTHTA1",course1);
        quiz1.addQuestion(question1);
        course1.addQuiz(quiz1);
    }

    @Test
    public void testTeacherGetterSetter(){
        Assert.assertEquals("Maths",teacher1.getProfession());
        Assert.assertEquals("I'm good at teaching",teacher1.getResume());
        Assert.assertEquals(123456789,teacher1.getSsn());
        Assert.assertEquals(temp,teacher1.getTeacherCourses());
    }

    @Test
    public void testTeacherfunctions(){
        Assert.assertEquals(1,course1.getCourseQuestions().size());
        Assert.assertEquals(1,course1.getCourseQuizes().size());
        Assert.assertEquals(false,quiz1.isOK());
    }
}
