package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.KhachHang;
import com.example.assignment_quanpm_ph27325_sof3011.repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/view", "/khach-hang/add", "/khach-hang/update", "/khach-hang/detail", "/khach-hang/delete"})
public class KhachHangServlet extends HttpServlet {
    KhachHangRepository khachHangRepository = new KhachHangRepository();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String uri;
    UUID uid;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uri = request.getRequestURI();
        if (uri.contains("/view")) {
            getAll(request, response);
        } else if (uri.contains("/detail")) {
            detailKH(request, response);
        } else if (uri.contains("/delete")) {
            deleteKH(request, response);
        }
    }

    private void detailKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        KhachHang kh = khachHangRepository.getOne(uid);
        String ngaySinh = dateFormat.format(kh.getNgaySinh());
        request.setAttribute("khachHang", kh);
        request.setAttribute("ngaySinh", ngaySinh);
        request.getRequestDispatcher("/view/khach-hang/detailKH.jsp").forward(request, response);
    }

    private void deleteKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        KhachHang kh = khachHangRepository.getOne(id);
        khachHangRepository.deleteKH(kh);
        response.sendRedirect("/khach-hang/view");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uri = request.getRequestURI();
        if (uri.contains("/add")) {
            addKH(request, response);
        } else if (uri.contains("/update")) {
            updateKH(request, response);
        }
    }

    private void updateKH(HttpServletRequest request, HttpServletResponse response) throws IOException {
        KhachHang kh = khachHangRepository.getOne(uid);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        String ho = request.getParameter("ho");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        kh.setId(uid);
        kh.setMa(ma);
        kh.setTen(ten);
        kh.setHo(ho);
        kh.setTenDem(tenDem);
        kh.setNgaySinh(ngaySinh);
        kh.setSdt(sdt);
        kh.setDiaChi(diaChi);
        kh.setThanhPho(thanhPho);
        kh.setQuocGia(quocGia);
        kh.setMatKhau(matKhau);
        khachHangRepository.updateKH(kh);
        response.sendRedirect("/khach-hang/view");
    }

    private void addKH(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        String ho = request.getParameter("ho");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        KhachHang kh = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);
        khachHangRepository.addKH(kh);
        response.sendRedirect("/khach-hang/view");
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> listKhachHang = khachHangRepository.getAll();
        request.setAttribute("listKhachHang", listKhachHang);
        request.getRequestDispatcher("/view/khach-hang/KhachHang.jsp").forward(request, response);
    }

}
