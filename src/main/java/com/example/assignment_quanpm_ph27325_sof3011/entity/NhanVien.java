package com.example.assignment_quanpm_ph27325_sof3011.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "NhanVien")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCH", referencedColumnName = "Id")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "IdCV", referencedColumnName = "Id")
    private ChucVu chucVu;

    @Column(name = "IdGuiBC")
    private String idGuiBC;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
