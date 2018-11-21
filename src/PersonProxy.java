import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonProxy implements InvocationHandler {

    Person person;
    public PersonProxy(Person person){
        this.person=person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("Person Proxy");
        method.invoke(person,args);
        return null;
    }
}
