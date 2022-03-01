package service.implement;

import moduls.Person;
import repository.implement.LogInRepository;

import java.sql.SQLException;

public class LogInService {
    LogInRepository logInRepository;

    {
        try {
            logInRepository = new LogInRepository();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int id,passcode;
    public boolean loginEmployee(int id,int passcode){
        return logInRepository.loginEmployee(id,passcode);

    }
    public boolean logInProfessor(int id,int passcode){
        return logInRepository.loginProfessor(id, passcode);
    }
    public boolean loginStuden(int id,int passcode){
        return logInRepository.loginStudent(id,passcode);
    }
}
