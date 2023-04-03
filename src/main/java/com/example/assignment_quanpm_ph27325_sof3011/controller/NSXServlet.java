package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.MauSac;
import com.example.assignment_quanpm_ph27325_sof3011.entity.NSX;
import com.example.assignment_quanpm_ph27325_sof3011.repository.NSXRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/view",
        "/nsx/add",
        "/nsx/detail",
        "/nsx/update",
        "/nsx/delete"
})
public class NSXServlet extends HttpServlet {

    NSXRepository nsxRepository = new NSXRepository();
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
        nsxRepository.deleteNSX(nsxRepository.getOne(UUID.fromString(request.getParameter("id"))));
        response.sendRedirect("/nsx/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        NSX nsx = nsxRepository.getOne(uid);
        request.setAttribute("nsx", nsx);
        request.getRequestDispatcher("/view/nsx/detailNSX.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NSX> lstNSX = nsxRepository.getAll();
        request.setAttribute("lstNSX", lstNSX);
        request.getRequestDispatcher("/view/nsx/NSX.jsp").forward(request, response);
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
        NSX nsx = nsxRepository.getOne(uid);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        nsx.setId(uid);
        nsx.setMa(ma);
        nsx.setTen(ten);
        nsxRepository.updateNSX(nsx);
        response.sendRedirect("/nsx/view");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        nsxRepository.addNSX(new NSX(id, ma, ten));
        response.sendRedirect("/nsx/view");
    }
}
