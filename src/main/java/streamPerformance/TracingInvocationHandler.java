package streamPerformance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class TracingInvocationHandler implements InvocationHandler {

    Object obj;

    public TracingInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object args[])
            throws Throwable {
        Object retVal;
        Method targetMethod = null;
        try {
            System.out.println("Invoking: " + formatMethodOutput(method, args));
            Instant start = Instant.now();
            targetMethod = getMethodForTarget(method, method.getParameterTypes());
            retVal = targetMethod.invoke(obj, args);
            //performance mesurement
            System.out.println("Time to run: " + Duration.between(start, Instant.now()));
            //
        } catch (InvocationTargetException e) {
            //Exception reporting
            e.getTargetException().toString();
            //rethrowing the exception
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
        return retVal;
    }

    private Method getMethodForTarget(Method method, Class<?>[] parameterTypes) {
        return method;
    }

    private String formatMethodOutput(Method method, Object[] parameters) {
        return method.toGenericString() + "Params: " + Arrays.toString(parameters);
    }
}