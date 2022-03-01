package service.implement;

import moduls.Student;
import repository.implement.EmployeeRepositoryStudent;
import service.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmployeeServiceStudent implements Service {
    Scanner scanner;
    Random random;
    Student student;
    EmployeeRepositoryStudent repositoryStudent;

    public EmployeeServiceStudent() throws SQLException, ClassNotFoundException {

        try {
            repositoryStudent = new EmployeeRepositoryStudent();
            scanner = new Scanner(System.in);
            random = new Random();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("please insert name");
        try {
            String name = scanner.next();

            int id = random.ints(4, 2000, 3000).findFirst().getAsInt();
            student = new Student(id, name, id);
            repositoryStudent.add(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AllElement() {
        List<Student> list = null;
        try {
            list = repositoryStudent.AllElement();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Student s:list
             ) {
            System.out.println(s);
        }

    }

    @Override
    public void show() {
        System.out.println("Please insert id");
        int id = scanner.nextInt();
        try {
            student =repositoryStudent.show(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(student);

    }

    @Override
    public void delete() {
        System.out.println("please insert id");
        int id = scanner.nextInt();
    }

    @Override
    public void modify() {

    }
}
