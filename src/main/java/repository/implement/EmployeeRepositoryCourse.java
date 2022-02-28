package repository.implement;

import moduls.Course;
import repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryCourse implements Repository<Course> {
    private final Connection connection = Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;

    public EmployeeRepositoryCourse() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Course course) throws SQLException {
        String sql = "INSERT INTO course(idc, name, idprofessor, nameprofessor,unit) VALUES (?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,course.getId());
        preparedStatement.setString(2, course.getName());
        preparedStatement.setInt(3,course.getProfessorId());
        preparedStatement.setString(4,course.getProfessor());
        preparedStatement.setInt(5,course.getUnit());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public List<Course> AllElement() throws SQLException {
        Course course;
        List<Course> list = new ArrayList<>();
        String sql = "select * from course";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("idc");
            String name = resultSet.getString("name");
            int unit = resultSet.getInt("unit");
            int idP = resultSet.getInt("idprofessor");
            String nameP = resultSet.getString("nameprofessor");
            course = new Course(id,name,unit,nameP,idP);
            list.add(course);

        }
        preparedStatement.close();
        return list;
    }

    @Override
    public Course show(int id) throws SQLException {
        String sql = "select * from course where idc=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet =preparedStatement.executeQuery();
        resultSet.next();
        int ids = resultSet.getInt("idc");
        String name = resultSet.getString("name");
        int unit = resultSet.getInt("unit");
        int idP = resultSet.getInt("idprofessor");
        String nameP = resultSet.getString("nameprofessor");
       Course course = new Course(ids,name,unit,nameP,idP);
        /*    String name = resultSet.getString("name");
            int unit = resultSet.getInt("unit");
            int idP = resultSet.getInt("idprofessor");
            String nameP = resultSet.getString("nameprofessor");
           Course course = new Course(id,name,unit,nameP,idP);
           preparedStatement.close();*/
           return course;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from course where idc = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void modify(Course course) throws SQLException {

    }
}
