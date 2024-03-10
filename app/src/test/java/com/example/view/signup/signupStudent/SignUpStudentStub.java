package com.example.view.signup.signupStudent;

public class SignUpStudentStub implements SignUpStudentView {

    String email, password, firstName,lastName,age,iban,grade,alertTitle, alertMessage, etc;

    public SignUpStudentStub() {
        this.email = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.grade ="";
        this.age = "";
        this.alertTitle = "";
        this.alertMessage = "";
        this.etc="";
        this.iban="";
    }

    void setEmail(String email){
        this.email = email;
    }

    void setPassword(String password){
        this.password=password;
    }

    void setfirstName(String firstName){
        this.firstName = firstName;
    }

    void setLastName(String lastName){
        this.lastName = lastName;
    }

    void setAge(String age){
        this.age=age;
    }

    void setIban(String iban){
        this.iban=iban;
    }

    void setGrade(String grade){
        this.grade=grade;
    }

    @Override
    public String getfirstName(){
        return firstName;
    }

    @Override
    public String getlastName(){
        return lastName;
    }

    @Override
    public String getAge(){
        return age;
    }

    @Override
    public String getEmail(){
        return email;
    }

    @Override
    public String getIBAN(){
        return iban;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getGrade(){
        return grade;
    }

    public String getAlertTitle() {
        return alertTitle;
    }

    public String getErrorMessage() {
        return alertMessage;
    }

    public String getEtc(){return etc;}

    public void onValidRegistration(){
        this.etc="Valid Registration";
    }

    public void onInvalidInput(int code){
        String title=null;
        String info=null;
        if (code==1){
            this.alertTitle="Συμπλήρωσε όλα τα στοιχεία της φόρμας.";
            this.alertMessage="Όλα τα πεδία είναι υποχρεωτικά.";
        }
        else if (code==2){
            this.alertTitle="Πρέπει να είσαι τουλ. 6 ετών για να κάνεις εγγραφή.";
            this.alertMessage="Δεν επιτρέπονται χρήστες κάτω των 6 ετών να χρησιμοποιούν την εφαρμογή αυτή.";
        }
        else if (code==3){
            this.alertTitle="Μη έγκυρη διεύθυνση email.";
            this.alertMessage="Η διεύθυνση email δεν αντιστοιχεί σε πραγματική διεύθυνση ηλετρονικού ταχυδρομείου.";
        }
        else if (code==4){
            this.alertTitle="1η Δημοτικού = 1, .... 3η Λυκείου = 12";
            this.alertMessage="Γράψε τον αριθμό που αντιστοιχεί με την τάξη σου. Το 1 αντιστοιχεί στην 1η Δημοτικού. Το 12 στην 3η Λυκείου.";
        }
        else if (code==5){
            this.alertTitle="Άλλαξε τον κωδικό σου και ξαναπροσπάθησε.";
            this.alertMessage="O κωδικός πρέπει να έχει λατινικά, 1 ψηφίο,1 κεφαλαίο και 1 μικρό γράμμα.";
        }
        else if (code==6){
            this.alertTitle="To IBAN δεν είναι έγκυρο.";
            this.alertMessage="Άλλαξε το IBAN σου και ξανα προσπάθησε.";
        }
        else{
            this.alertTitle="Άγνωστο σφάλμα.";
            this.alertMessage="Προέκυψε ένα άγνωστο σφάλμα.";
        }
    }

}
