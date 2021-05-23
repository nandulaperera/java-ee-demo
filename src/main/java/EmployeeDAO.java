import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1,employee.getId());
        pst.setString(2,employee.getUsername());
        pst.setString(3,employee.getPassword());
        pst.setString(4,employee.getName());
        pst.setString(5,employee.getContactNo());
        pst.setString(6,employee.getEmail());
        pst.setString(7,employee.getJobTitle());
        pst.setString(8,employee.getImageUrl());
        return pst.executeUpdate() > 0;
    }

    public static List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM employee";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rst = pst.executeQuery();
        while(rst.next()){
            if(rst != null){
                employees.add(new Employee(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8)
                ));
            }
        }
        return employees;
    }

}
