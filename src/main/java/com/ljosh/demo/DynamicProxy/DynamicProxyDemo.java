package com.ljosh.demo.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author joshlind
 * @date 2025/05/17
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        // 创建真实对象
        UserService realUserService = new UserServiceImpl();
        // 创建 InvocationHandler
        LoggingInvocationHandler loggingInvocationHandler = new LoggingInvocationHandler(realUserService);
        // 创建代理对象
        UserService proxyUserService = (UserService)Proxy.newProxyInstance(
                realUserService.getClass().getClassLoader(),
                realUserService.getClass().getInterfaces(),
                loggingInvocationHandler);
        // 通过代理对象调用方法
        proxyUserService.addUser("ljosh");
        System.out.println("----------------------");
        String user = proxyUserService.findUser("Bob");
        System.out.println("用户名：" + user);
    }

}
