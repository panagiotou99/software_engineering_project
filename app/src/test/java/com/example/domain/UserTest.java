package com.example.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserTest {
    User user ;

    @Before
    public void setUp() throws Exception{
        user = new User();
        user.setFirstName("Panagiotis");
        user.setLastName("Panagiotou");
        user.setAge(20);
        user.setEmail("p3180139@aueb.gr");
        user.setIban("GRXXXXXXXXXXXXXXXXXXXXXXXXX");
        user.setPassword("aueb4ever1");
    }

    @Test
    public void testUserGetterSetter() {
        Assert.assertEquals("Panagiotis", user.getFirstName());
        Assert.assertEquals("Panagiotou", user.getLastName());
        Assert.assertEquals(20, user.getAge());
        Assert.assertEquals("p3180139@aueb.gr",user.getEmail());
        Assert.assertEquals("GRXXXXXXXXXXXXXXXXXXXXXXXXX",user.getIban());
        Assert.assertEquals("aueb4ever1",user.getPassword());
    }
}