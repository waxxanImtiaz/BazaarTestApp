package client.repositories;

import client.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.id = :id")
    Item findItemById(@Param("id") Long Id);


    @Query("SELECT i FROM Item i WHERE i.itemName like %:searchVal% or i.category like %:searchVal% or i.location like %:searchVal% or i.date like %:searchVal%" +
            " or i.phoneNumber like %:searchVal% or i.price like %:searchVal% or i.price like %:searchVal%")
    Item searchItem(@Param("searchVal") String searchVal);
}
