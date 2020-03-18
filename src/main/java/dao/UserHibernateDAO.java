package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private SessionFactory sessionFactory;

    public UserHibernateDAO() {
        this.sessionFactory = DBHelper.getInstance().getSessionFactory();
    }

    @Override
    public void addUser(User added) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(added);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(User deleted) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleted);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User updated) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(updated);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> allUsers = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return allUsers;
    }

    @Override
    public User getUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User WHERE id = :id ")
                .setParameter("id", id)
                .list();
        session.close();
        return list.get(0);
    }

    @Override
    public boolean isExistUser(User verifiable) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User WHERE firstName = :firstName AND password = :password ")
                .setParameter("firstName", verifiable.getFirstName())
                .setParameter("password", verifiable.getPassword())
                .list();
        session.close();
        return !list.isEmpty();
    }

    @Override
    public User getUserByName(String firstName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User WHERE firstName = :firstName ")
                .setParameter("firstName", firstName)
                .list();
        session.close();
        return list.get(0);
    }

    @Override
    public String getRoleByUser(User user) throws java.lang.IndexOutOfBoundsException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User WHERE firstName = :firstName AND password = :password ")
                .setParameter("firstName", user.getFirstName())
                .setParameter("password", user.getPassword())
                .list();
        session.close();
        return list.get(0).getRole();
    }
}
