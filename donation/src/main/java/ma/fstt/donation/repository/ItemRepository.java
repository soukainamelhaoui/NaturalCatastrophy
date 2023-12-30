package ma.fstt.donation.repository;

import ma.fstt.donation.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByIsAvailableTrue();
}
