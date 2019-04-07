package ru.kogut.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.kogut.model.UserEntity;
import ru.kogut.model.UserRoleEntity;
import ru.kogut.repository.UserRoleRepository;
import ru.kogut.utils.HibernateSessionFactoryUtil;

import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public class UserRoleDAO implements UserRoleRepository {

    public void create(UserRoleEntity userRole) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(userRole);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
    }

    public List<UserRoleEntity> findAll() {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final List<UserRoleEntity> userRoleList = session.createQuery("FROM UserRoleEntity", UserRoleEntity.class).list();
        if (session.isOpen()) session.close();
        return userRoleList;
    }

    public UserRoleEntity findOne(String id) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final UserRoleEntity userRole = session.get(UserRoleEntity.class, id);
        if (session.isOpen()) session.close();
        return userRole;
    }

    public List<UserRoleEntity> findByUserId(String userId) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final Query query = session.createQuery("FROM UserRoleEntity WHERE userId =:userId");
        query.setParameter("userId", userId);
        final List<UserRoleEntity> userRoleList = query.list();
        if (session.isOpen()) session.close();
        return userRoleList;
    }

    public List<UserRoleEntity> findByRoleId(String roleId) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final Query query = session.createQuery("FROM UserRoleEntity WHERE roleId =:roleId");
        query.setParameter("roleId", roleId);
        final List<UserRoleEntity> userRoleList = query.list();
        if (session.isOpen()) session.close();
        return userRoleList;
    }

    public List<UserRoleEntity> findByUser(UserEntity user) {
        return findByUserId(user.getId());
    }

    public void update(UserRoleEntity userRole) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(userRole);
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
            final Query query = session.createQuery("DELETE UserRoleEntity WHERE id =:id");
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

    public void delete(UserRoleEntity userRole) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(userRole);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
    }
}
