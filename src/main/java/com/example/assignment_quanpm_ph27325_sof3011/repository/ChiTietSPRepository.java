package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.ChiTietSP;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {

    private String fromTable = "FROM ChiTietSP";
    Transaction transaction;

    public List<ChiTietSP> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSP getOne(UUID id) {
        ChiTietSP ctsp = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ctsp = session.get(ChiTietSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }

    public void addCTSP(ChiTietSP ctsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCTSP(ChiTietSP ctsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCTSP(ChiTietSP ctsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        ChiTietSPRepository chucVuRepository = new ChiTietSPRepository();
//        List<ChiTietSP> lstCV = chucVuRepository.getAll();
//        for (ChiTietSP cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
