package ru.darek;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name= "ADRES")
@Data
public class Address {
    @Id
    private UUID id;

    @Column(name = "ULICA",length = 50)
    private String street;

    @OneToOne
    private Client client;

    public Address(String street) {
        this.id = UUID.randomUUID();
        this.street = street;
    }
    public Address() {}
}
