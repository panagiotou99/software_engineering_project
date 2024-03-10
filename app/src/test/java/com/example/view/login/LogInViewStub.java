package com.example.view.login;

public class LogInViewStub implements LogInView {

    String email, password, alertTitle, alertMessage, etc;

    public LogInViewStub() {
        this.email = "";
        this.password = "";
        this.alertTitle = "";
        this.alertMessage = "";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void onInvalidInput(int code) {
        if (code==1){
            this.alertTitle="Κενά στοιχεία.";
            this.alertMessage="To email και ο κωδικός πρόσβασης δεν γίνεται να είναι κενά.";
        }
        else if (code==2){
            this.alertTitle="Μη έγκυρη διεύθυνση email.";
            this.alertMessage="Η διεύθυνση email δεν αντιστοιχεί σε πραγματική διεύθυνση ηλετρονικού ταχυδρομείου.";
        }
        else if(code==3){
            this.alertTitle="Δε βρέθηκε χρήστης.";
            this.alertMessage="Δε βρέθηκε χρήστης με αυτό το συνδιασμό email και κωδικού. Δοκιμάστε κάτι άλλο.";
        }
    }

    @Override
    public void onSuccesLogin(int code){
    }

    @Override
    public void onSignup(){
        this.etc="signup";
    }

    @Override
    public void onRemindPassword(){
        this.etc="remind";
    }

    public String getAlertTitle() {
        return alertTitle;
    }

    public String getErrorMessage() {
        return alertMessage;
    }

    public String getEtc(){return etc;}
}
