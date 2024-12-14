package com.bhawnagunwani.SpringBootDemo.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class User {

	private Long id;

	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@NotNull(message = "Age cannot be null.")
	private Integer age;
	
	public User(Long id, @NotBlank(message = "Name cannot be blank") String name,
			@NotNull(message = "Age cannot be null.") Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
