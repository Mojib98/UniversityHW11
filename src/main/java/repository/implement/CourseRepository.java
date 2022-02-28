package repository.implement;

import moduls.Course;
import repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseRepository implements Repository<Course> {
    private final Connection connection = Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;

    public CourseRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Course course) throws SQLException {

    }

    @Override
    public List<Course> AllElement() throws SQLException {
        return null;
    }

    @Override
    public Course show(int id) throws SQLException {
        Course course = null;
        String sql = "select * from course where idc=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString(3);
            int unit  = resultSet.getInt(4);
            int idP  = resultSet.getInt(5);
            String nameP = resultSet.getString(6);
            course = new Course(id,name,unit,nameP,idP);
        }
        return course;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void modify(Course course) throws SQLException {

    }
}
