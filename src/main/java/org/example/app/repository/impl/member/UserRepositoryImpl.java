package org.example.app.repository.impl.member;

import org.example.app.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @Repository - анотування класів репозиторіїв.
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(User user) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "INSERT INTO User (firstName, lastName, phone) " +
                "VALUES (:firstName, :lastName, :phone)";
        MutationQuery query = session.createMutationQuery(hql);
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("lastName", user.getLastName());
        query.setParameter("phone", user.getPhone());
        return query.executeUpdate() > 0;
    }

    @Override
    public Optional<List<User>> fetchAll() {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<User> list = session.createQuery("FROM User",
                    User.class).list();
            return Optional.of(list);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean update(Long id, User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "UPDATE User SET firstName = :firstName, " +
                    "lastName = :lastName, " +
                    "phone = :phone " +
                    "WHERE id = :id";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter("phone", user.getPhone());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            User member = session.byId(User.class).load(id);
            session.remove(member);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<User> fetchById(Long id) {
        Optional<User> optional;
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "FROM User m WHERE m.id = :id";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("id", id);
            optional = query.uniqueResultOptional();
            return optional;
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
