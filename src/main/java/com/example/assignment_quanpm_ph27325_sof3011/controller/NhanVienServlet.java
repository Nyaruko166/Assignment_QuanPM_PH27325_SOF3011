package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.ChucVu;
import com.example.assignment_quanpm_ph27325_sof3011.entity.CuaHang;
import com.example.assignment_quanpm_ph27325_sof3011.entity.NhanVien;
import com.example.assignment_quanpm_ph27325_sof3011.repository.ChucVuRepository;
import com.example.assignment_quanpm_ph27325_sof3011.repository.CuaHangRepository;
import com.example.assignment_quanpm_ph27325_sof3011.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/view",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/delete"
})
public class NhanVienServlet extends HttpServlet {

    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    CuaHangRepository cuaHangRepository = new CuaHangRepository();
    ChucVuRepository chucVuRepository = new ChucVuRepository();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    List<CuaHang> lstCH = cuaHangRepository.getAll();
    List<ChucVu> lstCV = chucVuRepository.getAll();

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
        nhanVienRepository.deleteNV(nhanVienRepository.getOne(UUID.fromString(request.getParameter("id"))));
        response.sendRedirect("/nhan-vien/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        NhanVien nv = nhanVienRepository.getOne(uid);
        String ngaySinh = format.format(nv.getNgaySinh());

        request.setAttribute("lstCH", lstCH);
        request.setAttribute("lstCV", lstCV);
        request.setAttribute("nv", nv);
        request.setAttribute("ngaySinh", ngaySinh);


        request.getRequestDispatcher("/view/nhan-vien/detailNV.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> lstNV = nhanVienRepository.getAll();

        request.setAttribute("lstCH", lstCH);
        request.setAttribute("lstCV", lstCV);
        request.setAttribute("lstNV", lstNV);
        request.getRequestDispatcher("/view/nhan-vien/NhanVien.jsp").forward(request, response);
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

    private void add(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        Date ngaySinh = format.parse(request.getParameter("ngaySinh"));
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        String idCH = request.getParameter("cuaHang");
        String idCV = request.getParameter("chucVu");
        String idGuiBC = null;
        Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));

//        nhanVienRepository.addNV(new );
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }
}
