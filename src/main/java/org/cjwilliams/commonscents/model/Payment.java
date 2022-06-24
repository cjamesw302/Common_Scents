package org.cjwilliams.commonscents.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entity class for Payment

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Long id;
	@Column(nullable=false)
	private String fullName;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String state;
	@Column(nullable=false)
	private String zip;
	@Column(nullable=false)
	private String cardName;
	@Column(nullable=false)
	private String cardNumber;
	@Column(nullable=false)
	private Integer expMonth;
	@Column(nullable=false)
	private Integer expYear;
	@Column(nullable=false)
	private Integer cvv;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userID", nullable=false)
	private Users users;
	
	//No args constructor for payment
	
	public Payment() {
		super();
	}

	//All args constructor for payment
	
	public Payment(Long id, String fullName, String email, String address, String city, String state, String zip,
			String cardName, String cardNumber, Integer expMonth, Integer expYear, Integer cvv, Users users) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
		this.users = users;
	}

	//Getters and setters for corresponding variables
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(Integer expMonth) {
		this.expMonth = expMonth;
	}

	public Integer getExpYear() {
		return expYear;
	}

	public void setExpYear(Integer expYear) {
		this.expYear = expYear;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", fullName=" + fullName + ", email=" + email + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", cardName=" + cardName + ", cardNumber=" + cardNumber
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + ", cvv=" + cvv + ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cardName, cardNumber, city, cvv, email, expMonth, expYear, fullName, id, state,
				users, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(address, other.address) && Objects.equals(cardName, other.cardName)
				&& Objects.equals(cardNumber, other.cardNumber) && Objects.equals(city, other.city)
				&& Objects.equals(cvv, other.cvv) && Objects.equals(email, other.email)
				&& Objects.equals(expMonth, other.expMonth) && Objects.equals(expYear, other.expYear)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(id, other.id)
				&& Objects.equals(state, other.state) && Objects.equals(users, other.users)
				&& Objects.equals(zip, other.zip);
	}
}