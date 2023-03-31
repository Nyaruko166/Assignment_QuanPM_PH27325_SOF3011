package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.DongSP;
import com.example.assignment_quanpm_ph27325_sof3011.entity.MauSac;
import com.example.assignment_quanpm_ph27325_sof3011.repository.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/view",
        "/mau-sac/add",
        "/mau-sac/detail",
        "/mau-sac/update",
        "/mau-sac/delete",
})
public class MauSacServlet extends HttpServlet {

    MauSacRepository mauSacRepository = new MauSacRepository();
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
        mauSacRepository.deleteMS(mauSacRepository.getOne(UUID.fromString(request.getParameter("id"))));
        response.sendRedirect("/mau-sac/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        MauSac ms = mauSacRepository.getOne(uid);
//        System.out.println(uid)       request.setAttribute("ms", ms);
        request.getRequestDispatcher("/view/mau-sac/detailMS.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MauSac> lstMS = mauSacRepository.getAll();
        request.setAttribute("lstMS", lstMS);
        request.getRequestDispatcher("/view/mau-sac/MauSac.jsp").forward(request, response);
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
        MauSac ms = mauSacRepository.getOne(uid);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        ms.setId(uid);
        ms.setMa(ma);
        ms.setTen(ten);
        mauSacRepository.updateMS(ms);
        response.sendRedirect("/mau-sac/view");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        mauSacRepository.addMS(new MauSac(id, ma, ten));
        response.sendRedirect("/mau-sac/view");
    }
}
