package uz.pdp.task1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private Double size;

    @ManyToOne
    private Hotel hotel;

}
