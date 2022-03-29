package com.sonata.collegefest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sonata.collegefest.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	/*  Use of @Query Annotation
		Using named queries to declare queries for entities is a valid approach and works 
		fine for a small number of queries.As the queries themselves are tied to the Java 
		method that runs them, you can actually bind them directly by using the Spring Data 
		JPA @Query annotation rather than annotating them to the domain class. 
		This frees the domain class from persistence specific information and 
		co-locates the query to the repository interface.
	    Queries annotated to the query method take precedence over queries defined using 
	    @NamedQuery or named queries declared in orm.xml. */
	
	@Query("SELECT u FROM User u WHERE u.usernmae =?1")
	public User getUserByUsername(String username);

}
