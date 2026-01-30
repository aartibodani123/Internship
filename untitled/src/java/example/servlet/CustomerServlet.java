package java.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/api/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerService service;

    @Override
    public void init() throws ServletException {
        service = new CustomerService();
    }

    // CREATE
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");

        Customer c = service.create(name, email);

        resp.setContentType("application/json");
        resp.getWriter().write(
                "{ \"id\": " + c.getId() +
                        ", \"name\": \"" + c.getName() +
                        "\", \"email\": \"" + c.getEmail() + "\" }"
        );
    }

    // READ
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String idParam = req.getParameter("id");
        resp.setContentType("application/json");

        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Customer c = service.getById(id);

            if (c == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"error\":\"Customer not found\"}");
                return;
            }

            resp.getWriter().write(
                    "{ \"id\": " + c.getId() +
                            ", \"name\": \"" + c.getName() +
                            "\", \"email\": \"" + c.getEmail() + "\" }"
            );
        } else {
            List<Customer> list = service.getAll();
            StringBuilder json = new StringBuilder("[");

            for (Customer c : list) {
                json.append("{\"id\":").append(c.getId())
                        .append(",\"name\":\"").append(c.getName())
                        .append("\",\"email\":\"").append(c.getEmail())
                        .append("\"},");
            }

            if (!list.isEmpty()) {
                json.deleteCharAt(json.length() - 1);
            }
            json.append("]");
            resp.getWriter().write(json.toString());
        }
    }

    // UPDATE
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        Customer c = service.update(id, name, email);

        if (c == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("{\"error\":\"Customer not found\"}");
            return;
        }

        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\":\"Updated successfully\"}");
    }

    // DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        boolean deleted = service.delete(id);

        resp.setContentType("application/json");

        if (!deleted) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("{\"error\":\"Customer not found\"}");
            return;
        }

        resp.getWriter().write("{\"message\":\"Deleted successfully\"}");
    }
}
