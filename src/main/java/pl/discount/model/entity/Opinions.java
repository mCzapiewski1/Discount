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
@Table(name="opinions")
public class Opinions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="opinion_id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="content")
	private String content;
	
	@Column(name="add_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addDate;
	
	@Column(name="ipaddress")
	private String ipaddress;
	
	@ManyToOne
	@JoinColumn(name="discount_id")
	private Discount discount;
	

	public Opinions(String title, String author, String content, LocalDate addDate, String ipaddress) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.addDate = addDate;
		this.ipaddress = ipaddress;
	}
	
	public Opinions() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
}
