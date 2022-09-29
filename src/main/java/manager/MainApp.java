package manager;

import manager.config.AppConfig;
import manager.model.User;
import manager.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      //userService.deleteAllUsers();

      userService.deleteAllUsers();

      userService.createUser(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.createUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.createUser(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.createUser(new User("User4", "Lastname4", "user4@mail.ru"));

      //List<User> users = userService.getAllUsers();
      //System.out.println(users);
      /*
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      * */

      context.close();
   }
}
