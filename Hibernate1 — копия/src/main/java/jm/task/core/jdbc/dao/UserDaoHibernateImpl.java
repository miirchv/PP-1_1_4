package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.Query;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    @Transactional

    public void createUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.getTransaction().begin();
            String newTable = "CREATE TABLE usershii" + "(id INTEGER not NULL AUTO_INCREMENT, " + " name VARCHAR(40), " + " lastName VARCHAR(40), " + " age INTEGER, " + " PRIMARY KEY ( id ))";
            session.createSQLQuery(newTable).addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    @Transactional

    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.getTransaction().begin();
            String dropTable = "DROP TABLE usershii";
            session.createSQLQuery(dropTable).addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    @Transactional

    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.getTransaction().begin();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception e) {

        }
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.getTransaction().begin();
            User user = session.get(User.class, (int) id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override

    public List<User> getAllUsers() throws SQLException {

        try {
            Session session = Util.getSessionFactory().openSession();
            session.getTransaction().begin();
            List<User> list = session.createQuery("select a from User a", User.class).getResultList();
            return list;
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.createSQLQuery("delete from usershii").executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
    }
}
