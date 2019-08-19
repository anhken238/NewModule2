package repsitory;

import model.User;
import model.Login;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> user;
    static {
        user = new ArrayList<>();
        User user1 = new User();
        user1.setAccount("hoang");
        user1.setPassword("123");
        user1.setName("Nguyen Thi Hoang");
        user1.setAge(8);
        user1.setEmail("hoangbede@gmail.com");
        user.add(user1);

        User user2 = new User();
        user2.setAccount("anh");
        user2.setPassword("123");
        user2.setName("Nguyen Duc Anh");
        user2.setAge(10000);
        user2.setEmail("ducanh@gmail.com");
        user.add(user2);

        User user3 = new User();
        user3.setAccount("tin");
        user3.setPassword("123");
        user3.setName("Tin Idol");
        user3.setAge(7);
        user3.setEmail("tinbede@gmail.com");
        user.add(user3);
    }
    public static User checkLogin(Login login) {

        for (User u : user) {
            if ((u.getAccount().equals(login.getAccount())) && (u.getPassword().equals(login.getPassword()))) {
                return u;
            }
        }
        return null;
    }
}
