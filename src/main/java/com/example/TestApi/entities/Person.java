package com.example.TestApi.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table (name = "person")
@Entity
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpers;
    private String namepers;
    private String prenompers;

//    @OneToMany(mappedBy = "person")
//    @Basic(fetch = FetchType.LAZY)
//    private Set<Objet> objets;

    public Person() {
    }

    public Person(String namepers, String prenompers, Set<Objet> objets) {
        this.namepers = namepers;
        this.prenompers = prenompers;
//        this.objets = objets;
    }

    public Long getIdpers() {
        return idpers;
    }

    public void setIdpers(Long idpers) {
        this.idpers = idpers;
    }

    public String getNamepers() {
        return namepers;
    }

    public void setNamepers(String namepers) {
        this.namepers = namepers;
    }

    public String getPrenompers() {
        return prenompers;
    }

    public void setPrenompers(String prenompers) {
        this.prenompers = prenompers;
    }

//    public List<Objet> getObjets() {
//        return objets;
//    }
//
//    public void setObjets(List<Objet> objets) {
//        this.objets = objets;
//    }
}
