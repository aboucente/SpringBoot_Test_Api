package com.example.TestApi.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "objet")
@Getter
@Setter
@ToString
public class Objet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idobj;
    private String desobj;

    @ManyToOne
    @Basic(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpers")
    private Person person;

    public Objet() {
    }

    public Objet(String desobj) {
        this.desobj = desobj;
    }

    public Objet(String desobj, Person person) {
        this.desobj = desobj;
        this.person = person;
    }

    public Long getIdobj() {
        return idobj;
    }

    public void setIdobj(Long idobj) {
        this.idobj = idobj;
    }

    public String getDesobj() {
        return desobj;
    }

    public void setDesobj(String desobj) {
        this.desobj = desobj;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
