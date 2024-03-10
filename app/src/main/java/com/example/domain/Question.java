package com.example.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Η ερώτηση.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class Question {
    private String id; // Unique identifier
    private String description; // e.g. "How much is 4x4?"
    private String level; //e.g. "Easy" or "Medium" or "Hard"
    private Teacher teacher; // The teacher that wrote this question
    private Course course; // The course that is related to this question
    private Set<Answer> possibleAnswers = new HashSet<>();

    //Constructor #1 (Default)
    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    public Question(){}

    //Constructor #2
    /**
     * Βοηθητικός κατασκευαστής.
     * @param description Η περιγραφή της ερώτησης.
     * @param level Το επίπεδο δυσκολίας της ερώτησης.
     * @param teacher Ο καθηγητής που φτιάχνει την ερώτηση.
     * @param course Το μάθημα στο οποίο αναφέρεται η ερώτηση.
     */
    public Question(String description,String level,Teacher teacher, Course course) {
        this.description = description;
        this.level = level;
        this.teacher = teacher;
        this.course = course;
        this.id="";
    }

    //Getters

    /**
     * Επιστρέφει την περιγραφή της ερώτησης.
     * @return Η περιγραφή
     */
    public String getDescription() { return description; }

    /**
     * Επιστρέφει το επίπεδο δυσκολίας της ερώτησης.
     * @return Το επίπεδο δυσκολίας
     */
    public String getLevel() { return level; }

    /**
     * Επιστρέφει τον καθηγητή που φτιάχνει την ερώτηση.
     * @return Ο καθηγητής
     */
    public Teacher getTeacher() { return teacher; }

    /**
     * Επιστρέφει το μάθημα στο οποίο αναφέρεται η ερώτηση.
     * @return Το μάθημα
     */
    public Course getCourse() { return course; }
    public Set<Answer> getPossibleAnswers() { return possibleAnswers; }

    //Setters

    /**
     * Θέτει την περιγραφή της ερώτησης.
     * @param description Η περιγραφή της ερώτησης
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Θέτει το επίπεδο δυσκολίας της ερώτησης.
     * @param level Το επίπεδο δυσκολίας
     */
    public void setLevel(String level) { this.level = level; }

    /**
     * Θέτει τον καθηγητή που φτιάχνει την ερώτηση.
     * @param teacher Ο καθηγητής
     */
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    /**
     * Θέτει το μάθημα στο οποίο αναφέρεται η ερώτηση.
     * @param course Το μάθημα
     */
    public void setCourse(Course course){  this.course = course; }

    /**
     * Θέτει το id της ερώτησης
     * @param id To unique identifier
     */
    public void setID(String id){this.id=id;}

    /**
     * Επιστρέφει το id της ερώτησης
     *
     */
    public String getID(){return this.id;}

    public void setPossibleAnswers(Set<Answer> possibleAnswers) { this.possibleAnswers=possibleAnswers; }

    /**
     * Αρχικοποιεί μια ερώτηση τύπου True or False
     * @param realAnswer Πραγματική απάντηση
     */
    public void questionInitTF(boolean realAnswer){
        Answer correctAnswer;
        Answer falseAnswer;
        if (realAnswer==true){
            correctAnswer =  new Answer("True",true);
            falseAnswer =  new Answer("False",false);
        }
        else{
            correctAnswer =  new Answer("False",true);
            falseAnswer =  new Answer("True",false);
        }
        possibleAnswers.add(correctAnswer);
        possibleAnswers.add(falseAnswer);
    }

    //Multiple Choice Question Init #1
    /**
     * Αρχικοποιεί μια ερώτηση τύπου πολλαπλής επιλογής
     * @param correctAnswer Η σωστή απάντηση
     * @param falseAnswer1 Μία λάθος απάντηση
     * @param falseAnswer2 Μία λάθος απάντηση
     * @param falseAnswer3 Μία λάθος απάντηση
     */
    public void questionInitMulti(String correctAnswer, String falseAnswer1, String falseAnswer2, String falseAnswer3){
        Answer correct =  new Answer(correctAnswer,true);
        Answer false1 =  new Answer(falseAnswer1,false);
        Answer false2 =  new Answer(falseAnswer2,false);
        Answer false3 =  new Answer(falseAnswer3,false);
        possibleAnswers.add(correct);
        possibleAnswers.add(false1);
        possibleAnswers.add(false2);
        possibleAnswers.add(false3);
    }

    //Multiple Choice Question Init #2
    /**
     * Ένας 2οσ τρόπος αρχικοποίησης μιας ερώτησς πολλαπλής επιλογής
     * @param correctAnswer Η σωστή απάντηση
     * @param falseAnswer1 Μία λάθος απάντηση
     * @param falseAnswer2 Μία λάθος απάντηση
     * @param falseAnswer3 Μία λάθος απάντηση
     */
    public void questionInitMulti(Answer correctAnswer, Answer falseAnswer1, Answer falseAnswer2, Answer falseAnswer3) {
        possibleAnswers.add(correctAnswer);
        possibleAnswers.add(falseAnswer1);
        possibleAnswers.add(falseAnswer2);
        possibleAnswers.add(falseAnswer3);
    }

    /**
     * Ελέγχει αν η ερώτηση είναι έτοιμη για να μπει σε κάποιο Quiz
     */
    public boolean isOKforQuiz(){
        int correctAnswers=0;
        int incorrectAnswers=0;
        for (Answer i: possibleAnswers){
            if (i.getValidity()){
                correctAnswers++;
            }
            else{
                incorrectAnswers++;
            }
        }
        if (correctAnswers==1 && incorrectAnswers>=1){
            return true;
        }
        else{
            return false;
        }
    }
}
