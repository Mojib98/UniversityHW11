package repository.implement;

import moduls.Student;
import repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStudent implements Repository<Student> {
   private Connection connection;
    private PreparedStatement preparedStatement;

    public EmployeeRepositoryStudent() throws SQLException, ClassNotFoundException {
        connection = Singleton.getInstance().getConnection();
    }

    @Override
    public void add(Student student) throws SQLException {
        String sql  = "insert into student(ids, passcode, name) values (?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setInt(2,student.getPasscode());
        preparedStatement.setString(3,student.getName());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public List<Student> AllElement() throws SQLException {
        Student student;
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(2);
            int passcode = resultSet.getInt(3);
            String name = resultSet.getString(4);
            int tota = resultSet.getInt(5);
            student = new Student(id,name,passcode);
            list.add(student);
        }
        preparedStatement.close();
        return list;
    }

    @Override
    public Student show(int id) throws SQLException {
        Student student;
        String sql = "select * from student where  ids=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int ids = resultSet.getInt(2);
        int passcode = resultSet.getInt(3);
        String name = resultSet.getString(4);
        int tota = resultSet.getInt(5);
        student = new Student(ids, name, passcode);

        return student;
    }
    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void modify(Student student) throws SQLException {

    }
}
