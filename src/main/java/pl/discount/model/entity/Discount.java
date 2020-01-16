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
@Table(name="discount")
public class Discount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="discount_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="address3")
	private String address3;
	
	@Column(name="address4")
	private String address4;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nip")
	private String nip;
	
	@Column(name="add_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate addDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	
	@OneToMany(mappedBy="discount")
	private Collection<Items> items;
	
	@OneToMany(mappedBy="discount")
	private Collection<Opinions> opinions;

	public Discount(String name, String address1, String address2, String address3, String address4, String zip,
			String phoneNumber, String email, String nip, LocalDate addDate) {
		super();
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.nip = nip;
		this.addDate = addDate;
	}
	
	public Discount() {
		
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public LocalDate getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	public Collection<Items> getItems() {
		return items;
	}

	public void setItems(Collection<Items> items) {
		this.items = items;
	}

	public Collection<Opinions> getOpinions() {
		return opinions;
	}

	public void setOpinions(Collection<Opinions> opinions) {
		this.opinions = opinions;
	}
	
}
