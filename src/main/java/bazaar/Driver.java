package bazaar;

import bazaar.beans.Engine;
import bazaar.component.TestComponent;
import bazaar.entities.Categories;
import bazaar.entities.CategoryItems;
import bazaar.entities.Item;
import bazaar.repositories.CategoriesRepo;
import bazaar.repositories.CategoryItemRepo;
import bazaar.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
//@EnableEurekaClient
public class Driver implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    @Qualifier("bus")
    private Engine engine;
    public static void main(String[] args) {

        SpringApplication.run(Driver.class,args);
    }

    public void testAppContext(){

    }

    @Override
    public void run(String... args) throws Exception {
        TestComponent testComponent = (TestComponent) applicationContext.getBean("test1");
        System.out.println(testComponent.getName());
        engine.makeEngine();
    }

    }
