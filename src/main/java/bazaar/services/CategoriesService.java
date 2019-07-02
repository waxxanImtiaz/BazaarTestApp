package bazaar.services;

import bazaar.entities.Categories;
import bazaar.repositories.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepo categoriesRepo;
//    public List<Categories> getAllCategories(){
//        return categoriesRepo.getAll();
//    }
}
