package com.example.assignment_quanpm_ph27325_sof3011.repository;

import com.example.assignment_quanpm_ph27325_sof3011.entity.KhachHang;
import com.example.assignment_quanpm_ph27325_sof3011.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class KhachHangRepository {

    private String fromTable = "FROM KhachHang";
    Transaction transaction;

    public List<KhachHang> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(fromTable);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHang getOne(UUID id) {
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            khachHang = session.get(KhachHang.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public void addKH(KhachHang kh) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateKH(KhachHang kh) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteKH(KhachHang kh) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        KhachHangRepository khachHangRepository = new KhachHangRepository();
//        List<KhachHang> lstKH = khachHangRepository.getAll();
//        for(KhachHang kh: lstKH){
//            System.out.println(kh.toString());
//        }
//    }
}
