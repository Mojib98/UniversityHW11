import moduls.Employee;
import moduls.enumention.Status;
import repository.implement.EmpoloyeeRepositoryEmployee;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EmpoloyeeRepositoryEmployee employ = new EmpoloyeeRepositoryEmployee();
        Employee employee = new Employee(1,"ahmad",2, Status.ACTIVE);
        employ.add(employee);
    }
}
