package service.implement;

import lombok.SneakyThrows;
import moduls.Course;
import moduls.enumention.Status;
import repository.implement.ProfessorRepository;
import service.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorService implements Service {
    private int id;
    private ProfessorRepository professorRepository = new ProfessorRepository();
    private Scanner scanner = new Scanner(System.in);

    public ProfessorService() throws SQLException, ClassNotFoundException {
    }

    public void setId(int id) {
        this.id = id;
        professorRepository.setId(id);
    }

    @Override
    public void add() {
        AllElement();
        System.out.println("pleas selcet id");
        int idS=scanner.nextInt();
        System.out.println("please insert degree");
        int degre = scanner.nextInt();
        try {
            professorRepository.insertScore(idS,degre);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void AllElement() {
        List<Course> list = new ArrayList<>();
        try {
            list=professorRepository.myCourse();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Course c: list
             ) {
            System.out.println(c);
        }

    }

    @SneakyThrows
    @Override
    public void show() {
        int unit = professorRepository.myUnit();
        String statu = professorRepository.myStatus();
        if (statu.equals(Status.FULLTIME.toString())){
            System.out.println(1000*unit);
        }
        else System.out.println(1000);

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify() {

    }

}
