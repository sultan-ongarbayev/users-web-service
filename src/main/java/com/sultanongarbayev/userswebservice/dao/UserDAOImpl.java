package com.sultanongarbayev.userswebservice.dao;

import com.sultanongarbayev.userswebservice.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public boolean updateUser(User user) {
        User userToUpdate = getUserById(user.getId());
        if (userToUpdate == null) {
            return false;
        }
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        entityManager.flush();
        return true;
    }

    // returns null if no user with id found
    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> getAllUsers() {
        String hqlQuery = "FROM User";
        List<User> result = (List<User>) entityManager.createQuery(hqlQuery).getResultList();
        return result;
    }

    @Override
    public boolean deleteUser(int userId) {
        User userToDelete = getUserById(userId);
        if (userToDelete == null) {
            return false;
        }
        entityManager.remove(userToDelete);
        entityManager.flush();
        return true;
    }
}
