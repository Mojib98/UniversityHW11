package service.implement;

import moduls.Course;
import service.Service;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentService implements Service {
    CourseService courseService = new CourseService();
    Scanner scanner = new Scanner(System.in);
    Course course;

    public StudentService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add() {
        System.out.println("");
        int idC=scanner.nextInt();


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
