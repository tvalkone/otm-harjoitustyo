
package timecard.ui;

import java.sql.SQLException;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecard.domain.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UserInterface extends Application {
    public Scanner reader;
    public TimecardService service;
    public Database database;
    public Label info;

    public UserInterface() throws Exception{
        this.database = new Database("jdbc:sqlite:timecard.db");
        this.reader = new Scanner(System.in);
        this.service = new TimecardService(this.database);
        this.info = new Label("");
    }

    public TimecardService getService() {
        return service;
    }

    public Database getDatabase() {
        return database;
    }
    public void setInfo(String string) {
        this.info = new Label(string);
    }
    
    @Override
    public void start(Stage window){
        
        BorderPane borderPane = new BorderPane();
        

        LoginScreen loginscreen = new LoginScreen();
        MainScreen mainscreen = new MainScreen();
        NewUserScreen newuserscreen = new NewUserScreen();
        borderPane.setLeft(loginscreen.getView());
        Scene scene = new Scene(borderPane, 640, 320);
        Label info = new Label("Timecard booking service");
        HBox text = new HBox();
        text.getChildren().add(info);
        BorderPane.setAlignment(text, Pos.TOP_CENTER);
        
        
        
        loginscreen.login.setOnAction((event) -> {
            try {
                
                String userid = loginscreen.getUsername().getText();
                String pw = loginscreen.getPassword().getText();
                
                if (this.service.CheckPassWord(userid, pw)){
                        mainscreen.setItems(this.service.getTimecarddao().findAll());
                    borderPane.setLeft(mainscreen.getView());
                    
                }else{
                     loginscreen.getInfo().setText("Wrong username or password, try again!");
                }    
            } catch (SQLException ex) {
            
            }
        });
        
        loginscreen.newuser.setOnAction((event) -> {
            borderPane.setLeft(newuserscreen.getView());
        });  
        
        newuserscreen.ready.setOnAction((event) -> {       
            try {
                String userid = newuserscreen.getUsername().getText();
                String pw = newuserscreen.getPassword().getText();
                String fn = newuserscreen.getUsername().getText();
                String sn = newuserscreen.getUsername().getText();
                if (userid.isEmpty() || userid == null){
                    newuserscreen.setInfo(new Label("username missing!"));
                }
                if(pw.isEmpty()|| pw == null){
                    newuserscreen.setInfo(new Label("password missing!");
                }
                if(fn.isEmpty()|| fn == null){
                    newuserscreen.setInfo(new Label("forename missing!");
                }
                if(sn.isEmpty()|| sn == null){
                    newuserscreen.setInfo(new Label("surname missing!"));
                }else{
                    this.service.getUserdao().saveOrGet(new User(userid, pw, fn, sn));
                    setInfo("New User created, welcome!");
                    mainscreen.setItems(this.service.getTimecarddao().findAll());
                    borderPane.setLeft(mainscreen.getView());
                }    
            } catch (SQLException ex) {
            
            }
        });    
        
        loginscreen.cancel.setOnAction((event) -> {
            try {
                Platform.exit();
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        newuserscreen.cancel.setOnAction((event) -> {
            try {
                Platform.exit();
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
         mainscreen.quit.setOnAction((event) -> {
            try {
                borderPane.setLeft(loginscreen.getView());
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });

        window.setScene(scene);
        window.show();
    }
}
    


