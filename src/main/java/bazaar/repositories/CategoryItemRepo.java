package bazaar.repositories;

import bazaar.entities.CategoryItems;
import org.springframework.data.repository.CrudRepository;

public interface CategoryItemRepo extends CrudRepository<CategoryItems, Long> {
}
