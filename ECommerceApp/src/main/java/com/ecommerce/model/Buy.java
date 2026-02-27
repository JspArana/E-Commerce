package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="buyer")
public class Buy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	@Column(name ="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name ="doorno")
	private String DoorNo;
	@Column(name ="street")
	private String Street;
	@Column(name ="area")
	private String Area;
	@Column(name ="landmark")
	private String landmark;
	@Column(name ="city")
	private String City;
	@Column(name ="pincode")
	private String pincode;
	@Column(name ="district")
	private String District;
	@Column(name ="state")
	private String State;
	@Column(name ="country")
	private String Country;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")   // Foreign Key column
    private Product product;
	
	public Buy() {

	}

	public Buy(int id, String phone, String email, String doorNo, String street, String area, String landmark,
			String city, String pincode, String district, String state, String country, Product product) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.DoorNo = doorNo;
		this.Street = street;
		this.Area = area;
		this.landmark=landmark;
		this.City = city;
		this.District = district;
		this.State = state;
		this.Country = country;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoorNo() {
		return DoorNo;
	}

	public void setDoorNo(String doorNo) {
		DoorNo = doorNo;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Buy [" + id + ", " + phone + ", " + email + ", " + DoorNo + ", " + Street
				+ ", " + Area + ", " + landmark + ", " + City + ", " + pincode
				+ ", " + District + ", " + State + ", " + Country + "]";
	}	
	
}
