package repository.implement;
import moduls.Employee;
import moduls.enumention.Status;
import repository.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpoloyeeRepositoryEmployee implements Repository<Employee> {
   private Connection connection = Singleton.getInstance().getConnection();
    PreparedStatement preparedStatement;

    public EmpoloyeeRepositoryEmployee() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee(ide, name, passcode, status) values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2,employee.getName());
        preparedStatement.setInt(3,employee.getPasscode());
        preparedStatement.setString(4,employee.getStatus().toString());
        preparedStatement.execute();

    }

    @Override
    public List<Employee> AllElement() throws SQLException {
        List<Employee> list = new ArrayList<>();

        String sql = "select * from  employee ";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("ide");
            String name = resultSet.getString("name");
            int passcode = resultSet.getInt("passcode");
            String sta = resultSet.getString("status");
            Employee employee = new Employee(id,name,passcode, Status.ACTIVE);
            list.add(employee);
    }
    return list;
    }

    @Override
    public Employee show(int id) throws SQLException {
        String sql = "select * from  employee " +
                "where ide=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            int passcode = resultSet.getInt("passcode");
            String sta = resultSet.getString("status");
            Employee employee = new Employee(id,name,passcode, Status.ACTIVE);
            return employee;
        }

        return null;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from employee where ide = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }

    @Override
    public void modify(Employee employee) throws SQLException {
        String sql = "UPDATE employee set passcode=? " +
                "where ide=? and passcode=?";
        preparedStatement = connection.prepareStatement(sql);

    }
}
