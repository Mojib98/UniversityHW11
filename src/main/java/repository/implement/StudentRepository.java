package repository.implement;

import moduls.Course;
import repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements Repository<Course> {
    private Connection connection = Singleton.getInstance().getConnection();
    PreparedStatement preparedStatement;
    int id;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Course course) throws SQLException {
        if (isCourseHere(course)){
            return;
        }
        String sql  = "insert into section(id, namestudent, ids, idc, unit) values (default,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,id);
        preparedStatement.setInt(3,course.getId());
        preparedStatement.setInt(4,course.getUnit());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Course> AllElement() throws SQLException {
        Course course;
        List<Course> list = new ArrayList<>();
        String sql = "select section.idc,name,section.unit,nameprofessor,ids,namestudent,score from section " +
                "full outer join course c on section.idc = c.idc  " +
                "where section.ids=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int idc = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int unit  = resultSet.getInt(3);
            int ids  = resultSet.getInt(5);
            String nameP = resultSet.getString(6);
            int degree = resultSet.getInt(7);
            course = new Course(idc,name,unit,nameP,degree,id);
            list.add(course);
        }
        preparedStatement.close();
        return list;
    }

    @Override
    public Course show(int id) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete  from  section where ids=? and idc=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,this.id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void modify(Course course) throws SQLException {

    }
    private boolean isCourseHere(Course course) throws SQLException {
        String sql="select count(*) from section where ids=? and idc=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,course.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        if (resultSet.getInt(1)>0)
            return true;
        else
            return false;
    }
    private int myUnit(){
        String sql = "Select sum(unit) from section where ids=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
