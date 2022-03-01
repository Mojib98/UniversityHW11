import app.Menu;
import moduls.Employee;
import moduls.enumention.Status;
import repository.implement.EmpoloyeeRepositoryEmployee;
import repository.implement.LogInRepository;
import service.implement.*;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {

        System.out.println("_____");
        Menu menu = new Menu();
        menu.loginMenu();
        System.out.println("*************");

    }
}
