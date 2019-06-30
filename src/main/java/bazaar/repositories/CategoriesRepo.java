package bazaar.repositories;

import bazaar.entities.Categories;
import bazaar.entities.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriesRepo extends CrudRepository<Categories, Long> {
    @Query("SELECT i FROM Categories i")
    List getAll();
}
