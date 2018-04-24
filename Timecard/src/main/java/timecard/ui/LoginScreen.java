/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecard.ui;
import javafx.event.EventType;
import timecard.domain.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class LoginScreen {
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private Label user = new Label("Username :");
    private Label pw = new Label("Password :");
    private Label info = new Label("Login or new user");
    Button login = new Button("Login");
    Button newuser = new Button("New user");
    Button cancel = new Button("Cancel");
    
    public LoginScreen() {    
    }
    
    public Parent getView() {
        
        GridPane setting = new GridPane();
        setting.setAlignment(Pos.TOP_LEFT);
        setting.setVgap(5);
        setting.setHgap(10);
        setting.setPadding(new Insets(5, 5, 5, 5));
        
        
        setting.add(info, 0, 0);
        setting.add(user, 0, 1);
        setting.add(pw, 0, 2);
        
        setting.add(username, 1, 1);
        setting.add(password, 1, 2);
        
        setting.add(login, 0, 10);
        setting.add(newuser, 1, 10);
        setting.add(cancel, 2, 10);

        return setting;
     }

    public Label getInfo() {
        return info;
    }



    public TextField getUsername() {
        return this.username;
    }

    public PasswordField getPassword() {
        return this.password;
    }
  
    
}
