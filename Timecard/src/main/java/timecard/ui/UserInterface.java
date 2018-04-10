
package timecard.ui;

import java.sql.SQLException;
import java.util.Scanner;
import timecard.domain.*;

public class UserInterface {
    private Scanner reader;
    private TimecardService service;

    public UserInterface(Scanner reader, Database d) {
        this.reader = reader;
        this.service = new TimecardService(d);  
    }
    
        public void start() throws SQLException{
            System.out.println("Timecard Service");
            System.out.println("Actions:");
            System.out.println("1: Login");
            System.out.println("x: Quit");
        
            while(true){
                System.out.println("");
                System.out.print("Action: ");
                String action = reader.nextLine();
                if (action.equals("x")){
                    break;
                }
                if (action.equals("1")){
                    System.out.print("User Id: ");
                    String userid = reader.nextLine();
                    if(this.service.CheckUser(userid)){
                        System.out.print("Password: ");
                        String pw = reader.nextLine();
                        if(this.service.CheckPassWord(userid, pw)){
                            System.out.println("Welcome user:" +this.service.getUserdao().findOne(userid));
                        }else{
                            System.out.println("Wrong password!");
                        }
                    }else{
                        System.out.println("Unknown user, create new User (y/n)?");
                        String yn = reader.nextLine();
                        if(yn.equals("y")){
                            System.out.print("New password: ");
                            String pw = reader.nextLine();
                            System.out.print("Forename: ");
                            String fn = reader.nextLine();
                            System.out.print("Surname: ");
                            String sn = reader.nextLine();
                            this.service.getUserdao().saveOrGet(new User(userid, pw, fn, sn));
                            System.out.print("New User created");
                        }else{
                            continue;
                        } 
                    }       
                }
            }
        }
}    


