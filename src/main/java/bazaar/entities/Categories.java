package bazaar.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany
    private List<CategoryItems> categoryItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryItems> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<CategoryItems> categoryItems) {
        this.categoryItems = categoryItems;
    }
}
