package sib.coursework.authenticator.services;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import sib.coursework.authenticator.data.User;


@Slf4j
@Repository
public class RepositoryService {
    private final EntityManagerFactory factory;

    public RepositoryService() {
        this.factory = Persistence.createEntityManagerFactory("main");
    }

    public void addNewUser(User user) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            log.info("Пользователь успешно добавлен");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            log.error("Не удалось добавить пользователя", e);
            throw new RuntimeException("Ошибка при добавлении пользователя", e);
        } finally {
            manager.close();
        }
    }

    public User getUserByEmail(String email) {
        EntityManager manager = factory.createEntityManager();
        try {
            String jpql = "SELECT u FROM User u WHERE u.email = :email";
            TypedQuery<User> query = manager.createQuery(jpql, User.class);
            query.setParameter("email", email);

            return query.getSingleResult();
        } catch (NoResultException e) {
            log.error("Пользователь не найден");
            return null;
        } finally {
            manager.close();
        }
    }

    public void closeEntityManagerFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
