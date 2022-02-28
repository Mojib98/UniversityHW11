import moduls.Employee;
import moduls.enumention.Status;
import repository.implement.EmpoloyeeRepositoryEmployee;
import service.implement.EmployeeServiceEmployee;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // EmpoloyeeRepositoryEmployee employ = new EmpoloyeeRepositoryEmployee();
       // Employee employee = new Employee(1,"ahmad",2, Status.ACTIVE);
        //employ.add(employee);
        EmployeeServiceEmployee e = new EmployeeServiceEmployee();
        //e.add();
        e.setId(211);
        e.show();
        System.out.println("_____");
        e.AllElement();
        e.delete();
        e.AllElement();
    }
}
