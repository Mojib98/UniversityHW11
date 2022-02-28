package service.implement;

import moduls.Course;
import repository.implement.EmployeeRepositoryCourse;
import service.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmployeeServiceCourse implements Service {
    private int id;
    Scanner scanner = new Scanner(System.in);
    EmployeeServiceProfessor p = new EmployeeServiceProfessor();
    EmployeeRepositoryCourse e = new EmployeeRepositoryCourse();
    Random random = new Random();
    Course course;

    public EmployeeServiceCourse() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add() {
        System.out.println("please insert name");
        String name = scanner.next();
        int id =95+ random.ints(4, 100, 200).findFirst().getAsInt();
        System.out.println("Plesa insert professor name");
        String profess=scanner.next();
        int idProfessor = p.findIdProfessor(profess);
        System.out.println("Please insert unit");
        int unit  = scanner.nextInt();
        course = new Course(id,name,unit,profess,idProfessor);
        try {
            e.add(course);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public void AllElement() {
        List<Course> list = null;
        try {
            list=e.AllElement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Course v:list
             ) {
            System.out.println(v);
        }
    }

    @Override
    public void show() {
        System.out.println("insert id ");
        int idC= scanner.nextInt();
        try {
            course = e.show(idC);
            System.out.println(course);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("insert id");
        int id = scanner.nextInt();
        try {
            e.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modify() {

    }
}
