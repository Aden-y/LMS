package controllers;

import dao.BookDAO;
import models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewBook", urlPatterns = {"/new-book"})
public class NewBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bindingId = Integer.parseInt(request.getParameter("BindingId")),
                copiesActual = Integer.parseInt(request.getParameter("CopiesActual")),
                categoryId = Integer.parseInt(request.getParameter("CategoryId")),
                publicationYear = Integer.parseInt(request.getParameter("PublicationYear")),
                shelfId = Integer.parseInt(request.getParameter("ShelfId"));
        String title = request.getParameter("Title"),
                author = request.getParameter("Author"),
                language = request.getParameter("Language");

        BookDAO.create(new Book(bindingId, copiesActual, copiesActual, categoryId, publicationYear, shelfId, title, author, language));
        request.setAttribute("message", "Book "+title+" added to the database.");
        request.getRequestDispatcher("new-book.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("new-book.jsp").forward(request, response);
    }
}
