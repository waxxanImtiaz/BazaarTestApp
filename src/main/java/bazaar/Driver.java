package bazaar;

import bazaar.entities.Item;
import bazaar.repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
@ComponentScan
public class Driver {
    public static void main(String[] args) {
        SpringApplication.run(Driver.class,args);
    }

    @Bean
    public CommandLineRunner demo(ItemRepository repository) {
        return (args) -> {

            List<Item> itemList = new ArrayList<>();
            Item item1 = new Item();
            item1.setId(1L);
            item1.setCategory("Phone");
            item1.setDate((new Date()).toString());
            item1.setItemName("OPPO A37");
            item1.setLocation("PECHS Block 6");
            item1.setPhoneNumber("03002639694");
            item1.setPrice("Rs.14,000");
            item1.setImages("images/products/1.jpg");
            item1.setPublisherId("Imtiaz Ali");
            itemList.add(item1);


            Item item2 = new Item();
            item2.setId(2L);
            item2.setCategory("Phone");
            item2.setDate((new Date()).toString());
            item2.setItemName("Samsung S8");
            item2.setLocation("DHA Phase 2");
            item2.setPhoneNumber("03112231321");

            item2.setImages("images/products/2.jpg");
            item2.setPrice("Rs.65,000");
            item2.setPublisherId("Kamran");
            itemList.add(item2);


            Item item3 = new Item();
            item3.setId(3L);
            item3.setCategory("Phone");
            item3.setDate((new Date()).toString());
            item3.setItemName("Samsung Note 8");
            item3.setLocation("Mallir Cantt");
            item3.setPhoneNumber("03322311232");
            item3.setPrice("Rs.105,000");
            item3.setImages("images/products/1.jpg");
            item3.setPublisherId("Zeeshan");
            itemList.add(item3);


            Item item4 = new Item();
            item4.setId(4L);
            item4.setCategory("Phone");
            item4.setDate((new Date()).toString());
            item4.setItemName("Samsung 8");
            item4.setLocation("Mallir Cantt");
            item4.setPhoneNumber("03322311232");
            item4.setPrice("Rs.105,000");
            item4.setImages("images/products/4.jpg");
            item4.setPublisherId("Zeeshan");
            itemList.add(item4);




            Item item5 = new Item();
            item5.setId(4L);
            item5.setCategory("Phone");
            item5.setDate((new Date()).toString());
            item5.setItemName("Samsung 8");
            item5.setLocation("Mallir Cantt");
            item5.setPhoneNumber("03322311232");
            item5.setPrice("Rs.105,000");
            item5.setImages("images/products/4.jpg");
            item5.setPublisherId("Zeeshan");
            itemList.add(item5);

            Item item6 = new Item();
            item6.setId(4L);
            item6.setCategory("Phone");
            item6.setDate((new Date()).toString());
            item6.setItemName("Samsung 8");
            item6.setLocation("Mallir Cantt");
            item6.setPhoneNumber("03322311232");
            item6.setPrice("Rs.105,000");
            item6.setImages("images/products/4.jpg");
            item6.setPublisherId("Zeeshan");
            itemList.add(item6);



            repository.saveAll(itemList);




        };
    }
}
