package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.MauSac;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MauSacRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM MauSac";

    public List<MauSac> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        MauSacRepository chucVuRepository = new MauSacRepository();
//        List<MauSac> lstCV = chucVuRepository.getAll();
//        for (MauSac cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
