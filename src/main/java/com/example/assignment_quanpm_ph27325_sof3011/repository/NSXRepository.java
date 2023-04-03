package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.NSX;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class NSXRepository {
    private String fromTable = "FROM NSX";
    Transaction transaction = null;

    public List<NSX> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NSX getOne(UUID id) {
        NSX nsx = new NSX();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nsx = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public void addNSX(NSX nsx) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNSX(NSX nsx) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNSX(NSX nsx) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        NSXRepository chucVuRepository = new NSXRepository();
//        List<NSX> lstCV = chucVuRepository.getAll();
//        for (NSX cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
