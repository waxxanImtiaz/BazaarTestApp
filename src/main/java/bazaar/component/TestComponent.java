package bazaar.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("test1")
public class TestComponent {
    @PostConstruct
    public void init(){
        System.out.println("TestComponent is initialized");
    }
    public String getName(){
        return "Test 1 comp";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }
}
