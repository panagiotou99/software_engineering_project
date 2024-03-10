package com.example.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnswerTest {
    Answer tempAnswer1,tempAnswer2;

    @Before
    public void setUp() throws Exception {
        tempAnswer1 = new Answer();
        tempAnswer1.setDescription("a");
        tempAnswer1.setValidity(true);
        tempAnswer2 = new Answer("1", false);
    }

    @Test
    public void testAnswerGetterSetter(){
        Assert.assertEquals("a", tempAnswer1.getDescription());
        Assert.assertEquals(true, tempAnswer1.getValidity());
        Assert.assertEquals("1", tempAnswer2.getDescription());
        Assert.assertEquals(false, tempAnswer2.getValidity());
    }
}