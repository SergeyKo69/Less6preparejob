package ru.kogut.repository.service;

import ru.kogut.dao.RoleDAO;
import ru.kogut.model.RoleEntity;
import ru.kogut.repository.RoleRepository;

import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public class RoleService implements RoleRepository {

    private final RoleDAO roleDAO;

    public RoleService() {
        this.roleDAO = new RoleDAO();
    }

    public void create(RoleEntity role) {
        roleDAO.create(role);
    }

    public List<RoleEntity> findAll() {
        return roleDAO.findAll();
    }

    public List<String> findByIDs(String[] ids) {
        return roleDAO.findByIDs(ids);
    }

    public RoleEntity findOne(String id) {
        return roleDAO.findOne(id);
    }

    public void update(RoleEntity role) {
        roleDAO.update(role);
    }

    public void deleteById(String id) {
        roleDAO.deleteById(id);
    }

    public void delete(RoleEntity role) {
        roleDAO.delete(role);
    }
}
