
package timecard.ui;
import timecard.domain.*;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        UserInterface ui = new UserInterface(reader);
        Database database = new Database("jdbc:sqlite:timecard.db");

    
        

    }
}
