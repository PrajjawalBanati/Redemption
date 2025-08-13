abstract class A{
    public static void run(){
        System.out.println("From A");
    }
    public abstract void inherit();

}

class B extends A{

    public static void run()
    {
        System.out.println("From B");
    }

    @Override
    public void inherit(){
        System.out.println("Inherited from B");
    }
}

public class StaticAndAbstractMethods{
    
    public static void main(int num) {
        A b = new B();
        b.inherit();
        B.run();
        System.out.println(num);
    }

    public static void main(String[] args) {
        A b = new B();
        b.run();
    }
}