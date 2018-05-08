package ru.mamsta.exam.ibs.tasklist.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("task")
public class TaskDto {

	private Long id;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String description;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long createdUser;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long assignedUser;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long status;

	public TaskDto() {
		super();
	}

	public TaskDto(Long id, String name, String description, Long createdUser, Long assignedUser, Long status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdUser = createdUser;
		this.assignedUser = assignedUser;
		this.status = status;
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

	public Long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}

	public Long getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(Long assignedUser) {
		this.assignedUser = assignedUser;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", name=" + name + ", description=" + description + ", createdUser=" + createdUser
				+ ", assignedUser=" + assignedUser + ", status=" + status + "]";
	}
}
