import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee.jsp");
        List<Employee> allEmployees = new ArrayList<>();
        try {
            allEmployees = EmployeeDAO.getAllEmployees();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("employees",allEmployees);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String job = req.getParameter("job");
        String imageUrl = req.getParameter("imageUrl");
        password = String.valueOf(password.hashCode());

        boolean added = false;

        try {
            added = EmployeeDAO.addEmployee(new Employee(
                    id,
                    username,
                    password,
                    name,
                    phone,
                    email,
                    job,
                    imageUrl
            ));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(added){
            req.setAttribute("message","Successfully added");
        }else{
            req.setAttribute("message","Not added");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee.jsp");
        requestDispatcher.forward(req,resp);

    }
}
