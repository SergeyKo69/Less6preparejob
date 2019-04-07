package ru.kogut.repository;

import ru.kogut.model.UserEntity;
import ru.kogut.model.UserRoleEntity;

import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public interface UserRoleRepository {

    void create(UserRoleEntity userRole);

    List<UserRoleEntity> findAll();

    UserRoleEntity findOne(String id);

    List<UserRoleEntity> findByUserId(String userId);

    List<UserRoleEntity> findByRoleId(String roleId);

    List<UserRoleEntity> findByUser(UserEntity user);

    void update(UserRoleEntity userRole);

    void deleteById(String id);

    void delete(UserRoleEntity userRole);

}
