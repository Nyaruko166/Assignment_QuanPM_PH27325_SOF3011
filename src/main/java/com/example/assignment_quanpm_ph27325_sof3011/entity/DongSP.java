package com.example.assignment_quanpm_ph27325_sof3011.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "DongSP")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
}
