package com.example.domain;

import com.example.util.SchoolCourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class StudentTest {
    Student student1;
    Course course1,course2;

    @Before
    public void setUp() throws Exception {
        course1 =  new Course("MATH4DUMMIES", new SchoolCourse(1,"MATHS"),0.0f, "Easiest Math Ever");
        course2 =  new Course("ENGLISH4BEGINNERS", new SchoolCourse(2,"ENGLISH"),0.0f, "2nd Grade ENGLISH, requires previous knowledge");

        student1 = new Student();
        student1.setFirstName("Panagiotis");
        student1.setLastName("Panagiotou");
        student1.setAge(21);
        student1.setEmail("p3180139@aueb.gr");
        student1.setIban("GRXXXXXXXXXXXXXXXXXXXXXXXXX");
        student1.setPassword("aueb4ever1");
        student1.setGrade(1);
        student1.registerToCourse(course1);
        student1.registerToCourse(course2);
    }

    @Test
    public void testStudentGetterSetter(){
        Assert.assertEquals(1,student1.getGrade());
    }

    @Test
    public void testRegisterToCourse() throws IOException{
        //Students can only register to courses that are intended for their grade level.
        Assert.assertEquals(true,student1.registerToCourse(course1));
        Assert.assertEquals(false,student1.registerToCourse(course2));
        Assert.assertEquals(1,student1.getStudentCourses().size());
    }

}