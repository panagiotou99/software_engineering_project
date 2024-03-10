package com.example.util;

public class SignUpChecker {
    public static final String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    static final String ibanRegex = "^GR\\d{9}[0-9A-Z]{16}$";
    public static final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$" ;

    public static boolean isEmail(String email) {
        return  email.matches(emailRegex);
    }

    public static boolean isIBAN(String iban) {
        // Must be greek IBAN
        return  iban.matches(ibanRegex);
    }

    public static boolean isPassword(String password) {
        // Password must contain at least one digit [0-9].
        // Password must contain at least one lowercase Latin character [a-z]
        // Password must contain at least one uppercase Latin character [A-Z]
        // Password must contain a length of at least 8 characters and a maximum of 20 characters
        return  password.matches(passwordRegex);
    }
}
