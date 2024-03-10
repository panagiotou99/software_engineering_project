package com.example.view.signup.signupTeacher;

import androidx.appcompat.app.AlertDialog;

import com.example.learningapp.R;

public class SignUpTeacherStub implements SignUpTeacherView {

    String email, password, firstName, lastName, age, iban, ssn, bio, profession, alertTitle, alertMessage, etc;

    SignUpTeacherStub() {
        this.email = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.ssn = "";
        this.age = "";
        this.bio = "";
        this.profession = "";
        this.alertTitle = "";
        this.alertMessage = "";
        this.etc = "";
        this.iban = "";
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setAge(String age) {
        this.age = age;
    }

    void setIban(String iban) {
        this.iban = iban;
    }

    void setSsn(String ssn) {
        this.ssn = ssn;
    }

    void setProfession(String profession) {
        this.profession = profession;
    }

    void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String getfirstName() {
        return firstName;
    }

    @Override
    public String getlastName() {
        return lastName;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getIBAN() {
        return iban;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getSsn() {
        return ssn;
    }

    @Override
    public String getProfession() {
        return profession;
    }

    @Override
    public String getBio() {
        return bio;
    }

    public String getAlertTitle() {
        return alertTitle;
    }

    public String getErrorMessage() {
        return alertMessage;
    }

    @Override
    public void onInvalidInput(int code) {
        if (code == 1) {
            this.alertTitle = "Συμπλήρωσε όλα τα στοιχεία της φόρμας.";
            this.alertMessage = "Όλα τα πεδία είναι υποχρεωτικά.";
        } else if (code == 2) {
            this.alertTitle = "Πρέπει να είσαι τουλ. 18 ετών για να κάνεις εγγραφή.";
            this.alertMessage = "Για να έχεις την ιδιότητα του καθηγητή πρέπει να είσαι τουλάχιστον ενήλικας.";
        } else if (code == 3) {
            this.alertTitle = "Μη έγκυρη διεύθυνση email.";
            this.alertMessage = "Η διεύθυνση email δεν αντιστοιχεί σε πραγματική διεύθυνση ηλετρονικού ταχυδρομείου";
        } else if (code == 4) {
            this.alertTitle = "Άλλαξε τον κωδικό σου και ξαναπροσπάθησε.";
            this.alertMessage = "O κωδικός πρέπει να έχει λατινικά, 1 ψηφίο,1 κεφαλαίο και 1 μικρό γράμμα.";
        } else if (code == 5) {
            this.alertTitle = "To IBAN δεν είναι έγκυρο.";
            this.alertMessage = "Άλλαξε το IBAN σου και ξανα προσπάθησε.";
        }
    }

    @Override
    public void onValidRegistration() {
        this.etc = "Valid Registration";
    }

    public String getEtc() {
        return etc;
    }
}
