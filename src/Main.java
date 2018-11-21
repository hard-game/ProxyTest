
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Throwable{
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        Student student=new Student("张三");
        PersonProxy personProxy=new PersonProxy(new Teacher());
        Person person=(Person) Proxy.newProxyInstance(Main.class.getClassLoader(),new Class[]{Person.class},personProxy);

        Class stuc=student.getClass();
        Field field=stuc.getDeclaredField("name");
        System.out.println(field.get(new Student("李四")));

        //生成的代理类的名字
        System.out.println(person.getClass().getName());
        //加载在缓存中的代理类
        Class c=person.getClass();
        //遍历方法
        Method[] meth=c.getDeclaredMethods();
        for (Method meth2 : meth) {
            System.out.println(meth2.getName());
        }
        System.out.println();
        //加载属性
        Field[] fields=c.getDeclaredFields();
        for(Field f:fields){
            f.setAccessible(true);
            System.out.println(f.getName());
            System.out.println(f.get(person));
            System.out.println();
        }
        //父类
        Class father=c.getSuperclass();
        Field[] fields1=father.getDeclaredFields();
        for(Field f:fields1){
            f.setAccessible(true);
            System.out.println(f.getName());
        }

        person.say("hello world");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        //动态代理中Proxy.newProxyInstance方法中可以有多个接口实现，即多个接口的实现类都要被代理，aop；
        //动态代理会生成一个$Proxy0类，存在在缓存中，继承Proxy和实现了Person接口，在类中调用了PersonProxy的invoke方法
        //何时插入PersonProxy的问题？

        //java -classpath "%JAVA_HOME%/lib/sa-jdi.jar" sun.jvm.hotspot.HSDB
        //https://www.jianshu.com/p/24a80cb6d448
    }
}
