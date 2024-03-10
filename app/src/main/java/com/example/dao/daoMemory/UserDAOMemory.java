package com.example.dao.daoMemory;

import com.example.dao.daoStub.UserDAO;
import com.example.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMemory implements UserDAO {
    protected static ArrayList<User> usersList = new ArrayList<>();

    /**
     * Find a {@link User}
     *
     * @param email Email used when user registered in app
     * @param password user's password
     * @return The User or {@code null} if no user found with such credentials.
     */
    public User getUserfromCredentials(String email, String password){
        for (User user : usersList) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Either saves the {@link User} in storage or updates an existing one if already exists
     *
     * @param user The user you want to either save or update in storage.
     */
    public void registerUser(User user){
        usersList.add(user);
    }

    /**
     * Removes the {@link User}
     *
     * @param user The object of a User
     */
    public void delete(User user) {
        usersList.remove(user);
    }


    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(usersList);
        return users;
    }
}
