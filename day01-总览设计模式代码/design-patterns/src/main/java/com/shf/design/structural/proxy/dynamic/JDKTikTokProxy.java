package com.shf.design.structural.proxy.dynamic;

import com.shf.design.structural.decorator.LeiTikTok;
import com.shf.design.structural.decorator.ManTikTok;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKTikTokProxy<T> implements InvocationHandler {

    private T target;

    public JDKTikTokProxy(T target) {
        this.target = target;
    }

    public static<T> T getProxy(T t) {
//        ClassLoader loader,  当前被代理对象的类加载器
//        Class<?>[] interfaces, 当前被代理对象所实现的所有接口
//        InvocationHandler h  当前被代理对象执行目标方法的时候我们使用h可以定义拦截增强方法
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new JDKTikTokProxy<>(t)
        );
        return (T) o;
    }

    /**
     * 定义目标方法的拦截逻辑
     * @param proxy the proxy instance that the method was invoked on
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        反射执行
        System.out.println("真正执行被代理对象的方法");
        Object invoke = method.invoke(target, args);
        System.out.println("返回值："+invoke);
        return invoke;
    }
}
