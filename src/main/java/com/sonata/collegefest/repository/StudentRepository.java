package com.sonata.collegefest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.collegefest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example
	
	List<Student> findByFirstNameContaionsAndLastNameContaionsAllIngoreCases(String firstName, String lastName);
}

