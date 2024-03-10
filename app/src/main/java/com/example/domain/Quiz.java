package com.example.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * To Quiz.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class Quiz {
    private String quizCode; // e.g. "30FSA3"
    final private Teacher teacher; // The teacher responsible for the creation of the quiz
    private Course course; // The course that this quiz is related to
    private Set<Question> quizQuestions = new HashSet<>(); //A quiz must have 6 to 10 questions

    //Constructor #1
    public Quiz(Teacher teacher) {
        this.teacher = teacher;
    }

    //Constructor #2
    /**
     * Βοηθητικός κατασκευαστής.
     * @param quizCode Ο κωδικός του Quiz.
     * @param teacher Ο καθηγητής που φτιάχνει το Quiz.
     * @param course Το μάθημα στο οποίο αναφέρεται το Quiz.
     */
    public Quiz(String quizCode, Teacher teacher, Course course) {
        this.quizCode = quizCode;
        this.teacher = teacher;
        this.course = course;
    }

    //Getters
    /**
     * Επιστρέφει τον καθηγητή που φτιάχνει το Quiz.
     * @return Ο καθηγητής
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Επιστρέφει τον κωδικό του Quiz.
     * @return Ο κωδικός του Quiz
     */
    public String getQuizCode() { return quizCode; }

    /**
     * Επιστρέφει το μάθημα στο οποίο αναφέρεται το Quiz.
     * @return Το μάθημα
     */
    public Course getCourse() { return course; }
    public Set<Question> getQuizQuestions() { return quizQuestions; }

    //Setters

    /**
     * Θέτει τον κωδικό του Quiz.
     * @param quizCode Ο κωδικός του Quiz
     */
    public void setQuizCode(String quizCode) { this.quizCode = quizCode; }

    /**
     * Θέτει το μάθημα στο οποίο αναφέρεται το Quiz.
     * @param course Το μάθημα
     */
    public void setCourse(Course course) { this.course = course; }
    public void setQuizQuestions(Set<Question> quizQuestions) { this.quizQuestions = quizQuestions; }

    /**
     * Προσθέτει μια ερώτηση σε ένα Quiz.
     * @param question Η ερώτηση που θέλουμε να βάλουμε στο Quiz
     */
    public boolean addQuestion(Question question) {
        if (quizQuestions.size() == 10 ) {
            System.out.println("Can't add more than 10 questions per quiz.");
            return false;
        }else {
            if (question.isOKforQuiz())
                quizQuestions.add(question);
        }
        return true;
    }

    /**
     * Ελέγχει αν το Quiz πληρεί κάποιες προϋποθέσεις ώστε να ανέβει
     * στον κατάλογο με τα Quiz του μαθήματος του καθηγητή.
     */
    public boolean isOK(){
        if (quizQuestions.size()<6 || quizQuestions.size()>10)
            return false;
        else
            return true;
        }
}