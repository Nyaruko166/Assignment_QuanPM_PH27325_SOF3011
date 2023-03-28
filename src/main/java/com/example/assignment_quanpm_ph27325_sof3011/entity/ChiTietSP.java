package com.example.assignment_quanpm_ph27325_sof3011.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "ChiTietSP")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "IdSP")
    private String idSP;

    @Column(name = "IdNsx")
    private String idNSX;

    @Column(name = "IdMauSac")
    private String idMauSac;

    @Column(name = "IdDongSP")
    private String idDongSP;

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
