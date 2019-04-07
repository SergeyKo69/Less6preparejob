package ru.kogut.service;

import ru.kogut.dao.UserRoleDAO;
import ru.kogut.model.UserEntity;
import ru.kogut.model.UserRoleEntity;
import ru.kogut.repository.UserRoleRepository;

import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public class UserRoleService implements UserRoleRepository {

    private final UserRoleDAO userRoleDAO;

    public UserRoleService() {
        this.userRoleDAO = new UserRoleDAO();
    }

    public void create(UserRoleEntity userRole) {
        userRoleDAO.create(userRole);
    }

    public List<UserRoleEntity> findAll() {
        return userRoleDAO.findAll();
    }

    public UserRoleEntity findOne(String id) {
        return userRoleDAO.findOne(id);
    }

    public List<UserRoleEntity> findByUserId(String userId) {
        return userRoleDAO.findByUserId(userId);
    }

    public List<UserRoleEntity> findByRoleId(String roleId) {
        return userRoleDAO.findByRoleId(roleId);
    }

    public List<UserRoleEntity> findByUser(UserEntity user) {
        return userRoleDAO.findByUser(user);
    }

    public void update(UserRoleEntity userRole) {
        userRoleDAO.update(userRole);
    }

    public void deleteById(String id) {
        userRoleDAO.deleteById(id);
    }

    public void delete(UserRoleEntity userRole) {
        userRoleDAO.delete(userRole);
    }
}
