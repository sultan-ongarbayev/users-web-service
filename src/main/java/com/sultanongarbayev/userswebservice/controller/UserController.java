package com.sultanongarbayev.userswebservice.controller;

import com.sultanongarbayev.userswebservice.Response;
import com.sultanongarbayev.userswebservice.UserException;
import com.sultanongarbayev.userswebservice.model.User;
import com.sultanongarbayev.userswebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * {@code /users} endpoint controller.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * {@link UserService} implementation. Injected automatically by Spring IoC Container.
     */
    @Autowired
    private UserService userService;

    /**
     * Saves the data associated with an user.
     *
     * @param user   the data associated with the user to save.
     * @param errors user data validation errors.
     * @return response to the client. Converted to the json format.
     * @throws UserException if the user data is not valid.
     */
    @PostMapping
    public ResponseEntity<Response> addUser(@Valid @RequestBody User user, Errors errors) throws UserException {
        if (errors.hasErrors()) {
            throw new UserException("User is not valid.");
        }
        userService.addUser(user);
        Response response = new Response(HttpStatus.CREATED.value(), "User has been added.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Updates the data associated with an existing user. Only the identifier of the user has to be the same.
     *
     * @param user   the new data of the user.
     * @param errors user data validation errors.
     * @return response to the client. Converted to the json format.
     * @throws UserException if the user data is not valid or user could not be found.
     */
    @PutMapping
    public ResponseEntity<Response> updateUser(@Valid @RequestBody User user, Errors errors) throws UserException {
        if (errors.hasErrors()) {
            throw new UserException("User is not valid.");
        }
        boolean result = userService.updateUser(user);
        if (!result) {
            throw new UserException("User with such ID doesn't exist.");
        }
        Response response = new Response(HttpStatus.OK.value(), "User has been updated.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Returns the data associated with an user.
     *
     * @param userId the identifier of the user whose data is to be retrieved.
     * @return the user data to the client. Converted to the json format.
     * @throws UserException if the user with requested identifier could not be found.
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public User getUserById(@PathVariable("id") int userId) throws UserException {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new UserException("User with such ID doesn't exist.");
        }
        return user;
    }

    /**
     * Returns the {@link List} of all users available at the moment.
     *
     * @return list of users. Converted to the json format.
     */
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Deletes an user.
     *
     * @param userId identifier of the user to be removed.
     * @return response to the client. Converted to the json format.
     * @throws UserException if the user with requested identifier could not be found.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") int userId) throws UserException {
        boolean result = userService.deleteUser(userId);
        if (!result) {
            throw new UserException("User with such ID does not exist.");
        }
        Response response = new Response(HttpStatus.OK.value(), "User has been deleted.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles exceptions of {@link UserException} class.
     *
     * @param e exception.
     * @return response to the client. Converted to the json format.
     */
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Response> exceptionHandler(Exception e) {
        Response response = new Response(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
