package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.NhanVien;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class NhanVienRepository {

    private String fromTable = "FROM NhanVien";
    Transaction transaction;

    public List<NhanVien> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhanVien getOne(UUID id) {
        NhanVien nv = new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nv = session.get(NhanVien.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    public void addNV(NhanVien nv) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNV(NhanVien nv) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNV(NhanVien nv) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        NhanVienRepository chucVuRepository = new NhanVienRepository();
//        List<NhanVien> lstCV = chucVuRepository.getAll();
//        for (NhanVien cv : lstCV) {
//            System.out.println(cv.toString());
//        }
//    }
}
