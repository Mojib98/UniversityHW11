package service.implement;

import moduls.Employee;
import moduls.enumention.Status;
import repository.implement.EmpoloyeeRepositoryEmployee;
import service.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmployeeServiceEmployee implements Service {
    private int id;
    private EmpoloyeeRepositoryEmployee empoloyeeRepositoryEmployee;
    private Scanner scanner;
    private Random random;
    private Status status;
    private Employee employee;

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeServiceEmployee() {
        try {
            empoloyeeRepositoryEmployee = new EmpoloyeeRepositoryEmployee();
            random = new Random();
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add() {
        try {
            System.out.println("please insert name");
            String name = scanner.next();
            int ids = 55 + random.ints(4, 100, 200).findFirst().getAsInt();
            employee = new Employee(ids, name, ids, status.ACTIVE);
            empoloyeeRepositoryEmployee.add(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AllElement() {
        List<Employee> employeeList = null;
        try {
            employeeList = empoloyeeRepositoryEmployee.AllElement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Employee e : employeeList
        ) {
            System.out.println(e);
        }
    }

    @Override
    public void show() {
        try {
            employee = empoloyeeRepositoryEmployee.show(this.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(employee);
    }

    @Override
    public void delete() {
        System.out.println("please insert id");
        int deId = scanner.nextInt();
        try {
            empoloyeeRepositoryEmployee.delete(deId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify() {

    }
}
