package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.NSX;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class NSXRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM NSX";

    public List<NSX> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        NSXRepository chucVuRepository = new NSXRepository();
//        List<NSX> lstCV = chucVuRepository.getAll();
//        for (NSX cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
