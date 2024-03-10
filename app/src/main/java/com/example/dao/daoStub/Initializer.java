package com.example.dao.daoStub;

import com.example.domain.Course;
import com.example.domain.Question;
import com.example.domain.Quiz;
import com.example.domain.Student;
import com.example.domain.User;
import com.example.domain.Teacher;
import com.example.util.SchoolCourse;
import java.io.IOException;

/**
 * Class that initiates all the instances of the "database"
 *
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */
public abstract class Initializer{

    /**
     * Removes all data
     */
    protected abstract void eraseData();

    /**
     * Prepare some fake testing objects and add them in DAOs
     */
    public void prepareData() throws IOException {
        eraseData();

        Student panagiotis = new Student("Panagiotis", "Panagiotou", 21, "panagiotis@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXX", "Panagiotis1", 1);
        Student olga = new Student("Olga", "Margeli", 20, "olga@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXY", "Olga1", 1);
        Student elena = new Student("Elena", "Fourtouni", 20, "elena@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXZ", "Elena1", 1);
        getUserDAO().registerUser(panagiotis);
        getUserDAO().registerUser(olga);
        getUserDAO().registerUser(elena);

        Teacher zafeiris = new Teacher("Vasilis", "Zafeiris", 40, "zafeiris@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXK", "Zafeiris1", "Maths", "I'm good at maths", 123456789);
        Teacher diamantis = new Teacher("Nikolas", "Diamantis", 50, "diamantis@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXL", "Diamantis1", "English", "I'm good at english", 987654321);
        Teacher giakoumakis = new Teacher("Emmanuil", "Giakoumakis", 60, "giakoumakis@aueb.gr", "GRXXXXXXXXXXXXXXXXXXXXXXXXM", "Giakoumakis1", "Informatics", "I'm good at IT", 192837465);
        getUserDAO().registerUser(zafeiris);
        getUserDAO().registerUser(diamantis);
        getUserDAO().registerUser(giakoumakis);
        Course course1 = new Course("MATHS", new SchoolCourse(1,"MATHS"),0.0f, "Easiest Math Ever");
        Course course2 = new Course("ENGLISH", new SchoolCourse(1,"ENGLISH"),0.0f, "Easiest English Ever");
        Course course3 = new Course("INFORMATICS", new SchoolCourse(1,"INFORMATICS"),0.0f, "Easiest Informatics Ever");
        getCourseDAO().save(course1);
        getCourseDAO().save(course2);
        getCourseDAO().save(course3);

        Quiz quiz1 = new Quiz("INTRO: MATHS", zafeiris, course1);
        Quiz quiz2 = new Quiz("INTRO: ENGLISH",diamantis,course2);
        Quiz quiz3 = new Quiz("INTRO: INFORMATICS",giakoumakis,course2);

        Question question1= new Question("1+1=?","Easy",zafeiris,course1);
        Question question2= new Question("1+2=?","Easy",zafeiris,course1);
        Question question3 = new Question("1+3=?","Easy",zafeiris,course1);
        Question question4 = new Question("3+0=?","Easy",zafeiris,course1);
        Question question5 = new Question("3+2=?","Easy",zafeiris,course1);
        Question question6 = new Question("3+4=?","Easy",zafeiris,course1);
        Question question7 = new Question("4+1=?","Easy",zafeiris,course1);
        Question question8 = new Question("5+1=?","Easy",zafeiris,course1);
        Question question9 = new Question("4+0=?","Easy",zafeiris,course1);
        Question question10 = new Question("1+3=?","Easy",zafeiris,course1);

        question1.questionInitMulti("2","1","0","11");
        question2.questionInitMulti("3","1","2","0");
        question3.questionInitMulti("4","1","2","3");
        question4.questionInitMulti("3","1","2","30");
        question5.questionInitMulti("5","2","1","0");
        question6.questionInitMulti("7","2","1","5");
        question7.questionInitMulti("5","2","1","0");
        question8.questionInitMulti("6","2","1","0");
        question9.questionInitMulti("4","2","1","3");
        question10.questionInitMulti("4","2","1","0");

        getQuestionDAO().save(question1);
        getQuestionDAO().save(question2);
        getQuestionDAO().save(question3);
        getQuestionDAO().save(question4);
        getQuestionDAO().save(question5);
        getQuestionDAO().save(question6);
        getQuestionDAO().save(question7);
        getQuestionDAO().save(question8);
        getQuestionDAO().save(question9);
        getQuestionDAO().save(question10);

        quiz1.addQuestion(question1);
        quiz1.addQuestion(question2);
        quiz1.addQuestion(question3);
        quiz1.addQuestion(question4);
        quiz1.addQuestion(question5);
        quiz1.addQuestion(question6);
        quiz1.addQuestion(question7);
        quiz1.addQuestion(question8);
        quiz1.addQuestion(question9);
        quiz1.addQuestion(question10);

        Question question01 = new Question("I'm eating _____ apple,","Easy",diamantis,course2);
        Question question02 = new Question("I ___ fat.","Easy",diamantis,course2);
        Question question03 = new Question("You are ____.","Easy",diamantis,course2);
        Question question04 = new Question("She ___ a bad person.","Easy",diamantis,course2);
        Question question05 = new Question("What is a banana?","Easy",diamantis,course2);
        Question question06 = new Question("What word means the same as funny?","Easy",diamantis,course2);

        question01.questionInitMulti("an","am","on","in");
        question02.questionInitMulti("am","an","on","in");
        question03.questionInitMulti("playing","playd","play","played");
        question04.questionInitMulti("is","off","is","are");
        question05.questionInitMulti("A fruit","Clothing","Martial Art","Dog Breed");
        question06.questionInitMulti("Hilarious","Sick","Angry","Loved");

        getQuestionDAO().save(question01);
        getQuestionDAO().save(question02);
        getQuestionDAO().save(question03);
        getQuestionDAO().save(question04);
        getQuestionDAO().save(question05);
        getQuestionDAO().save(question06);

        quiz2.addQuestion(question01);
        quiz2.addQuestion(question02);
        quiz2.addQuestion(question03);
        quiz2.addQuestion(question04);
        quiz2.addQuestion(question05);
        quiz2.addQuestion(question06);

        Question question001 = new Question("What is Linux?","Easy",giakoumakis,course3);
        Question question002 = new Question("What is famous for being used on web development?","Easy",giakoumakis,course3);
        Question question003 = new Question("What is Facebook?","Easy",giakoumakis,course3);
        Question question004 = new Question("Write 2 in binary.","Easy",giakoumakis,course3);
        Question question005 = new Question("What's 100 in decimal?","Easy",giakoumakis,course3);
        Question question006 = new Question("What coding language is mostly used for back end development?","Easy",giakoumakis,course3);

        question001.questionInitMulti("Operating System","Mobile App","Coding Language","Nothing");
        question002.questionInitMulti("HTML","C++","BASIC","PYTHON");
        question003.questionInitMulti("Social Media Website","Framework","Search Engine","Browser");
        question004.questionInitMulti("10","01","11","00");
        question005.questionInitMulti("4","2","1","0");
        question006.questionInitMulti("SQL","JAVASCRIPT","PYTHON","RUBY");

        getQuestionDAO().save(question001);
        getQuestionDAO().save(question002);
        getQuestionDAO().save(question003);
        getQuestionDAO().save(question004);
        getQuestionDAO().save(question005);
        getQuestionDAO().save(question006);

        quiz3.addQuestion(question001);
        quiz3.addQuestion(question002);
        quiz3.addQuestion(question003);
        quiz3.addQuestion(question004);
        quiz3.addQuestion(question005);
        quiz3.addQuestion(question006);

        getQuizDAO().save(quiz1);
        getQuizDAO().save(quiz2);
        getQuizDAO().save(quiz3);
    }

    /**
     * Returns DAO of users.
     *
     * @return {@link User} DAO
     */
    public abstract UserDAO getUserDAO();

    /** Returns DAO of courses.
     * @return {@link Course} DAO
     */
    public abstract CourseDAO getCourseDAO();

    /** Returns DAO of quizes.
     * @return {@link Quiz} DAO
     */
    public abstract QuizDAO getQuizDAO();

    /** Returns DAO of questions.
     * @return {@link Question} DAO
     */
    public abstract QuestionDAO getQuestionDAO();

    /** Returns DAO of completed quizes.
     * @return {@link CompletedQuizDAO} DAO
     */
    public abstract CompletedQuizDAO getCompletedQuizDAO();
}