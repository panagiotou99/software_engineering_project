package com.example.domain;

import java.util.HashSet;
import java.util.Set;
import com.example.util.SchoolCourse;

/**
 * Το μάθημα ενός καθηγητή.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class Course {
    private String id; //e.g. "HDFJ238832"
    private SchoolCourse schoolCourse; // For example, Maths for the second grade
    private float price; //e.g. 0.0 or 0.99
    private String description; //e.g. "In this course, you'll learn about multiplication, ..."
    private Set<Question> courseQuestions = new HashSet<>(); // Bank of questions related to this course
    private Set<Quiz> courseQuizes = new HashSet<>();

    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    //Constructor #1 (Default)
    public Course(){}

    /**
     * Βοηθητικός κατασκευαστής.
     * @param id Ο κωδικός του μαθήματος.
     * @param schoolCourse Το μάθημα σαν μάθημα.
     * @param price Η τιμή του μαθήματος.
     * @param description Η περιγραφή του μαθήματος.
     */
    //Constructor #2
    public Course(String id, SchoolCourse schoolCourse, float price, String description) {
        this.id = id;
        this.schoolCourse = schoolCourse;
        this.price = price;
        this.description = description;
    }

    //Getters

    /**
     * Επιστρέφει τον κωδικό του μαθήματος.
     * @return Ο κωδικός του μαθήματος
     */
    public String getId() { return id; }

    /**
     * Επιστρέφει τί μάθημα είναι ως μάθημα. π.χ. Αγγλικά 3 (Δηλαδή 3ης Δημοτικού)
     * @return Το σχολικό μάθημα
     */
    public SchoolCourse getSchoolCourse() { return schoolCourse; }

    /**
     * Επιστρέφει την τιμή του μαθήματος.
     * @return Η τιμή
     */
    public float getPrice() {  return price; }

    /**
     * Επιστρέφει την περιγραφή του μαθήματος.
     * @return Η περιγραφή
     */
    public String getDescription() { return description; }

    /**
     * Επιστρέφει τις ερωτήσεις του μαθήματος του καθηγητή.
     * @return Ερωτήσεις μαθήματος
     */
    public Set<Question> getCourseQuestions() {return courseQuestions;}

    /**
     * Επιστρέφει τα Quiz του μαθήματος του καθηγητή.
     * @return Quiz μαθήματος
     */
    public Set<Quiz> getCourseQuizes() {return courseQuizes;}


    //Setters

    /**
     * Θέτει τον κωδικό του μαθήματος.
     * @param id Ο κωδικός του μαθήματος
     */
    public void setID(String id) { this.id = id; }

    /**
     * Θέτει το σχολικό μάθημα.
     * @param schoolCourse Το σχολικό μάθημα
     */
    public void setSchoolCourse(SchoolCourse schoolCourse) { this.schoolCourse = schoolCourse; }

    /**
     * Θέτει την τιμή του μαθήματος.
     * @param price Η τιμή του μαθήματος
     */
    public void setPrice(float price) { this.price = price; }

    /**
     * Θέτει την περιγραφή του μαθήματος.
     * @param description Η περιγραφή του μαθήματος
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Προσθέτει ένα Quiz στον κατάλογο με τα Quiz του συγκεκριμένου μαθήματος
     * @param newQuiz Το νέο Quiz που ανεβαίνει
     */
    public void addQuiz(Quiz newQuiz){
        courseQuizes.add(newQuiz);
    }

    // Adds a question to the question bank of the course
    /**
     * Προσθέτει μια ερώτηση στην τράπεζα ερωτήσεων του μαθήματος
     * @param newQuestion Η νέα ερώτηση προς ανέβασμα
     */
    public void addQuestion(Question newQuestion){
        courseQuestions.add(newQuestion);
    }

}