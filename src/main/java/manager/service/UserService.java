package manager.service;
import manager.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User getUserById(long id);

    User deleteUserById(long id);

    void deleteAllUsers();
}
