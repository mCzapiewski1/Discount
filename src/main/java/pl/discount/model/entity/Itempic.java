package pl.discount.model.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="itempic")
public class Itempic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="picture_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="add_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addDate;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Items items;
	
	public Itempic () {}

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

	public LocalDate getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}

	public Items getItem() {
		return items;
	}

	public void setItem(Items item) {
		this.items = item;
	}
}
