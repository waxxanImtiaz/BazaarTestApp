package client.services;

import client.Item;
import client.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {
    private List<Item> itemList = new ArrayList<>();
    public ItemService(){
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



    }

    public List getItemsByCategory(String category){

        List<Item> byCategory = new ArrayList<>();
        for (Item item : itemList){
            if (item.getCategory().equals(category))
                byCategory.add(item);
        }
        return byCategory;
    }
    public Item getItemById(Long id) {
        return itemList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }



    public boolean uploadItem(Item item) {
        return itemList.add(item);
    }

    public boolean deleteItem(Long id) {
        return itemList.removeIf(pr -> pr.getId().equals(id));
    }

    public boolean updateItem(Item item) {

        for (int i = 0; i<itemList.size(); i++) {
            if (itemList.get(i).getId().equals(item.getId())){
                itemList.add(i,item);
                return true;
            }
        }
        return false;
    }

}
