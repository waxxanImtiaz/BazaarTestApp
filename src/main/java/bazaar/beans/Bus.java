package bazaar.beans;

import org.springframework.stereotype.Component;

@Component("bus")
public class Bus implements Engine{
    @Override
    public void makeEngine() {
        System.out.println("This is bus enginer");
    }
}
