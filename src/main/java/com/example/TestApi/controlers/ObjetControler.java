package com.example.TestApi.controlers;

import com.example.TestApi.entities.Objet;
import com.example.TestApi.repositories.IObjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ObjetControler {
    @Autowired
    IObjetRepo objetRepo;
    @PostMapping("/objet")
    public ResponseEntity<Objet> save(@RequestBody Objet objet) {
        try {
            return new ResponseEntity<>(objetRepo.save(objet), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/objets")
    public ResponseEntity<List<Objet>> getAll(){
        try {
            return new ResponseEntity<>(objetRepo.findAll(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/objet/{id}")
    public ResponseEntity<Objet> getPerson(@PathVariable Long id){
        Optional<Objet> objet = objetRepo.findById(id);

        if (objet.isPresent()){
            return new ResponseEntity<Objet>(objet.get(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
