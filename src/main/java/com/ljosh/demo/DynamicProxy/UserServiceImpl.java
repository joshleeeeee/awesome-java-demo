package com.ljosh.demo.DynamicProxy;

/**
 * @author joshlind
 * @date 2025/05/17
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("真实对象：正在添加用户：" + username);
    }

    @Override
    public String findUser(String username) {
        System.out.println("真实对象：正在查找用户：" + username);
        return "找到了：" + username;
    }
}
