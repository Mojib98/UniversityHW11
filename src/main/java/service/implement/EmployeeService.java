package service.implement;

import moduls.Employee;
import moduls.Professor;
import moduls.Student;
import moduls.enumention.Status;
import service.Service;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;

public class EmployeeService implements Service {
    private int id;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Status status;
    Professor professor;
    Employee employee;
    Student student;

    @Override
    public void add() {
        System.out.println("please insert name");
        String name = scanner.next();
        int id =95+ random.ints(4, 100, 200).findFirst().getAsInt();
        employee = new Employee(id,name,id,status.ACTIVE);

    }

    public void addStudent() {
        System.out.println("please insert name");
        String name = scanner.next();
        int id =95+ random.ints(4, 100, 200).findFirst().getAsInt();
        student = new Student(id,name,id);
        //use lambda


    }

    public void addProfessor() {
        System.out.println("please insert name");
        String name = scanner.next();
        int id = random.ints(4, 10, 99).findFirst().getAsInt();
        System.out.println("please select status ft or ht ");
        String sete = scanner.next();
        if (sete.equals("ft"))
            status = status.FULLTIME;
        else status = status.HALFTIME;
        professor = new Professor(id, name, id, status);

    }

    @Override
    public void AllElement() {

    }

    @Override
    public void show() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify() {

    }
}
