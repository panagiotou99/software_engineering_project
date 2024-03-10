package com.example.util;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;


public class SchoolCourseCatalogueTest {
    SchoolCourseCatalogue courseCatalogue;

    @Before
    public void setUp() throws Exception {
        courseCatalogue = new SchoolCourseCatalogue();
        courseCatalogue.loadCatalogue("src/test/resources/courseCatalogue.txt");
        for (int i=1; i<13; i++) {
            courseCatalogue.getSchoolCourse(i);
            System.out.print("\n");
        }
    }

    @Test
    public void testSchoolCourseCatalogue() throws IOException {
        Assert.assertEquals(96,courseCatalogue.getCatalogueSize());
    }
}