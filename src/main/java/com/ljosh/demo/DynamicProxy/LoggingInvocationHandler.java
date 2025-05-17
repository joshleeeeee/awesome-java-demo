package com.ljosh.demo.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author joshlind
 * @date 2025/05/17
 */
public class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy 是代理对象本身
        System.out.println("[日志]方法" + method.getName() + "开始执行，参数：" + (args != null ? Arrays.toString(args) : "无参数"));
        // 调用真实对象的方法
        Object result = method.invoke(target, args);
        System.out.println("[日志]方法" + method.getName() + "执行完毕，结果：" + result);
        return result;
    }
}
