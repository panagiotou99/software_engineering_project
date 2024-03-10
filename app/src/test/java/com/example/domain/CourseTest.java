package com.example.domain;

import com.example.util.SchoolCourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {
    Course course1;
    @Before
    public void setUp() throws Exception {
        course1 = new Course();
        course1.setID("ENGLISH4DUMMIES");
        SchoolCourse temp = new SchoolCourse(2,"ENGLISH");
        course1.setSchoolCourse(temp);
        course1.setPrice(0.99f);
        course1.setDescription("Easiest English Ever");
    }

    @Test
    public void testCourseGetterSetter(){
        Assert.assertEquals("ENGLISH4DUMMIES",course1.getId());
        Assert.assertEquals(2,course1.getSchoolCourse().getGrade());
        Assert.assertEquals(0.99f,0.99f,course1.getPrice());
        Assert.assertEquals("Easiest English Ever",course1.getDescription());
    }
}