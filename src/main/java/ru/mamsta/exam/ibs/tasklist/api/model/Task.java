package ru.mamsta.exam.ibs.tasklist.api.model;

public class Task {
	
	private Long id;
	private String name;
	private String description;
	private User createdUser;
	private User assignedUser;
	private Status status;
	
	public Task(Long id, String name, String description, User createdUser, User assignedUser, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdUser = createdUser;
		this.assignedUser = assignedUser;
		this.status = status;
	}

	public Task() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", createdUser=" + createdUser
				+ ", assignedUser=" + assignedUser + ", status=" + status + "]";
	}
}
