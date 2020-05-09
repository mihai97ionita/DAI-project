package com.dai.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rezervare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    private String personName;

    @Column
    private String personMail;

    @Column
    private String period;

    @OneToOne(fetch = FetchType.EAGER)
    private Camera camera;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Facilitate> facilitate;

}