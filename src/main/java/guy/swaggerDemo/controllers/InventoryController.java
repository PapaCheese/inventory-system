package guy.swaggerDemo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guy.swaggerDemo.entities.Item;
import guy.swaggerDemo.repositories.ItemRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	ItemRepository repository;

	@GetMapping("get-all-items")
	public Collection<Item> getAllItems() {
		return repository.findAll();
	}

	@GetMapping("get-item/{id}")
	public Item getItem(@PathVariable long id) {
		return repository.findById(id);
	}
	
	@GetMapping("get-item-by-number/{id}")
	public Item getItemByNumber(@PathVariable int number) {
		return repository.findByNumber(number);
	}

	@GetMapping("withdraw-amount/{id}/{quantity}")
	public void WithdrawItem(@PathVariable long id, @PathVariable int quantity) {
		Item item = repository.findById(id);
		item.withdrawAmount(quantity);
		repository.save(item);
		System.out.println("withdrawn " + quantity + " from " + item);
	}

	@GetMapping("deposit-amount/{id}/{quantity}")
	public void DepositItem(@PathVariable long id, @PathVariable int quantity) {
		Item item = repository.findById(id);
		item.depositAmount(quantity);
		repository.save(item);
		System.out.println("deposited " + quantity + " from " + item);

	}

	@PostMapping("create-item")
	public long createItem(@RequestBody Item item) {
		repository.save(item);
		return item.getId();
	}

	@DeleteMapping("delete-item")
	public void DeleteItem(@RequestBody Item item) {
		repository.delete(item);
	}

	@DeleteMapping("delete-item-by-id/{id}")
	public void DeleteItemById(@PathVariable long id) {
		Item item = repository.findById(id);
		repository.delete(item);
	}

}
