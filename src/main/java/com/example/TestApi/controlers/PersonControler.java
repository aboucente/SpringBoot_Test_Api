package com.example.TestApi.controlers;

import com.example.TestApi.entities.Objet;
import com.example.TestApi.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TestApi.repositories.IPersonRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonControler {
    @Autowired
     IPersonRepo personRepo;
    @PostMapping("/person")
    public ResponseEntity<Person> save(@RequestBody Person person){
        try {
            return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAll(){
        try {
            return new ResponseEntity<>(personRepo.findAll(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        Optional<Person> person = personRepo.findById(id);

        if (person.isPresent()){
            return new ResponseEntity<Person>(person.get(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
