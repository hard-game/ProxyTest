package InterfaceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IhelloProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("Proxy Interface");
        return null;
    }

    public static <T> T newProxy(Class<T> inter){
        ClassLoader classLoader=inter.getClassLoader();
        Class<?>[] classes=new Class[]{inter};
        IhelloProxy proxy=new IhelloProxy();
        return (T) Proxy.newProxyInstance(classLoader,classes,proxy);
    }
}
