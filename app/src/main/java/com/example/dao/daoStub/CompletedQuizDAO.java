package com.example.dao.daoStub;

import com.example.domain.CompletedQuiz;

import java.util.List;

public interface CompletedQuizDAO {
    /**
     * Find a {@link CompletedQuiz}
     *
     * @param quizCode The unique id of the completed quiz
     * @return The completed quiz object or {@code null} if not found.
     */
    public CompletedQuiz find(String quizCode);

    /**
     * Either saves the {@link CompletedQuiz} in storage or updates an existing one if already exists
     *
     * @param quiz The completed quiz you want to either save or update in storage.
     */
    public void save(CompletedQuiz quiz);

    /**
     * Removes the {@link CompletedQuiz}
     *
     * @param quiz The unique id of the completed quiz
     */
    public void delete(CompletedQuiz quiz);

    /**
     * Get all {@link CompletedQuiz}
     *
     * @return All {@link CompletedQuiz} that are in storage
     */
    public List<CompletedQuiz> findAll();
}
