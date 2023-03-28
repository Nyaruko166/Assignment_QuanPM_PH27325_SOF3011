package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.ChucVu;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {

    private String fromTable = "FROM ChucVu";
    Transaction transaction = null;

    public List<ChucVu> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChucVu getOne(UUID id) {
        ChucVu cv = new ChucVu();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            cv = session.get(ChucVu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cv;
    }

    public void addCV(ChucVu cv) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCV(ChucVu cv) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCV(ChucVu cv) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        ChucVuRepository chucVuRepository = new ChucVuRepository();
//        List<ChucVu> lstCV = chucVuRepository.getAll();
//        for (ChucVu cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
