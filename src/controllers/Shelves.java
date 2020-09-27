package controllers;

import dao.CampusDAO;
import dao.ShelfDAO;
import models.Campus;
import models.Shelf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Shelves", urlPatterns = {"/shelves"})
public class Shelves extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewShelf") != null) {
            int shelfNo = Integer.parseInt(request.getParameter("ShelfNo")),
                    campusNo = Integer.parseInt(request.getParameter("CampusNo")),
                    floorNo = Integer.parseInt(request.getParameter("FloorNo"));
            ShelfDAO.create(new Shelf(shelfNo, floorNo, campusNo));
            response.sendRedirect("shelves");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Campus> campuses = CampusDAO.all();
        request.setAttribute("campuses", campuses);
        if(request.getParameter("c") == null) {
            request.setAttribute("shelves", ShelfDAO.findByCampus(campuses.get(0).getCampusNo()));
        }else {
            request.setAttribute("shelves", ShelfDAO.findByCampus(Integer.parseInt(request.getParameter("c"))));
        }
        request.getRequestDispatcher("shelves.jsp").forward(request, response);
    }
}
