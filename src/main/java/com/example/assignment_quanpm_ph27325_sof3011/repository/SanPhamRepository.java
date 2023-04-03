package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.SanPham;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class SanPhamRepository {

    private String fromTable = "FROM SanPham";
    Transaction transaction;

    public List<SanPham> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham getOne(UUID id) {
        SanPham sp = new SanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            sp = session.get(SanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public void addSP(SanPham sp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSP(SanPham sp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSP(SanPham sp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        SanPhamRepository chucVuRepository = new SanPhamRepository();
//        List<SanPham> lstCV = chucVuRepository.getAll();
//        for (SanPham cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
