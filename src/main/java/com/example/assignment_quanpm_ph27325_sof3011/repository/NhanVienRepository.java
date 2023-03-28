package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.NhanVien;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class NhanVienRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM NhanVien";

    public List<NhanVien> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        NhanVienRepository chucVuRepository = new NhanVienRepository();
//        List<NhanVien> lstCV = chucVuRepository.getAll();
//        for (NhanVien cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
