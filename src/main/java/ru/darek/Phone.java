package ru.darek;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "TELEPHONE")
@NoArgsConstructor
@Getter
@Setter
public class Phone {
    @Id
    private UUID id;
    @Column(name = "NAME", length = 12)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    public Phone(String number) {
        this.id = UUID.randomUUID();
        this.number = number;
    }
}
