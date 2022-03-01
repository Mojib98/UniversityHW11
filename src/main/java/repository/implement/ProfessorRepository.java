package repository.implement;
import moduls.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProfessorRepository {
    private final Connection connection = Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public ProfessorRepository() throws SQLException, ClassNotFoundException {
    }
    public int myUnit(){
        String sql = "Select sum(section.unit) from section full outer join course c on c.idc = section.idc " +
                "full outer join professor p on p.ide = c.idprofessor " +
                "where p.ide=?";
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
    public List<Course> myCourse() throws SQLException {
        Course course;
        List<Course> list = new ArrayList<>();
        String sql = "Select  *  from section full outer join course c on c.idc = section.idc\n" +
                "                                      full outer join professor p on p.ide = c.idprofessor where p.ide =?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString("namestudent");
            int unit = resultSet.getInt(5);
            int idP = resultSet.getInt("idprofessor");
            String nameP = resultSet.getString("nameprofessor");
            course = new Course(id,name,unit,nameP,idP);
            list.add(course);

        }
        preparedStatement.close();
        return list;
    }
    //insert score by serialId
    public void insertScore(int id,int degre) throws SQLException {
        String sql ="update section set score=? where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,degre);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public String myStatus() throws SQLException {
        String sql="select status from  professor where ide=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }

    }

