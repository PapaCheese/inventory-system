package guy.swaggerDemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int number;
	private String name;
	private int amount;
	private long inventoryCode;

	public Item() {}
	
	public Item(int number, String name, int amount, long inventoryCode) {
		super();
		this.number = number;
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}
	
	public Item(long id, int number, String name, int amount, long inventoryCode) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemNumber() {
		return number;
	}

	public void setItemNumber(int itemNumber) {
		this.number = itemNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void withdrawAmount(int amount) {
		this.amount -= amount;
	}

	public void depositAmount(int amount) {
		this.amount += amount;
	}

	public long getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(int inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemNumber=" + number + ", name=" + name + ", amount=" + amount
				+ ", inventoryCode=" + inventoryCode + "]";
	}

}
