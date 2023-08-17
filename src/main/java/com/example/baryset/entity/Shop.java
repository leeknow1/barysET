package com.example.baryset.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shops")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Region region;
}
