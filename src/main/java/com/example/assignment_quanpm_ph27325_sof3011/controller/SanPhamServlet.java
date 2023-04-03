package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.SanPham;
import com.example.assignment_quanpm_ph27325_sof3011.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/view",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/update",
        "/san-pham/delete"
})
public class SanPhamServlet extends HttpServlet {

    SanPhamRepository sanPhamRepository = new SanPhamRepository();
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
        sanPhamRepository.deleteSP(sanPhamRepository.getOne(UUID.fromString(request.getParameter("id"))));
        response.sendRedirect("/san-pham/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        SanPham sp = sanPhamRepository.getOne(uid);
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("/view/san-pham/detailSP.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> lstSP = sanPhamRepository.getAll();
        request.setAttribute("lstSP", lstSP);
        request.getRequestDispatcher("/view/san-pham/SanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uri = request.getRequestURI();
        if (uri.contains("add")) {
            add(request, response);
        } else if (uri.contains("update")) {
            update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SanPham sp = sanPhamRepository.getOne(uid);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        sp.setId(uid);
        sp.setMa(ma);
        sp.setTen(ten);
        sanPhamRepository.updateSP(sp);
        response.sendRedirect("/san-pham/view");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        sanPhamRepository.addSP(new SanPham(id, ma, ten));
        response.sendRedirect("/san-pham/view");
    }
}
