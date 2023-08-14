package org.example.Dao;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<String> queryUserList(){
        List<String> list =new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("User " + i);
        }
        return list;
    }
}
