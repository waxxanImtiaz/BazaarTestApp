package bazaar.beans;


public class Car implements Engine{
    @Override
    public void makeEngine() {
        System.out.println("This is car engine");
    }
}
