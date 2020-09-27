package controllers;

import dao.BookCategoryDAO;
import dao.EBookDAO;
import models.BookCategory;
import models.EBook;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "NewEBook", urlPatterns = {"/new-e-book"})
@MultipartConfig(maxFileSize = 16177215)
public class NewEBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewCategory") != null) {
            String categoryName = request.getParameter("CategoryName").trim();
            BookCategoryDAO.create(new BookCategory(categoryName));
            response.sendRedirect("new-e-book");
            return;
        }

        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                // Parse the request
                List /* FileItem */ items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                if (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "/uploads");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);

                        int categoryId = Integer.parseInt(request.getParameter("CategoryId")),
                                publicationYear = Integer.parseInt(request.getParameter("PublicationYear"));
                        String title = request.getParameter("Title"),
                                author = request.getParameter("Author"),
                                language = request.getParameter("Language"),
                                filePath = uploadedFile.getAbsolutePath();

                        EBookDAO.create(new EBook( categoryId, publicationYear, title, language, author, filePath));
                        request.setAttribute("message", "E-book "+title+" uploaded.");
                        request.setAttribute("categories", BookCategoryDAO.all());
                        request.getRequestDispatcher("new-e-book.jsp").forward(request, response);
                    }
                }else {
                    System.out.println("No file");
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", BookCategoryDAO.all());
        request.getRequestDispatcher("new-e-book.jsp").forward(request, response);
    }
}
