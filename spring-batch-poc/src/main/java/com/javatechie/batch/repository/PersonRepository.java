package com.javatechie.batch.repository;

import com.javatechie.batch.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // This interface will automatically provide CRUD operations for the Person entity
    // No additional methods are needed unless custom queries are required
}
