package com.example.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Το υποβληθέν Quiz.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class CompletedQuiz {
    private String id; //The unique identifier of the completed quiz
    private LocalDate quizDate; // The date the quiz was taken
    private int score; // The amount of correct answers the student got
    private Student student; // The student that participated in the quiz
    private Quiz quiz; // The quiz the student participated in
    private Set<Answer> finishedQuizAnswers = new HashSet<>(); // A completed quiz must have from 6 to 10 answers (depending on the number of questions)

    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    //Constructor #1 (Default)
    public CompletedQuiz(){}

    /**
     * Βοηθητικός κατασκευαστής.
     * @param student Ο μαθητής που υποβάλει το Quiz.
     * @param quiz Το Quiz στο οποίο εξετάζεται ο μαθητής.
     * @param quizDate Η ημερομηνία που εκτελείται το Quiz.
     */
    //Constructor #2
    public CompletedQuiz(Student student, Quiz quiz, LocalDate quizDate) {
        this.id="";
        this.student = student;
        this.quiz = quiz;
        this.quizDate = quizDate;
        this.score=0;
    }

    //Getters

    /**
     * Επιστρέφει την ημερομηνία που ο μαθητής ολοκλήρωσε το Quiz.
     * @return Η ημερομηνία ολοκλήρωσης του Quiz
     */
    public LocalDate getQuizDate() { return quizDate; }

    /**
     * Επιστρέφει το σκορ που πήρε ο μαθητής στο συγκεκριμένο Quiz.
     * @return Το σκορ του μαθητή
     */
    public int getScore() { return score; }

    /**
     * Επιστρέφει τον μαθητή που ολοκλήρωσε το Quiz.
     * @return Τον μαθητή
     */
    public Student getStudent() { return student; }

    /**
     * Επιστρέφει το Quiz στο οποίο συμμετείχε.
     * @return Το Quiz
     */
    public Quiz getQuiz() { return quiz; }

    /**
     * Επιστρέφει τις απαντήσεις του μαθητή.
     * @return Τις απαντήσεις του μαθητή
     */
    public Set<Answer> getFinishedQuizAnswers() { return finishedQuizAnswers; }

    /**
     * Επιστρέφει το μοναδικό identifier του ολοκληρωμένου quiz
     * @return To id
     */
    public String getId(){
        return id;
    }

    //Setters


    public void setId(String id){
        this.id=id;
    }
    /**
     * Θέτει την ημερομηνία διεξαγωγής του Quiz.
     * @param quizDate Η ημερομηνία διεξαγωγής του Quiz
     */
    public void setQuizDate(LocalDate quizDate) { this.quizDate = quizDate; }

    /**
     * Θέτει το σκορ του μαθητή.
     * @param score Το σκορ του μαθητή
     */
    public void setScore(int score) { this.score = score; }

    /**
     * Θέτει τον μαθητή που εξετάζεται στο Quiz.
     * @param student Ο μαθητής που εξετάζεται στο Quiz
     */
    public void setStudent(Student student) {  this.student = student; }

    /**
     * Θέτει το Quiz στο οποίο εξετάζεται ο μαθητής.
     * @param quiz Το Quiz στο οποίο εξετάζεται ο μαθητής
     */
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
    public void setFinishedQuizAnswers(Set<Answer> finishedQuizAnswers) {this.finishedQuizAnswers = finishedQuizAnswers; }

    /**
     * Προσθέτει μια απάντηση στην λίστα με τις απαντήσεις του μαθητή.
     * @param answer Η απάντηση του μαθητή
     */
    public void addAnswer(Answer answer){
        finishedQuizAnswers.add(answer);
    }

    /**
     * Υπολογίζει και επιστρέφει το τελικό σκορ του μαθητή.
     */
    public int calculateScore() {
        int score=0;
        for (Answer i: finishedQuizAnswers){
            if (i.getValidity()){
                score++;
            }
        }
        System.out.println("You scored "+score+"/"+finishedQuizAnswers.size());
        setScore(score);
        return getScore();
    }
}

