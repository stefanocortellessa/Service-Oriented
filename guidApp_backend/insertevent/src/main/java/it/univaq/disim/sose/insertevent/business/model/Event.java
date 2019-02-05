package it.univaq.disim.sose.insertevent.business.model;

import java.sql.Timestamp;
import java.util.Date;

public class Event implements java.io.Serializable {

	private Long id;
	private String title;
	private String place;
	private String city;
	private Timestamp startDate;
	private Timestamp endDate;
	private String address;
	private Category category;
	private User creator;
	
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Timestamp getStartDate() {
		return startDate;	
	}
	public void setStartDate(Date startDate) {
		this.startDate = new Timestamp(startDate.getTime());
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = new Timestamp(endDate.getTime());
	}
}
