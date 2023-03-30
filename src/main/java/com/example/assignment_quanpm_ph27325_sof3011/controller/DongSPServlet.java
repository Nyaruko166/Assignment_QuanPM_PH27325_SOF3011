package com.example.assignment_quanpm_ph27325_sof3011.controller;

import com.example.assignment_quanpm_ph27325_sof3011.entity.DongSP;
import com.example.assignment_quanpm_ph27325_sof3011.repository.DongSPRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/dong-sp/view",
        "/dong-sp/add",
        "/dong-sp/detail",
        "/dong-sp/update",
        "/dong-sp/delete",
})
public class DongSPServlet extends HttpServlet {

    DongSPRepository dongSPRepository = new DongSPRepository();
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
        dongSPRepository.deleteDSP(dongSPRepository.getOne(UUID.fromString(request.getParameter("id"))));
        response.sendRedirect("/dong-sp/view");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uid = UUID.fromString(request.getParameter("id"));
        DongSP dsp = dongSPRepository.getOne(uid);
        request.setAttribute("dsp", dsp);
        request.getRequestDispatcher("/view/dong-sp/detailDSP.jsp").forward(request, response);
    }

    private void loadTbl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DongSP> lstDSP = dongSPRepository.getAll();
        request.setAttribute("lstDSP", lstDSP);
        request.getRequestDispatcher("/view/dong-sp/DongSP.jsp").forward(request, response);
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
        DongSP dsp = dongSPRepository.getOne(uid);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        dsp.setId(uid);
        dsp.setMa(ma);
        dsp.setTen(ten);
        dongSPRepository.updateDSP(dsp);
        response.sendRedirect("/dong-sp/view");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = null;
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        dongSPRepository.addDSP(new DongSP(id, ma, ten));
        response.sendRedirect("/dong-sp/view");
    }
}
