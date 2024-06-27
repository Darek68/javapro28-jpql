package ru.darek;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "PERSON")
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    private UUID id;

    @Column(name = "NAME", length = 25,nullable = false)
    private String name;


    @OneToMany(mappedBy = "client")
    private Set<Phone> phoneSet;

    @OneToOne
    private Address address;

    public Client(String imie) {
        this.id = UUID.randomUUID();
        this.name = imie;
        this.phoneSet = new HashSet<>();
    }
}
