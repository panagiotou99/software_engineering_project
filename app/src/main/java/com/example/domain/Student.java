package com.example.domain;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Ο μαθητής.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class Student extends User {
    private int grade; // e.g. 6, values from 1 to 12 (1-6: primary school, 7-9: middle school, 10-12: high school)
    private Set<Course> studentCourses = new HashSet<>(); // e.g. [Maths, English, Chemistry]
    private Set<CompletedQuiz> studentCompletedQuizes = new HashSet<>(); // e.g. [Quiz_5-5-2021_1,Quiz_5-5-2021_2,Quiz_10-5-2021_1,...]
    //private Set<String> payments= new HashSet<>();

    //Constructor #1 (Default)
    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    public Student() { super(); }

    //Constructor #2
    public Student(String firstName, String lastName, int age, String email, String iban, String password, int grade){
        super(firstName,lastName,age,email,iban,password);
        this.grade = grade;
    }

    //Getters
    public int getGrade() { return grade; }
    public Set<Course> getStudentCourses() { return studentCourses; }
    public Set<CompletedQuiz> getStudentCompletedQuizes(){ return studentCompletedQuizes; }

    //Setters
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean registerToCourse(Course course){
        if (getGrade()==course.getSchoolCourse().getGrade()){
            studentCourses.add(course);
            return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CompletedQuiz takeQuiz(Quiz quiz, Set<Answer> studentAnswers){
        LocalDate localDate = LocalDate.now();
        CompletedQuiz completedQuiz = new CompletedQuiz(this,quiz,localDate);
        for (Answer x: studentAnswers){
            completedQuiz.addAnswer(x);
        }
        studentCompletedQuizes.add(completedQuiz);
        completedQuiz.setScore(completedQuiz.calculateScore());
        return completedQuiz;
    }
}
