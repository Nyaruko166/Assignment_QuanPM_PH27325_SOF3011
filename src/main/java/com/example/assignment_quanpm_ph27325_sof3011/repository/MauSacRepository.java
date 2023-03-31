package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.ChucVu;
import com.example.assignment_quanpm_ph27325_sof3011.entity.MauSac;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class MauSacRepository {

    private String fromTable = "FROM MauSac";
    Transaction transaction = null;

    public List<MauSac> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MauSac getOne(UUID id) {
        MauSac ms = new MauSac();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ms = session.get(MauSac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    public void addMS(MauSac ms) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMS(MauSac ms) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMS(MauSac ms) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        MauSacRepository chucVuRepository = new MauSacRepository();
//        System.out.println(chucVuRepository.getOne());
//    }
}
