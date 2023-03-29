package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.DongSP;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class DongSPRepository {

    private String fromTable = "FROM DongSP";
    Transaction transaction = null;

    public List<DongSP> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DongSP getOne(UUID id) {
        DongSP dsp = new DongSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            dsp = session.get(DongSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsp;
    }

    public void addDSP(DongSP dsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDSP(DongSP dsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDSP(DongSP dsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        DongSPRepository chucVuRepository = new DongSPRepository();
//        List<DongSP> lstCV = chucVuRepository.getAll();
//        for (DongSP cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
