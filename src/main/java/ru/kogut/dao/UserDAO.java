package ru.kogut.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.kogut.model.UserEntity;
import ru.kogut.model.UserRoleEntity;
import ru.kogut.repository.UserRepository;
import ru.kogut.service.RoleService;
import ru.kogut.service.UserRoleService;
import ru.kogut.utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 2019-03-25
 */
public class UserDAO implements UserRepository {

   private final UserRoleService userRoleService = new UserRoleService();
   private final RoleService roleService = new RoleService();

   public void create(UserEntity user) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            if (session.isOpen()) session.close();
        }
    }

    public List<UserEntity> findAll() {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final List<UserEntity> userList = session.createQuery("FROM UserEntity", UserEntity.class).list() ;
        if (session.isOpen()) session.close();
        return userList;
    }

    public List<String> findUserRoles(String id) {
        final List<UserRoleEntity> listUserRole = userRoleService.findByUserId(id);
        final String[] listIds = new String[listUserRole.size()];

        for (int i = 0; i < listUserRole.size(); i++) {
            listIds[i] = listUserRole.get(i).getRoleId();
        }

        return roleService.findByIDs(listIds);
    }

    public UserEntity findOne(String id) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        final UserEntity user = session.get(UserEntity.class,id);
        if (session.isOpen()) session.close();
        return user;
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            final Query query = session.createQuery("FROM UserEntity " +
                    "WHERE login=:login AND password=:password", UserEntity.class);
            query.setParameter("login", login);
            query.setParameter("password", password);
            final List<UserEntity> userList = query.list();
            if (userList.size() >0) return userList.get(0);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
        return null;
    }

    public UserEntity findByLogin(String login) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            final Query query = session.createQuery("FROM UserEntity " +
                    "WHERE login=:login", UserEntity.class);
            query.setParameter("login", login);
            final List<UserEntity> userList = query.list();
            if (userList.size() >0) return userList.get(0);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) session.close();
        }
        return null;
    }

    public void update(UserEntity user) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            if (session.isOpen()) session.close();
        }
    }

    public void deleteById(String id) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            final Query query = session.createQuery("DELETE UserEntity WHERE id =:id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            if (session.isOpen()) session.close();
        }

    }

    public void delete(UserEntity user) {
        final Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
        }finally {
            if (session.isOpen()) session.close();
        }
    }
}
