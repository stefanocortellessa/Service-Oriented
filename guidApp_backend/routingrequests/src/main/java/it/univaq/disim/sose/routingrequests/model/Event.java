package it.univaq.disim.sose.routingrequests.model;

import java.sql.Timestamp;
import java.util.Date;

public class Event implements java.io.Serializable {

	private Long id;
	private String title;
	private String locality;
	private Timestamp startDate;
	private Timestamp endDate;
	private String categoryName;
	private long categoryId;
	private long creatorId;

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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}
}
