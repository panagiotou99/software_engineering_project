package com.example.dao.daoStub;
import com.example.domain.Question;
import com.example.domain.User;

import java.util.List;

/** Data Access Object for doing CRUD operations related to {@link Question}
 *
 * @author Panagiotis Panagiotou
 * @author Elena Fourtouni
 * @author Olga Margeli
 */
public interface QuestionDAO {

    /**
     * Find a {@link Question}
     *
     * @param code the code used to identify the specific question
     * @return The Question or {@code null} if no user found with such credentials.
     */
    public Question find(String code);

    /**
     * Either saves the {@link Question} in storage or updates an existing one if already exists
     *
     * @param question The question you want to either save or update in storage.
     */
    public void save(Question question);

    /**
     * Removes the {@link Question}
     *
     * @param question The object of a Question
     */
    public void delete(Question question);

    /**
     * Returns all  {@link Question} objects
     *
     */
    public List<Question> findAll();

    /**
     * @return A unique integer identifier for next saved {@link Question}
     */
    int nextId();
}
