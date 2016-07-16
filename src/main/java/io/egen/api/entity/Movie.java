package io.egen.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries(@NamedQuery(name = "Movie.findById", query = "SELECT u FROM Movie u WHERE u.id=:pid"))
public class Movie {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;
	private String Title;
	private String Year;
	private String Rated;
	private String Released;
	private String Runtime;
	private String Genre;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		Rated = rated;
	}
	public String getReleased() {
		return Released;
	}
	public void setReleased(String released) {
		Released = released;
	}
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	
	
		}
