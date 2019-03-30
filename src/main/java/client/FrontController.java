package client;

import client.api.BaseExecutor;
import client.api.BaseResponse;
import client.custom.exceptions.DataNotFoundException;
import client.repositories.ItemRepository;
import client.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class FrontController {


    @Autowired
    private ItemService itemService;


    @RequestMapping(produces = "application/json", value = "/list/{category}")
    public List getItemsByCategory(@PathVariable String category) {
        return itemService.getItemsByCategory(category);
    }

    @RequestMapping("/test")
    public String hello() {
        return "Hello i am server";
    }

    /*================SEARCHING MEHTOD======================*/
    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/search/{formData}")
    public BaseResponse search(@PathVariable String formData) {

        try {
            List data = itemService.getItem(formData);

            if (data.size()>0)
                return BaseExecutor.getBaseResponse(data, "", "0");
            else
                throw  new DataNotFoundException("Search Not Found");

        } catch (Exception e) {
            return BaseExecutor.getBaseResponse(null, e.getMessage(), "-1");

        }
    }


    @RequestMapping("/item/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item")
    public String uploadItem(@RequestBody Item item) {
        if (itemService.uploadItem(item) != null) {
            return "Item uploaded successfully!";
        }
        return "Item not uploaded";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/item")
    public String updateItem(@RequestBody Item item) {
        if (itemService.updateItem(item) != null) {
            return "Item updated successfully!";
        }
        return "Item not updated";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/item/{id}")
    public String saveStudent(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully!";
    }


}
