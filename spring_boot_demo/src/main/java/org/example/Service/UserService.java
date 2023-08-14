package org.example.Service;

import org.example.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    UserDao userDao;

    public void getUserList() {
        List<String> list = userDao.queryUserList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
