package com.sonata.collegefest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="role")
@Data
public class Role {

	@Id
	@Column(name="role_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
}
