package com.sonata.collegefest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			     name="user_roles",
			     joinColumns = @JoinColumn(name="user_id"),
			     inverseJoinColumns = @JoinColumn(name ="role_id")
			)
	
          private List<Role> roles = new ArrayList<> ();
}
