package ru.kogut.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.kogut.model.RoleEntity;
import ru.kogut.repository.RoleRepository;
import ru.kogut.utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public class RoleDAO implements RoleRepository {

    public void create(RoleEntity role) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(role);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
    }

    public List<RoleEntity> findAll() {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final List<RoleEntity> roleList = session.createQuery("FROM RoleEntity", RoleEntity.class).list();
        if (session.isOpen()) session.close();
        return roleList;
    }

    public List<String> findByIDs(String[] ids) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final Query query = session.createQuery("FROM RoleEntity WHERE id in (:ids)", RoleEntity.class);
        query.setParameterList("ids", ids);
        final List<RoleEntity> listRole = query.list();
        final List<String> listRoleName = new ArrayList<String>();
        for (int i = 0; i < listRole.size(); i++) {
            listRoleName.add(listRole.get(i).getName());
        }
        if (session.isOpen()) session.close();

        return listRoleName;
    }

    public RoleEntity findOne(String id) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final RoleEntity role = session.get(RoleEntity.class, id);
        if (session.isOpen()) session.close();
        return role;
    }

    public void update(RoleEntity role) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(role);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
    }

    public void deleteById(String id) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            final Query query = session.createQuery("DELETE RoleEntity where id =:id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
    }

    public void delete(RoleEntity role) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(role);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
    }

}
