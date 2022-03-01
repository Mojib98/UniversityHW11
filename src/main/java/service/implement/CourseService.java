package service.implement;

import moduls.Course;
import repository.implement.CourseRepository;
import service.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    CourseRepository courseRepository = new CourseRepository();

    public CourseService() throws SQLException, ClassNotFoundException {
    }

    public Course selectCourseWithStuden(int id){
        try {
            return courseRepository.show(id);
        }catch (SQLException e){
            return null;
        }

    }
    public Course InfoCourse(int id){
        try {
            return courseRepository.show(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void listCourse(){
        List<Course> list = new ArrayList<>();
        try {
            list = courseRepository.AllElement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Course c:list
             ) {
            System.out.println(c);
        }
    }



}
