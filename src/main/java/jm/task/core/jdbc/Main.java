package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        //userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Ali", "Elmurzaev", (byte) 31);
        userService.saveUser("Anton", "Palchikov", (byte) 29);
        userService.saveUser("Marina", "Koshkina", (byte) 22);

        //userService.removeUserById(1);
        //userService.removeUserById(2);
        //userService.cleanUsersTable();

        List<User> users = userService.getAllUsers();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println("----------------");
            System.out.println(user.getId() + " "
            + user.getName() + " " +
                    user.getLastName() + " " +
                    user.getAge());
        }

        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.createUsersTable();

    }
}


