/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecard.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import timecard.domain.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainScreen {
    public Label reports = new Label("Reports");
    public Label projects = new Label("Projects:");
    public Button opentimecard = new Button("Open timecard");
    public Button newtimecard = new Button("New timecard");
    public Button quit = new Button("Quit");
    public static final ObservableList names = FXCollections.observableArrayList();
    public static final ObservableList data = FXCollections.observableArrayList();
    public ListView<Timecard> listOfTimecards;
    public ObservableList<Timecard> items = FXCollections.observableArrayList();;
    private Label info = new Label("Timecard service");
    
    public MainScreen() {
    }

    public ListView<Timecard> getListOfTimecards() {
        return listOfTimecards;
    }

    public void setListOfTimecards(ListView<Timecard> listOfTimecards) {
        this.listOfTimecards = listOfTimecards;
    }

    public ObservableList<Timecard> getItems() {
        return items;
    }

    public void setItems(ObservableList<Timecard> items) {
        this.items = items;
        
    }
    
    public Label getInfo() {
        return info;
    }
    

    public Parent getView() {
        
        GridPane setting = new GridPane();
        setting.setAlignment(Pos.CENTER_LEFT);
        setting.setVgap(10);
        setting.setHgap(10);
        setting.setPadding(new Insets(10, 10, 10, 10));

        setting.add(reports, 0, 0);
        setting.add(projects, 0, 1);
        setting.add(opentimecard, 1, 0);
        setting.add(newtimecard, 1, 1);
        setting.add(quit, 1, 2);
        
        this.listOfTimecards = new ListView<>();
        
        
        
        listOfTimecards.setItems(items);
        listOfTimecards.setPrefWidth(200);
        listOfTimecards.setPrefHeight(100);
        setting.add(listOfTimecards, 6, 0);
        return setting;
    }    
    
}
