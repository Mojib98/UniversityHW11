package repository.implement;

import moduls.Employee;
import moduls.Professor;
import moduls.enumention.Status;
import repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryProfessor implements Repository<Professor> {
    private final Connection connection = Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;

    public EmployeeRepositoryProfessor() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Professor professor) throws SQLException {
        String sql ="insert into professor(ide, name, passcode, status) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,professor.getId());
        preparedStatement.setString(2,professor.getName());
        preparedStatement.setInt(3,professor.getPasscode());
        preparedStatement.setString(4,professor.getStatus().toString());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public List<Professor> AllElement() throws SQLException {
        List<Professor> list = new ArrayList<>();
        String sql = "select * from  professor ";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("ide");
            String name = resultSet.getString("name");
            int passcode = resultSet.getInt("passcode");
            String sta = resultSet.getString("status");
            Professor professor = new Professor(id, name, passcode, Status.ACTIVE);
            list.add(professor);
        }
        return list;
    }

    @Override
    public Professor show(int id) throws SQLException {
        Status status;
        Professor professor;
        String sql = "select * from professor " +
                "where  ide=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            int passcode = resultSet.getInt("passcode");
            String sta = resultSet.getString("status");

            professor = new Professor(id,name,passcode,Status.valueOf(sta));
            preparedStatement.close();
            return professor;

    }
        preparedStatement.close();
        return null;

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from professor where ide = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void modify(Professor professor) throws SQLException {

    }
    public int findId(String name) throws SQLException {
        int ide = -1;
        String sql = "select ide from professor where name =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
         ide = resultSet.getInt(1);
        return ide;
    }

}
