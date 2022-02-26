package uz.pdp.task1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
