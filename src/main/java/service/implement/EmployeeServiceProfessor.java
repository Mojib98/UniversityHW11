package service.implement;
import moduls.Employee;
import moduls.Professor;
import moduls.Student;
import moduls.enumention.Status;
import repository.implement.EmployeeRepositoryProfessor;
import service.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmployeeServiceProfessor implements Service {
    private int id;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Status status;
    Professor professor;
    Employee employee;
    Student student;
    EmployeeRepositoryProfessor employeeRepositoryProfessor = new EmployeeRepositoryProfessor();

    public EmployeeServiceProfessor() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add() {
        System.out.println("please insert name");
        String name = scanner.next();
        int id = random.ints(4, 1000, 1999).findFirst().getAsInt();
        System.out.println("please select status ft or ht ");
        String sete = scanner.next();
        if (sete.equals("ft"))
            status = status.FULLTIME;
        else status = status.HALFTIME;
        professor = new Professor(id, name, id, status);
        try {
            employeeRepositoryProfessor.add(professor);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void AllElement() {
        List<Professor> list = new ArrayList<>();
        try {
            list = employeeRepositoryProfessor.AllElement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        for (Professor p:list
             ) {
            System.out.println(p);
        }

    }

    @Override
    public void show() {
        System.out.println("Please insert id");
        this.id = scanner.nextInt();
        try {
           Professor professor= employeeRepositoryProfessor.show(id);
            System.out.println(professor);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {
        System.out.println("Please insert id");
        this.id = scanner.nextInt();
        try {
            employeeRepositoryProfessor.delete(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modify() {

    }
    public int findIdProfessor(String name){
        try {
            int id =     employeeRepositoryProfessor.findId(name);
            if (id == -1){
                System.out.println("not find");
                return -1;
            }
            else
                return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
