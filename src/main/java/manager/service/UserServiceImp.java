package manager.service;

import manager.model.User;
import manager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

   public UserServiceImp(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getAllUsers() {
      return userRepository.getAllUsers();
   }

   @Transactional
   @Override
   public void createUser(User user) {
      userRepository.createUser(user);
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userRepository.updateUser(user);
   }

   @Override
   public User getUserById(long id) {
      return userRepository.getUserById(id);
   }

   @Transactional
   @Override
   public User deleteUserById(long id) {
      User user = null;
      try {
         user = userRepository.deleteUserById(id);
      } catch (NullPointerException e) {
         e.printStackTrace();
      }
      return user;
   }

   @Transactional
   @Override
   public void deleteAllUsers(){
      userRepository.deleteAllUsers();
   }

}
