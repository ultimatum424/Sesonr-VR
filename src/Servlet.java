
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private List<Book> books;

    public Servlet() {
        this.books = new ArrayList<>();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<body>");
        out.println("<table border=\"1\">");
        out.println("<caption>Table books</caption>");
        out.println("<tr>");

        out.println("<th>Title</th>\n" +
                "    <th>Author</th>\n" +
                "    <th>Number of pages</th>\n" +
                "    <th>Release date</th>\n" +
                "    <th>New book</th>");
        out.println("</tr>");

        for(Book book : books) {
            out.println(book);
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("title");
        String password = req.getParameter("author");
        String dateString = req.getParameter("calendar");
        int numberOfPages = Integer.parseInt(req.getParameter("num"));
        boolean isNew = req.getParameter( "is_new" ) != null;

        books.add(new Book(username, password, numberOfPages, convertDate(dateString), isNew));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.html");
        requestDispatcher.forward(req, resp);
    }

    private Date convertDate(String dateString) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
