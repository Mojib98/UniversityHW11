package app;

import service.implement.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private int id,passCode;
    Scanner scanner = new Scanner(System.in);
    LogInService logInService = new LogInService();
    EmployeeServiceEmployee employee ;
    EmployeeServiceStudent eSService;
    EmployeeServiceProfessor eSPService;
    EmployeeServiceCourse eSCService ;
    StudentService studentService ;
    ProfessorService professorService;

    public Menu() throws SQLException, ClassNotFoundException {
        employee = new EmployeeServiceEmployee();
        eSService = new EmployeeServiceStudent();
        eSPService =new EmployeeServiceProfessor();
        eSCService  = new EmployeeServiceCourse();
        studentService = new StudentService();
        professorService = new ProfessorService();

    }

    public void loginMenu() throws InterruptedException {
        System.out.println("please insert your Id");
        id = scanner.nextInt();
        System.out.println("please insert your passcode");
        passCode = scanner.nextInt();
        if (id> 100 & id <999){
            if (logInService.loginEmployee(id,passCode)){
                employee();
            }
        }
        if (id> 1000 & id <1999){
            System.out.println("ggg");
            if (logInService.logInProfessor(id,passCode)){
                professor();
            }
        }
        if (id> 2000 & id <3000){
            if (logInService.loginStuden(id,passCode)){
                student();

            }
        }
    }
    private void employee() throws InterruptedException {
        boolean isEmployeeHere = true;
        employee.setId(this.id);
        while (isEmployeeHere){
            menuEmployee();
            int selection = scanner.nextInt();
            switch (selection){
                case 1:
                    employee.add();
                    break;
                case 2:
                    employee.delete();
                    break;
                case 3:
                    eSService.add();
                    break;
                case 4:
                    eSService.delete();
                    break;
                case 5:
                    eSPService.add();
                    break;
                case 6:
                    eSCService.add();
                    break;
                case 7:
                    eSCService.delete();
                    break;
                case 8:
                    employee.show();
                    break;
                case 9:
                    eSPService.AllElement();
                    Thread.sleep(1000);
                    break;
                case 10:
                    eSService.AllElement();
                    Thread.sleep(1000);

                    break;
                case 11:
                    eSCService.AllElement();
                    Thread.sleep(1000);

                    break;
                case 12:
                    isEmployeeHere=false;
                case 13:
            }
        }



    }
    private void menuEmployee(){
        System.out.println("welcome\n" +
                "for do action please select\n" +
                "for add employee insert 1\n" +
                "for delete employee isnsert 2\n" +
                "for add student insert 3\n" +
                "for delete insert 4\n" +
                "for add professor insert 5\n" +
                "for add course insert 6\n" +
                "for delete course insert 7\n" +
                "for see your insformation insert8\n" +
                "for see information of all professor insert 9 ,student 10 and employee 11\n" +
                "for exit insert 12" );
    }
    private void student(){
        studentService.seting(id);
        boolean isStudentHere = true;
        while (isStudentHere){
            System.out.println("for section insert 1             \n" +
                               "for delete insert 2              \n" +
                               "for see your information insert 3\n" +
                                "for exit insert 4 " );
            int section = scanner.nextInt();
            switch (section){
                case 1:
                    studentService.add();
                    break;
                case 2:
                    studentService.delete();
                    break;
                case 3:
                    studentService.AllElement();
                    break;
                case 4:
                    isStudentHere = false;
            }
        }
    }
    private void professor(){
        professorService.setId(id);
        boolean isProfessorHere = true;
        while (isProfessorHere){
            System.out.println("for insert degree select 1\n" +
                    "for shoe info select 2");
            int secletio= scanner.nextInt();
            switch (secletio){
                case 1:
                    professorService.add();
                    break;
                case 2:
                    professorService.show();
                case 3:
                    professorService.AllElement();
                case 4:
                    isProfessorHere=false;
            }
        }
    }



}
