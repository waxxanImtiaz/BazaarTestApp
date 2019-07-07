package bazaar.repositories;

import bazaar.entities.CategoryItems;
import bazaar.entities.Categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryItemRepo extends CrudRepository<CategoryItems, Long> {
//
//        @Query("SELECT i FROM CategoryItems i WHERE i.categoryId = :categories_id")
        List<CategoryItems> getCategoryItemsByCategoryId(@Param("categories_id") String id);
}
