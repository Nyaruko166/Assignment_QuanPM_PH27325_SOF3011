package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.ChucVu;
import com.example.assignment_quanpm_ph27325_sof3011.repository.ChucVuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/view",
        "/chuc-vu/add",
        "/chuc-vu/detail",
        "/chuc-vu/update",
        "/chuc-vu/delete",
})
public class ChucVuServlet extends HttpServlet {

    ChucVuRepository chucVuRepository = new ChucVuRepository();
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
        chucVuRepository.deleteCV(chucVuRepository.getOne(UUID.fromString(request.getParameter("id"))));
        response.sendRedirect("/chuc-vu/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        ChucVu cv = chucVuRepository.getOne(uid);
        request.setAttribute("cv", cv);
        request.getRequestDispatcher("/view/chuc-vu/detailCV.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> lstCV = chucVuRepository.getAll();
        request.setAttribute("lstCV", lstCV);
        request.getRequestDispatcher("/view/chuc-vu/ChucVu.jsp").forward(request, response);
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
        ChucVu cv = chucVuRepository.getOne(uid);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        cv.setId(uid);
        cv.setMa(ma);
        cv.setTen(ten);
        chucVuRepository.updateCV(cv);
        response.sendRedirect("/chuc-vu/view");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        chucVuRepository.addCV(new ChucVu(id, ma, ten));
        response.sendRedirect("/chuc-vu/view");
    }
}
