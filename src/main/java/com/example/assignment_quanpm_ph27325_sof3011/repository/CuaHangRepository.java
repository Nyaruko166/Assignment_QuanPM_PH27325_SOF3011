package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.CuaHang;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class CuaHangRepository {

    private String fromTable = "FROM CuaHang";
    Transaction transaction = null;

    public List<CuaHang> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CuaHang getOne(UUID id) {
        CuaHang ch = new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ch = session.get(CuaHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    public void addCH(CuaHang ch) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCH(CuaHang ch) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCH(CuaHang ch) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        CuaHangRepository chucVuRepository = new CuaHangRepository();
//        List<CuaHang> lstCV = chucVuRepository.getAll();
//        for (CuaHang cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
