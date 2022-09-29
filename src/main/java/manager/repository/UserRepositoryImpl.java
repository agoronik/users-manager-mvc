package manager.repository;

import manager.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements  UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public void createUser(User user) {
        em.persist(user);
        em.flush();
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
        em.flush();
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User deleteUserById(long id) {
        User user = getUserById(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        em.remove(user);
        em.flush();
        return user;
    }

    @Override
    public void deleteAllUsers() {
        em.createNativeQuery("truncate table users").executeUpdate();
    }

}
