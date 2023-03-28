package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.SanPham;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM SanPham";

    public List<SanPham> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        SanPhamRepository chucVuRepository = new SanPhamRepository();
//        List<SanPham> lstCV = chucVuRepository.getAll();
//        for (SanPham cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
