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
        userService.saveUser("Али", "Ельмурзаев", (byte) 31);
        userService.saveUser("Генадий", "Котов", (byte) 56);
        userService.saveUser("Иван", "Иванов", (byte) 67);


        List<User> userList = userService.getAllUsers();
        Iterator<User> iterator = userList.listIterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println("----------------------");
            System.out.println(user.getId() + " " +
                    user.getName() + " " +
                    user.getLastName() + " " +
                    user.getAge());
        }

        userService.cleanUsersTable();

        userService.removeUserById(1);

        userService.dropUsersTable();
        userService.dropUsersTable();

    }
}


