package ma.fstt.donation.repository;

import ma.fstt.donation.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByIsAvailableTrue();

    @Query("SELECT i.description FROM Item i WHERE i.id IN :itemIds")
    List<String> findNamesByIdIn(@Param("itemIds") List<Long> itemIds);
}
