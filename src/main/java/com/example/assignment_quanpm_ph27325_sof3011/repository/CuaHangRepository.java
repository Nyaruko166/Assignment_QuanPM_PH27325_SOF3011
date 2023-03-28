package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.CuaHang;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CuaHangRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM CuaHang";

    public List<CuaHang> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        CuaHangRepository chucVuRepository = new CuaHangRepository();
//        List<CuaHang> lstCV = chucVuRepository.getAll();
//        for (CuaHang cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
