package controllers;

import dao.EBookDAO;
import models.EBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewEBook", urlPatterns = {"/new-e-book"})
public class NewEBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* int categoryId,
        int publicationYear,
        String title,
        String language,
        String author,
        String filePath

        */

       int categoryId = Integer.parseInt(request.getParameter("CategoryId")),
               publicationYear = Integer.parseInt(request.getParameter("PublicationYear"));
        String title = request.getParameter("Title"),
                author = request.getParameter("Author"),
                language = request.getParameter("Language"),
                filePath = "path-to-soft-copy";

        EBookDAO.create(new EBook( categoryId, publicationYear, title, language, author, filePath));
        request.setAttribute("message", "E-book "+title+" uploaded.");
        request.getRequestDispatcher("new-e-book.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("new-e-book.jsp").forward(request, response);
    }
}
