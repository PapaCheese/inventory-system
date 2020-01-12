package guy.swaggerDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guy.swaggerDemo.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	Item findById(long id);
	Item findByNumber(int number);
}