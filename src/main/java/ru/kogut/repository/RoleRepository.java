package ru.kogut.repository;

import ru.kogut.model.RoleEntity;

import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public interface RoleRepository {

    void create(RoleEntity role);

    List<RoleEntity> findAll();

    List<String> findByIDs(String[] ids);

    RoleEntity findOne(String id);

    void update(RoleEntity role);

    void deleteById(String id);

    void delete(RoleEntity role);

}
