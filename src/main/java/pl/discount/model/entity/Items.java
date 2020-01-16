package pl.discount.model.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="items")
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Float price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="add_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addDate;
	
	@ManyToOne
	@JoinColumn(name="discount_id")
	private Discount discount;
	
	@OneToMany(mappedBy="items")
	private Collection<Itempic> itemPics;
	
	public Items(int id, String name, Float price, String description, LocalDate addDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.addDate = addDate;
	}
	
	public Items() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Collection<Itempic> getItemPics() {
		return itemPics;
	}

	public void setItemPics(Collection<Itempic> itemPics) {
		this.itemPics = itemPics;
	}
}
