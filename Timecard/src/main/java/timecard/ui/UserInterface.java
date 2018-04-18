
package timecard.ui;

import java.sql.SQLException;
import java.util.Scanner;
import timecard.domain.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
                            System.out.println("");
                            System.out.println("2: Insert time");
                            System.out.println("x: Quit");
                            while(true){
                                System.out.println("");
                                System.out.print("Action: ");
                                String action2 = reader.nextLine();
                                if (action2.equals("x")){
                                    break;
                                }else if (action2.equals("2")){
                                    System.out.print("Week: ");
                                    String week = reader.nextLine();
                                    System.out.print("Project: ");
                                    String projectid = reader.nextLine();
                                    String timecardid = userid + projectid + week;
                                    if(this.service.getTimecarddao().findOne(timecardid) == null){ //check other status
                                        System.out.print("how many hours for Monday: ");
                                        Double day1 = Double.parseDouble(reader.nextLine());
                                        System.out.print("how many hours for Tuesday: ");
                                        Double day2 = Double.parseDouble(reader.nextLine());
                                        System.out.print("how many hours for Wednesday: ");
                                        Double day3 = Double.parseDouble(reader.nextLine());
                                        System.out.print("how many hours for Thursday: ");
                                        Double day4 = Double.parseDouble(reader.nextLine());
                                        System.out.print("how many hours for Friday: ");
                                        Double day5 = Double.parseDouble(reader.nextLine());
                                        System.out.print("how many hours for Saturday: ");
                                        Double day6 = Double.parseDouble(reader.nextLine());
                                        System.out.print("how many hours for Sunday: ");
                                        Double day7 = Double.parseDouble(reader.nextLine());
                                        Timecard c = new Timecard(userid, projectid, week);
                                        c.setTimecardId(timecardid);
                                        c.setDay1(day1);
                                        c.setDay2(day2);
                                        c.setDay3(day3);
                                        c.setDay4(day4);
                                        c.setDay5(day5);
                                        c.setDay6(day6);
                                        c.setDay7(day7);
                                        
                                        this.service.getTimecarddao().save(c);
                                        System.out.print("Timecard saved!");
                                        
                                    }else{
                                        System.out.print("Timecard already closed");
                                    }
                                }else{
                                    System.out.println("Unknown action, try again!");
                                }
                            }       
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
                        }    
                    }       
                }else{
                    System.out.println("Unknown action, try again!");
                }
            }
        }
}    


