package com.example.dao.daoMemory;
import com.example.dao.daoStub.CompletedQuizDAO;
import com.example.dao.daoStub.CourseDAO;
import com.example.dao.daoStub.QuestionDAO;
import com.example.dao.daoStub.QuizDAO;
import com.example.dao.daoStub.UserDAO;
import com.example.dao.daoStub.Initializer;
import com.example.domain.CompletedQuiz;
import com.example.domain.Course;
import com.example.domain.Question;
import com.example.domain.Quiz;
import com.example.domain.User;


public class MemoryInitializer extends Initializer {


    /**
     * Διαγράφει τα αποθηκευμένα δεδομένα.
     */
    @Override
    protected void eraseData() {

        for(User user : getUserDAO().findAll()) {
            getUserDAO().delete(user);
        }

        for(Course course : getCourseDAO().findAll()) {
            getCourseDAO().delete(course);
        }

        for(Quiz quiz : getQuizDAO().findAll()) {
            getQuizDAO().delete(quiz);
        }

        for (Question question: getQuestionDAO().findAll()){
            getQuestionDAO().delete(question);
        }

        for (CompletedQuiz completedQuiz: getCompletedQuizDAO().findAll()){
            getCompletedQuizDAO().delete(completedQuiz);
        }
    }

    /**
     * Επιστρέφει το DAO των χρηστών.
     * @return Το DAO των χρηστών
     */
    @Override
    public UserDAO getUserDAO()
    {
        return new UserDAOMemory();
    }

    /**
     * Επιστρέφει το DAO των μαθημάτων.
     * @return Το DAO των μαθημάτων δανειζομένων
     */
    @Override
    public CourseDAO getCourseDAO()
    {
        return new CourseDAOMemory();
    }

    /**
     * Επιστρέφει το DAO των quiz.
     * @return Το DAO των quiz
     */
    @Override
    public QuizDAO getQuizDAO() {
        return new QuizDAOMemory();
    }

    /**
     * Επιστρέφει το DAO των ερωτήσεων.
     * @return Το DAO των quiz
     */
    @Override
    public QuestionDAO getQuestionDAO(){
        return new QuestionDAOMemory();
    }

    @Override
    public CompletedQuizDAO getCompletedQuizDAO(){
        return new CompletedQuizDAOMemory();
    }
}
