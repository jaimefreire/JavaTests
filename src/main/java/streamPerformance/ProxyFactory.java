package streamPerformance;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object newInstance(Object ob)
    {
        return Proxy.newProxyInstance(ob.getClass().getClassLoader(), new Class<?>[]{Measurable.class}, new TracingInvocationHandler(ob));
    }
}
