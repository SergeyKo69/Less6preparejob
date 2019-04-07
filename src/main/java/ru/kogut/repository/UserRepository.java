package ru.kogut.repository;

import ru.kogut.model.UserEntity;

import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public interface UserRepository {

    void create(UserEntity user);

    List<UserEntity> findAll();

    List<String> findUserRoles(String id);

    UserEntity findOne(String id);

    UserEntity findByLoginAndPassword(String login, String password);

    UserEntity findByLogin(String login);

    void update(UserEntity user);

    void deleteById(String id);

    void delete(UserEntity user);

}
