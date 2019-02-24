package client;

import client.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class FrontController {


    @Autowired
    private ItemService itemService;

    @RequestMapping(produces = "application/json",value = "/list/{category}")
    public List getItemsByCategory(@PathVariable String category){
        return itemService.getItemsByCategory(category);
    }

    @RequestMapping("/test")
    public String hello(){
        return "Hello i am server";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/search{formData}")
    public String search(@PathVariable String formData){
        return "Your have entered "+formData;
    }


    @RequestMapping("/item/{id}")
    public Item getItem(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item")
    public String uploadItem(@RequestBody Item item){
        if (itemService.uploadItem(item)){
            return "Item uploaded successfully!";
        }
        return "Item not uploaded";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/item")
    public String updateItem(@RequestBody Item item){
        if (itemService.uploadItem(item)){
            return "Item updated successfully!";
        }
        return "Item not updated";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/item/{id}")
    public String saveStudent(@PathVariable Long id){
        if (itemService.deleteItem(id)){
            return "Item deleted successfully!";
        }
        return "Item not deleted";
    }



}
