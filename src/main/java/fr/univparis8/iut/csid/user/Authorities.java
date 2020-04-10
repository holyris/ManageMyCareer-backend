package fr.univparis8.iut.csid.user;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

    @Id
    private String username;

    @Autowired
    private String authority;
}

