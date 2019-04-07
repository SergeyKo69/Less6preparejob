package ru.kogut.repository.service;

import ru.kogut.dao.UserDAO;
import ru.kogut.model.UserEntity;
import ru.kogut.repository.UserRepository;

import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public class UserService implements UserRepository {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void create(UserEntity user) {
        userDAO.create(user);
    }

    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    public List<String> findUserRoles(String id) {
        return userDAO.findUserRoles(id);
    }

    public UserEntity findOne(String id) {
        return userDAO.findOne(id);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        return userDAO.findByLoginAndPassword(login, password);
    }

    public UserEntity findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    public void update(UserEntity user) {
        userDAO.update(user);
    }

    public void deleteById(String id) {
        userDAO.deleteById(id);
    }

    public void delete(UserEntity user) {
        userDAO.delete(user);
    }
}
