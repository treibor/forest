package com.example.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
public class MenuTop {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mT_generator")
	@SequenceGenerator(name="mt_generator", sequenceName = "mt_seq", allocationSize=1)
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private long level;
	private String layout;
	private boolean hasChildren;
	private long childof;
	
	
	
	private String content;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
		this.level = level;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public Boolean getHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getChildof() {
		return childof;
	}
	public void setChildof(long childof) {
		this.childof = childof;
	}  
	
	
	
}
