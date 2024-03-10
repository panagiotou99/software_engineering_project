package com.example.domain;

import com.example.util.SchoolCourse;

import java.util.HashSet;
import java.util.Set;

/**
 * Ο καθηγητής.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class Teacher extends User{
    private String profession; // e.g. "Maths"
    private String resume; // e.g. "I was born in 1967. I studied Informatics in AUEB and graduated in 1989..."
    private int ssn; // eg: 432593322 (a 9 digit number)
    private Set<Course> teacherCourses= new HashSet<>(); // e.g. [Maths_1,Maths_2,Maths_3,...]

    //Constructor #1 (Default)
    public Teacher() {  super(); }

    //Constructor #2
    public Teacher(String firstName, String lastName, int age, String email, String iban, String password,String profession,String resume, int ssn){
        super(firstName,lastName,age,email,iban,password);
        this.profession = profession;
        this.resume = resume;
        this.ssn = ssn;
    }

    //Getters
    public String getProfession() { return profession; }
    public String getResume() { return resume; }
    public int getSsn() { return ssn; }
    public Set<Course> getTeacherCourses() { return teacherCourses; }

    //Setters
    public void setProfession(String profession) { this.profession = profession; }
    public void setResume(String resume) { this.resume = resume; }
    public void setSsn(int ssn) { this.ssn = ssn; }

    public Course createCourse(String id, SchoolCourse schoolCourse, float price, String description){
        Course newCourse = new Course(id,schoolCourse,price,description);
        teacherCourses.add(newCourse);
        return newCourse;
    }

    public Quiz createQuiz(String quizCode,Course course){
        Quiz newQuiz = new Quiz(quizCode,this,course);
        return newQuiz;
    }

    public Question createQuestion(String description,String level,Course course){
        Question newQuestion = new Question(description,level,this,course);
        return newQuestion;
    }
}
