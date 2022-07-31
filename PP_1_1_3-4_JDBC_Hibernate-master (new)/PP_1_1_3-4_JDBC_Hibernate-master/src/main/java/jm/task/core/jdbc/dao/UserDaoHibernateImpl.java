package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }
    private SessionFactory sessionFactory = Util.getSessionFactory();


    @Override
    public void createUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users2" + "(id INTEGER not NULL AUTO_INCREMENT, " + " name VARCHAR(40), " + " lastName VARCHAR(40), " + " age INTEGER, " + " PRIMARY KEY ( id ))").addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createSQLQuery("DROP TABLE IF EXISTS users2").addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = sessionFactory.openSession();
            transactional = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception e) {
            transactional.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = sessionFactory.openSession();
            transactional = session.beginTransaction();
            User user = session.get(User.class, (int) id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            transactional.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            list = session.createQuery("select a from User a", User.class).getResultList();
            session.close();
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = null;
        Transaction transactional = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.createSQLQuery("delete from users2").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            transactional.rollback();
        } finally {
            session.close();
        }
    }
}
