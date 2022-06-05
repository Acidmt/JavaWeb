package com.demo2.cn;

import java.util.HashMap;

public class DBUtil {
    private static DBUtil instance=new DBUtil();
    private HashMap<String,UserBean> users=new HashMap<String,UserBean>();
    public static DBUtil getInstance(){
        return instance;
    }
    public UserBean getUser(String userName){
        UserBean user=(UserBean) users.get(userName);
        return user;
    }
    public boolean insertUSer(UserBean user){
        if (user==null){
            return false;
        }
        String userName=user.getName();
        if(users.get(userName)!=null){
            return false;
        }
        users.put(userName,user);
        return  true;
    }

}
