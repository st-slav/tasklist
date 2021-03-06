package ru.mamsta.exam.ibs.tasklist.api.model;

public class User {

	private Long id;
	private String name;
	
	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
