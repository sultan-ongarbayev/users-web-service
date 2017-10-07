package com.sultanongarbayev.userswebservice.dao;

import com.sultanongarbayev.userswebservice.model.User;

import java.util.List;

/**
 * The User Data Access Object is the interface providing access to user related data.
 */
public interface UserDAO {

    /**
     * Saves the data associated with an user.
     *
     * @param user the data associated with the user to save.
     */
    void addUser(User user);

    /**
     * Updates the data associated with an existing user. Only the identifier of the user has to be the same.
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
