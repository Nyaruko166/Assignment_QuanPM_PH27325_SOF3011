package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.ChiTietSP;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ChiTietSPRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM ChiTietSP";

    public List<ChiTietSP> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        ChiTietSPRepository chucVuRepository = new ChiTietSPRepository();
//        List<ChiTietSP> lstCV = chucVuRepository.getAll();
//        for (ChiTietSP cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
