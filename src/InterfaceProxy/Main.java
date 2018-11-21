package InterfaceProxy;

public class Main {
    public static void main(String[] args){
        Ihello ihello=IhelloProxy.newProxy(Ihello.class);
        ihello.say();
    }
}
