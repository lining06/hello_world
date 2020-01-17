package org.mashibing.mockspring;

import org.junit.Test;
import org.mashibing.model.User;
import org.mashibing.service.UserService;

public class UserServiceTestInterface {

    @Test
    public void testAddUser() throws Exception{
        BeanFactory factory = new ClassPathXMLApplicationContext();
        UserService userService = (UserService) factory.getBean("userService");
//        UserDAO userDAO = (UserDAO) factory.getBean("user");
        User user = new User();
//        userService.setUserDAO(userDAO);
        userService.addUser(user);
    }
}
