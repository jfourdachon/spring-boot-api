package edu.itakademy.demo.entity.dto;

public class AuthorDTO {
	
	private String firstname;
	
	private String lastname;
	
	private Integer book_count;
	
	private String nationality;

	public AuthorDTO() {}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getBook_count() {
		return book_count;
	}

	public void setBook_count(Integer book_count) {
		this.book_count = book_count;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
		
	
}
