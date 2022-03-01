package repository.implement;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInRepository {
    private final Connection connection = Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;

    public LogInRepository() throws SQLException, ClassNotFoundException {}
        @SneakyThrows
        public boolean loginEmployee(int id , int passcode){
            String sql = "select count(*) from employee where  " +
                    "ide=? and passcode=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,passcode);
            ResultSet r = preparedStatement.executeQuery();
           r.next();
           if (r.getInt(1)>0){
               return true;
           }
           else return false;
        }
    @SneakyThrows
    public boolean loginProfessor(int id , int passcode){
        String sql = "select count(*) from professor where  " +
                "ide=? and passcode=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,passcode);
        ResultSet r = preparedStatement.executeQuery();
        r.next();
        if (r.getInt(1)>0){
            return true;
        }
        else return false;
    }
    @SneakyThrows
    public boolean loginStudent(int id , int passcode){
        String sql = "select count(*) from student where  " +
                "ids=? and passcode=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,passcode);
        ResultSet r = preparedStatement.executeQuery();
        r.next();
        if (r.getInt(1)>0){
            return true;
        }
        else return false;
    }


}
