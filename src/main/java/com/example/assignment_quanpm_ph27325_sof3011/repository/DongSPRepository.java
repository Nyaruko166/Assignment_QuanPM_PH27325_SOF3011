package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.DongSP;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DongSPRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM DongSP";

    public List<DongSP> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        DongSPRepository chucVuRepository = new DongSPRepository();
//        List<DongSP> lstCV = chucVuRepository.getAll();
//        for (DongSP cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
