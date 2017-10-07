package com.sultanongarbayev.userswebservice.service;

import com.sultanongarbayev.userswebservice.model.User;

import java.util.List;

/**
 * The User Service is the interface which holds business logic related to the {@link User} objects.
 */
public interface UserService {

    /**
     * Creates new user.
     *
     * @param user the data associated with the new user to create.
     */
    void addUser(User user);

    /**
     * Updates existing user's data. Only the identifier of the user has to be the same.
     *
     * @param user the new data of the user.
     * @return <tt>true</tt> if the user is updated, <tt>false</tt> otherwise.
     */
    boolean updateUser(User user);

    /**
     * Returns the data associated with an user.
     *
     * @param userId the identifier of the user whose data is to be retrieved.
     * @return the user data.
     */
    User getUserById(int userId);

    /**
     * Returns the {@link List} of all users available at the moment.
     *
     * @return list of users.
     */
    List<User> getAllUsers();

    /**
     * Deletes an user.
     *
     * @param userId the identifier of the user to delete.
     * @return <tt>true</tt> if deletion was successful, <tt>false</tt> otherwise.
     */
    boolean deleteUser(int userId);
}
