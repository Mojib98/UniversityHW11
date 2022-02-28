package service.implement;

import moduls.Course;
import repository.implement.CourseRepository;
import service.Service;

import java.sql.SQLException;

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



}
