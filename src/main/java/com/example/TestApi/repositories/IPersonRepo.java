package com.example.TestApi.repositories;

import com.example.TestApi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepo extends JpaRepository<Person, Long> {

}
