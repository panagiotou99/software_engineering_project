package com.example.dao.daoStub;

import com.example.domain.Student;
import com.example.domain.Teacher;
import com.example.domain.User;

import java.util.List;

/** Data Access Object for doing CRUD operations related to {@link User} (both {@link Student} and {@link Teacher})
    *
    * @author Panagiotis Panagiotou
    * @author Elena Fourtouni
    * @author Olga Margeli
    */
public interface UserDAO {
    /**
     * Find a {@link User}
     *
     * @param email Email used when user registered in app
     * @param password user's password
     * @return The User or {@code null} if no user found with such credentials.
     */
    public User getUserfromCredentials(String email, String password);

    /**
     * Either saves the {@link User} in storage or updates an existing one if already exists
     *
     * @param user The user you want to either save or update in storage.
     */
    public void registerUser(User user);

    /**
     * Removes the {@link User}
     *
     * @param user The object of a User
     */
    public void delete(User user);

    /**
     * Returns all  {@link User} objects
     *
     */
    public List<User> findAll();
}
