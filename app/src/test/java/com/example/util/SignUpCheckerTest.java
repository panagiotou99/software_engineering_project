package com.example.util;

import com.example.domain.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignUpCheckerTest {
    String wrongEmail1,wrongEmail2,wrongEmail3;
    String validEmail1,validEmail2;

    String wrongIban1, wrongIban2, wrongIban3;
    String validIban1, validIban2;

    String wrongPassword1, wrongPassword2, wrongPassword3;
    String validPassword1, validPassword2;

    SignUpChecker checker;
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Panagiotis", "Panagiotou", 21, "panagiotoupanagiotis1999@gmail.com","GR2101600690000000012345687" , "Aueb4ever");
        checker = new SignUpChecker();
        wrongEmail1= "aaaa"; wrongEmail2 = "@@@@@"; wrongEmail3= "aaa@aaa";
        validEmail1 = "p3180139@aueb.gr"; validEmail2= "user_name@domain.com";

        wrongIban1 = "GB99RB0S12345612345678\n"; wrongIban2="GB99RB0S123456123"; wrongIban3="123213B0S12345612345678";
        validIban1 = "GR7701720110005011000009849"; validIban2="GR1601100400000004012345678";

        wrongPassword1="aggdagsd"; wrongPassword2="13"; wrongPassword3="εληγελςε";
        validPassword1="CodingIsLife10"; validPassword2="100YEARSOFaueb";
    }

    @Test
    public void testUserSignUp(){
        Assert.assertEquals(false,checker.isEmail(wrongEmail1));
        Assert.assertEquals(false,checker.isEmail(wrongEmail2));
        Assert.assertEquals(false,checker.isEmail(wrongEmail3));
        Assert.assertEquals(true,checker.isEmail(validEmail1));
        Assert.assertEquals(true,checker.isEmail(validEmail2));
        Assert.assertEquals(true,checker.isEmail(user.getEmail()));


        Assert.assertEquals(false,checker.isIBAN(wrongIban1));
        Assert.assertEquals(false,checker.isIBAN(wrongIban2));
        Assert.assertEquals(false,checker.isIBAN(wrongIban3));
        Assert.assertEquals(true,checker.isIBAN(validIban1));
        Assert.assertEquals(true,checker.isIBAN(validIban2));
        Assert.assertEquals(true,checker.isIBAN(user.getIban()));

        Assert.assertEquals(false,checker.isPassword(wrongPassword1));
        Assert.assertEquals(false,checker.isPassword(wrongPassword2));
        Assert.assertEquals(false,checker.isPassword(wrongPassword3));
        Assert.assertEquals(true,checker.isPassword(validPassword1));
        Assert.assertEquals(true,checker.isPassword(validPassword2));
        Assert.assertEquals(true,checker.isPassword(user.getPassword()));
    }
}