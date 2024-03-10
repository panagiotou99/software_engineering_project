package com.example.domain;

import com.example.util.SchoolCourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CompletedQuizTest {

    Student student1,student2;
    Teacher teacher1,teacher2;
    Course course1,course2;
    Quiz quiz1, quiz2, badquiz;
    CompletedQuiz completed_quiz1, completed_quiz2;
    Question question1, question2, question3, question4, question5, question6, question7, question8, question9, question10,question11;
    Question question01, question02, question03, question04, question05, question06;
    Answer tempAnswer1, tempAnswer2, tempAnswer3, tempAnswer4;
    Set<Answer> temp_answers, temp3;
    Set<Question> temp_questions;

    @Before
    public void setUp() throws Exception {
        student1 = new Student("Panagiotis", "Panagiotou", 21, "p3180139@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXX", "aueb4ever1", 1);
        student2 = new Student("Olga","Margeli",20,"p3180103@aueb.gr","GRXXXXXXXXXXXXXXXXXXXXXXXXY","aueb4ever2",1);

        teacher1 = new Teacher("Antonis", "Antoniadou", 48, "antant@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXN", "iHateThisGravity","Maths","I'm good at teaching", 123456789);
        teacher2 = new Teacher("Alexandros", "Voulgaris", 40, "theboy@gmail.com", "GRXXXXXXXXXXXXXXXXXXXXXXXXZ", "mustikoskwdikos","English","I have studied abroad.", 987654321);

        course1 = new Course("MATH4DUMMIES", new SchoolCourse(1,"MATHS"),0.0f, "Easiest Math Ever");
        course2 = new Course("ENGLISH4DUMMIES", new SchoolCourse(2,"ENGLISH"),0.99f, "Easiest English Ever");

        quiz1 = new Quiz("QUIZ1_MATH4DUMMIES", teacher1, course1);
        quiz2 = new Quiz("QUIZ1_ENGLISH4DUMMIES",teacher2,course2);
        badquiz = new Quiz("QUIZ2_ENGLISH4DUMMIES", teacher1, course1);

        //#1 QUIZ, #1 QUESTION: 1+1, CORRECT ANSWER=2
        question1= new Question("1+1=?","Easy",teacher1,course1);
        tempAnswer1 = new Answer("2",true);
        tempAnswer2 = new Answer("1", false);
        tempAnswer3 = new Answer("0", false);
        tempAnswer4 = new Answer("11", false);
        question1.questionInitMulti(tempAnswer1,tempAnswer2,tempAnswer3,tempAnswer4);
        quiz1.addQuestion(question1);
        badquiz.addQuestion(question1);

        //#1 QUIZ, #2 QUESTION: 1+2, CORRECT ANSWER=3
        question2= new Question("1+2=?","Easy",teacher1,course1);
        question2.questionInitMulti("3","1","2","0");
        quiz1.addQuestion(question2);
        badquiz.addQuestion(question2);

        //#1 QUIZ, #3 QUESTION: 1+3, CORRECT ANSWER=4
        question3= new Question("1+3=?","Easy",teacher1,course1);
        question3.questionInitMulti("4","1","2","3");
        quiz1.addQuestion(question3);
        badquiz.addQuestion(question3);

        //#1 QUIZ, #4 QUESTION: 3+0, CORRECT ANSWER=3
        question4= new Question("3+0=?","Easy",teacher1,course1);
        question4.questionInitMulti("3","1","2","30");
        quiz1.addQuestion(question4);
        badquiz.addQuestion(question4);

        //#1 QUIZ, #5 QUESTION: 3+2, CORRECT ANSWER=5
        question5= new Question("3+2=?","Easy",teacher1,course1);
        question5.questionInitMulti("5","2","1","0");
        quiz1.addQuestion(question5);
        badquiz.addQuestion(question5);

        //#1 QUIZ, #6 QUESTION: 3+4, CORRECT ANSWER=7
        question6= new Question("3+4=?","Easy",teacher1,course1);
        question6.questionInitMulti("7","2","1","5");
        quiz1.addQuestion(question6);
        badquiz.addQuestion(question6);

        //#1 QUIZ, #7 QUESTION: 4+1, CORRECT ANSWER=5
        question7= new Question("4+1=?","Easy",teacher1,course1);
        question7.questionInitMulti("5","2","1","0");
        quiz1.addQuestion(question7);
        badquiz.addQuestion(question7);

        //#1 QUIZ, #8 QUESTION: 5+1, CORRECT ANSWER=6
        question8= new Question("5+1=?","Easy",teacher1,course1);
        question8.questionInitMulti("6","2","1","0");
        quiz1.addQuestion(question8);
        badquiz.addQuestion(question8);

        //#1 QUIZ, #9 QUESTION: 4+0, CORRECT ANSWER=5
        question9= new Question("4+0=?","Easy",teacher1,course1);
        question9.questionInitMulti("4","2","1","3");
        quiz1.addQuestion(question9);
        badquiz.addQuestion(question9);

        //#1 QUIZ, #10 QUESTION: 1+3, CORRECT ANSWER=5
        question10= new Question("1+3=?","Easy",teacher1,course1);
        question10.questionInitMulti("4","2","1","0");
        quiz1.addQuestion(question10);
        badquiz.addQuestion(question10);

        question11= new Question("10000+0=?","Easy",teacher1,course1);

        completed_quiz1 = new CompletedQuiz(student1,quiz1, LocalDate.now());
        temp3 = new HashSet<>();
        temp3.add(new Answer("2", true));
        temp3.add(new Answer("3", true));
        temp3.add(new Answer("4", true));
        temp3.add(new Answer("3", true));
        temp3.add(new Answer("5", true));
        temp3.add(new Answer("2", false));
        temp3.add(new Answer("2", false));
        temp3.add(new Answer("2", false));
        temp3.add(new Answer("2", false));
        temp3.add(new Answer("2", false));
        completed_quiz1 = student1.takeQuiz(quiz1,temp3);

        //2nd QUIZ STARTS HERE //
        temp_questions = new HashSet<Question>();
        question01= new Question("I'm eating _____ apple,","Easy",teacher2,course2);
        question01.questionInitMulti("an","am","on","in");
        temp_questions.add(question01);

        question02= new Question("I ___ fat.","Easy",teacher2,course2);
        question02.questionInitMulti("am","an","on","in");
        temp_questions.add(question02);

        question03= new Question("You are ____.","Easy",teacher2,course2);
        question03.questionInitMulti("playing","playd","play","played");
        temp_questions.add(question03);

        question04= new Question("She ___ a bad person.","Easy",teacher2,course2);
        question04.questionInitMulti("is","off","is","are");
        temp_questions.add(question04);

        question05= new Question("What is a banana?","Easy",teacher2,course2);
        question05.questionInitMulti("A fruit","Clothing","Martial Art","Dog Breed");
        temp_questions.add(question05);

        question06= new Question("What word means the same as funny?","Easy",teacher2,course2);
        question06.questionInitMulti("Hilarious","Sick","Angry","Loved");
        temp_questions.add(question06);

        quiz2.setQuizQuestions(temp_questions);

        completed_quiz2 = new CompletedQuiz();
        completed_quiz2.setQuizDate(LocalDate.of(2021,4,28));
        completed_quiz2.setStudent(student2);
        completed_quiz2.setQuiz(quiz2);
        completed_quiz2.setId("test");
        temp_answers = new HashSet<>();
        temp_answers.add(new Answer("an", true));
        temp_answers.add(new Answer("am", true));
        temp_answers.add(new Answer("playing", true));
        temp_answers.add(new Answer("are", false));
        temp_answers.add(new Answer("Martial Art",false));
        temp_answers.add(new Answer("Loved", false));

        completed_quiz2.setFinishedQuizAnswers(temp_answers);

    }
    @Test
    public void testCompletedQuizGetterSetter() {
        Assert.assertEquals("Panagiotis", completed_quiz1.getStudent().getFirstName());
        Assert.assertEquals("QUIZ1_MATH4DUMMIES", completed_quiz1.getQuiz().getQuizCode());
        Assert.assertEquals(LocalDate.now(), completed_quiz1.getQuizDate());
        Assert.assertEquals(10,completed_quiz1.getFinishedQuizAnswers().size());
    }

    @Test
    public void testScoreCalculation() {
        Assert.assertEquals(5, completed_quiz1.calculateScore());
        Assert.assertEquals(3, completed_quiz2.calculateScore());
    }

    @Test
    public void testOtherFunctions(){
        //A quiz is okay when it has 6 to 10 questions.
        Assert.assertEquals(true,quiz1.isOK());
        //A quiz can't have more than 11 questions.
        Assert.assertEquals(false,badquiz.addQuestion(question11));
        Assert.assertEquals(1,student1.getStudentCompletedQuizes().size());
        Assert.assertEquals("test",completed_quiz2.getId());
    }
}