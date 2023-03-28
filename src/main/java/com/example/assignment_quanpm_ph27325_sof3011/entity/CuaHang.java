package com.example.assignment_quanpm_ph27325_sof3011.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "CuaHang")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuaHang {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "thanhPho")
    private String thanhPho;

    @Column(name = "quocGia")
    private String quocGia;
}
