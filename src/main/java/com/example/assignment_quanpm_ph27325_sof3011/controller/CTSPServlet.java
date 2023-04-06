package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.*;
import com.example.assignment_quanpm_ph27325_sof3011.repository.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CTSPServlet", value = {
        "/ctsp/view",
        "/ctsp/add",
        "/ctsp/detail",
        "/ctsp/update",
        "/ctsp/delete"
})
public class CTSPServlet extends HttpServlet {

    ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    NSXRepository nsxRepository = new NSXRepository();
    MauSacRepository mauSacRepository = new MauSacRepository();
    DongSPRepository dongSPRepository = new DongSPRepository();

    List<SanPham> lstSP = sanPhamRepository.getAll();
    List<NSX> lstNSX = nsxRepository.getAll();
    List<MauSac> lstMS = mauSacRepository.getAll();
    List<DongSP> lstDSP = dongSPRepository.getAll();

    String uri;
    UUID uid;

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uri = request.getRequestURI();
        if (uri.contains("view")) {
            loadTbl(request, response);
        } else if (uri.contains("detail")) {
            detail(request, response);
        } else if (uri.contains("delete")) {
            delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        chiTietSPRepository.deleteCTSP(chiTietSPRepository.getOne(UUID.fromString(request.getParameter("id"))));
        response.sendRedirect("/ctsp/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        ChiTietSP ctsp = chiTietSPRepository.getOne(uid);

        request.setAttribute("lstSP", lstSP);
        request.setAttribute("lstNSX", lstNSX);
        request.setAttribute("lstMS", lstMS);
        request.setAttribute("lstDSP", lstDSP);
        request.setAttribute("ctsp", ctsp);


        request.getRequestDispatcher("/view/ct-sp/detailCTSP.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChiTietSP> lstCTSP = chiTietSPRepository.getAll();

        request.setAttribute("lstSP", lstSP);
        request.setAttribute("lstNSX", lstNSX);
        request.setAttribute("lstMS", lstMS);
        request.setAttribute("lstDSP", lstDSP);
        request.setAttribute("lstCTSP", lstCTSP);
        request.getRequestDispatcher("/view/ct-sp/CTSP.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uri = request.getRequestURI();
        if (uri.contains("add")) {
            add(request, response);
        } else if (uri.contains("update")) {
            update(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        UUID id = null;
        SanPham sanPham = sanPhamRepository.getOne(UUID.fromString(request.getParameter("sanPham")));
        NSX nsx = nsxRepository.getOne(UUID.fromString(request.getParameter("nsx")));
        MauSac mauSac = mauSacRepository.getOne(UUID.fromString(request.getParameter("mauSac")));
        DongSP dongSP = dongSPRepository.getOne(UUID.fromString(request.getParameter("dongSP")));
        Integer namBH = Integer.valueOf(request.getParameter("namBH"));
        String moTa = request.getParameter("moTa");
        Integer soLuongTon = Integer.valueOf(request.getParameter("soLuongTon"));
        Double giaNhap = Double.valueOf(request.getParameter("giaNhap"));
        Double giaBan = Double.valueOf(request.getParameter("giaBan"));
        chiTietSPRepository.addCTSP(new ChiTietSP(id, sanPham, nsx, mauSac, dongSP, namBH, moTa, soLuongTon, giaNhap, giaBan));
        response.sendRedirect("/ctsp/view");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        ChiTietSP ctsp = chiTietSPRepository.getOne(uid);
        SanPham sanPham = sanPhamRepository.getOne(UUID.fromString(request.getParameter("sanPham")));
        NSX nsx = nsxRepository.getOne(UUID.fromString(request.getParameter("nsx")));
        MauSac mauSac = mauSacRepository.getOne(UUID.fromString(request.getParameter("mauSac")));
        DongSP dongSP = dongSPRepository.getOne(UUID.fromString(request.getParameter("dongSP")));
        Integer namBH = Integer.valueOf(request.getParameter("namBH"));
        String moTa = request.getParameter("moTa");
        Integer soLuongTon = Integer.valueOf(request.getParameter("soLuongTon"));
        Double giaNhap = Double.valueOf(request.getParameter("giaNhap"));
        Double giaBan = Double.valueOf(request.getParameter("giaBan"));

        ctsp.setId(uid);
        ctsp.setSanPham(sanPham);
        ctsp.setNsx(nsx);
        ctsp.setMauSac(mauSac);
        ctsp.setDongSP(dongSP);
        ctsp.setNamBH(namBH);
        ctsp.setMoTa(moTa);
        ctsp.setSoLuongTon(soLuongTon);
        ctsp.setGiaBan(giaNhap);
        ctsp.setGiaBan(giaBan);

        chiTietSPRepository.updateCTSP(ctsp);
        response.sendRedirect("/ctsp/view");
    }
}
