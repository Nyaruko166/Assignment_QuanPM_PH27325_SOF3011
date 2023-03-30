package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.CuaHang;
import com.example.assignment_quanpm_ph27325_sof3011.repository.CuaHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/view",
        "/cua-hang/add",
        "/cua-hang/detail",
        "/cua-hang/update",
        "/cua-hang/delete",
})
public class CuaHangServlet extends HttpServlet {

    CuaHangRepository cuaHangRepository = new CuaHangRepository();
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
        UUID id = UUID.fromString(request.getParameter("id"));
        CuaHang ch = cuaHangRepository.getOne(id);
        cuaHangRepository.deleteCH(ch);
        response.sendRedirect("/cua-hang/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        CuaHang ch = cuaHangRepository.getOne(uid);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/view/cua-hang/detailCH.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CuaHang> lstCH = cuaHangRepository.getAll();
        request.setAttribute("lstCH", lstCH);
        request.getRequestDispatcher("/view/cua-hang/CuaHang.jsp").forward(request, response);
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

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        cuaHangRepository.addCH(new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia));
        response.sendRedirect("/cua-hang/view");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CuaHang ch = cuaHangRepository.getOne(uid);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        ch.setId(uid);
        ch.setMa(ma);
        ch.setTen(ten);
        ch.setDiaChi(diaChi);
        ch.setThanhPho(thanhPho);
        ch.setQuocGia(quocGia);
        cuaHangRepository.updateCH(ch);
        response.sendRedirect("/cua-hang/view");
    }
}
