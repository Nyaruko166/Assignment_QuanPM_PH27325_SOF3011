package com.example.assignment_quanpm_ph27325_sof3011.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "ChiTietSP")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "IdSP")
    private UUID idSP;

    @Column(name = "IdNsx")
    private UUID idNSX;

    @Column(name = "IdMauSac")
    private UUID idMauSac;

    @Column(name = "IdDongSP")
    private UUID idDongSP;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

}
