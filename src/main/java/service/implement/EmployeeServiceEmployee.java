package service.implement;

import moduls.Employee;
import moduls.Professor;
import moduls.Student;
import moduls.enumention.Status;
import service.Service;

import java.util.Random;
import java.util.Scanner;

public class EmployeeServiceEmployee implements Service {
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
