package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

// Storage table if you change Course to name to some Existing table name. Application is going to use that database table
@Entity
public class Course {
	@Id
private long id;
private String title;
private String description;
public Course(long id, String title, String description) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
}


}
