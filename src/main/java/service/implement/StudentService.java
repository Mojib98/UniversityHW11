package service.implement;

import moduls.Course;
import repository.implement.StudentRepository;
import service.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentService implements Service {
    CourseService courseService = new CourseService();
    StudentRepository studentRepository = new StudentRepository();
    Scanner scanner = new Scanner(System.in);
    Course course;

    public StudentService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add() {
        courseService.listCourse();
        System.out.println("please insert your code");
        int idC=scanner.nextInt();
        course = courseService.selectCourseWithStuden(idC);
        try {
            studentRepository.add(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void AllElement() {
        List<Course> list = null;
        try {
            list = studentRepository.AllElement();
            for (Course c: list
                 ) {
                System.out.println(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void delete() {
        System.out.println("select id");
        int ids=scanner.nextInt();
        try {
            studentRepository.delete(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modify() {

    }
    public void seting(int id){
        studentRepository.setId(id);
    }
    private void myaverage(){}
}
