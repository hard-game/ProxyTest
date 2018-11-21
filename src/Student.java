public class Student implements Person{
    public String name;

    public Student(String name){
        this.name=name;
    }
    @Override
    public void say(String word) {
        System.out.println(word);
    }
}
