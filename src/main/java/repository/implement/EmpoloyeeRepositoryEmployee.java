package repository.implement;
import moduls.Employee;
import repository.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        preparedStatement.setObject(4,employee.getStatus());
        preparedStatement.execute();

    }

    @Override
    public List<Employee> AllElement() {
        return null;
    }

    @Override
    public void show(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public void modify(Employee employee) {

    }
}
