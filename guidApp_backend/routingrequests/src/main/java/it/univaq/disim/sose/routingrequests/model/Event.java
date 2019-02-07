package it.univaq.disim.sose.routingrequests.model;

import java.sql.Timestamp;
import java.util.Date;

public class Event implements java.io.Serializable {

	private Long id;
	private String title;
	private String locality;
	private Timestamp startDate;
	private Timestamp endDate;
	private Category category;
	private User creator;

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
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
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
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
