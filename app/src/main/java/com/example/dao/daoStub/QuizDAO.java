package com.example.dao.daoStub;

import com.example.domain.Course;
import com.example.domain.Quiz;

import java.util.List;

/**
 * Data Access Object for doing CRUD operations related to {@link Quiz}
 *
 * @author Panagiotis Panagiotou
 * @author Elena Fourtouni
 * @author Olga Margeli
 */
public interface QuizDAO {

    /**
     * Find a {@link Quiz}
     *
     * @param quizCode The unique id of the quiz
     * @return The course object or {@code null} if not found.
     */
    public Quiz find(String quizCode);

    /**
     * Either saves the {@link Course} in storage or updates an existing one if already exists
     *
     * @param quiz The course you want to either save or update in storage.
     */
    public void save(Quiz quiz);

    /**
     * Removes the {@link Course}
     *
     * @param quiz The unique id of the course
     */
    public void delete(Quiz quiz);

    /**
     * Get all {@link Quiz}
     *
     * @return All {@link Quiz} that are in storage
     */
    public List<Quiz> findAll();
}

