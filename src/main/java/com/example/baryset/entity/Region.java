package com.example.baryset.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "region_location",
    joinColumns = @JoinColumn(name = "id_in", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_from", referencedColumnName = "id"))
    private List<Region> regionsIn = new ArrayList<>();
}
