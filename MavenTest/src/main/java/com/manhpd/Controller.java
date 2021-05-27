package com.manhpd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.Predicate;

public class Controller {
    //Configurere table

    //  @FXML
    //private TextField SearchField;

    @FXML
    private Label WelcomeLabel;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    App ap = new App();

    Stage window;
    TableView<Credits> table;
    TextField IdInput, NameInput, YearInput, PersonIDInput, PersonNameInput, OccupationInput, SearchField;

    HashMap<String,String> AccountInfo = new HashMap<>();{
        AccountInfo.put("John Smith", "Some");
        AccountInfo.put("Mary Jane", "SomePassword");
        AccountInfo.put("Jessica Lange", "SomePassword");
    }

    @FXML
    private void LoginButton(ActionEvent event) throws IOException {
        WelcomeLabel.setText("Welcome to Smart Credit");

        String uname = username.getText();
        String pword = password.getText();

        if (AccountInfo.keySet().contains(uname) && AccountInfo.get(uname).equals(pword)){
            User s = new User();
            window = s.getWindow();
            App a = new App();
            window = a.getStage();
            window.setTitle("Credits");

            TableColumn<Credits, Integer> IDColumn = new TableColumn("ID");
            IDColumn.setMinWidth(50);
            IDColumn.setCellValueFactory(new PropertyValueFactory("ProductionID"));

            TableColumn<Credits, String> NameColumn = new TableColumn("Name");
            NameColumn.setMinWidth(200);
            NameColumn.setCellValueFactory(new PropertyValueFactory("ProductionName"));

            TableColumn<Credits, String> YearColumn = new TableColumn("Year");
            YearColumn.setMinWidth(70);
            YearColumn.setCellValueFactory(new PropertyValueFactory("Year"));

            TableColumn<Credits, Integer> PersonIDColumn = new TableColumn("PersonID");
            PersonIDColumn.setMinWidth(50);
            PersonIDColumn.setCellValueFactory(new PropertyValueFactory("PersonID"));

            TableColumn<Credits, String> PersonNameColumn = new TableColumn("PersonName");
            PersonNameColumn.setMinWidth(200);
            PersonNameColumn.setCellValueFactory(new PropertyValueFactory("PersonName"));

            TableColumn<Credits, String> OccupationColumn = new TableColumn("Occupation");
            OccupationColumn.setMinWidth(200);
            OccupationColumn.setCellValueFactory(new PropertyValueFactory("Occupation"));

            IdInput = new TextField();
            IdInput.setPromptText("Id");
            IdInput.setMinWidth(50);

            SearchField = new TextField();
            SearchField.setPromptText("Search");
            SearchField.setMinWidth(70);

            NameInput = new TextField();
            NameInput.setPromptText("Production"+" "+"Name");
            NameInput.setMinWidth(50);

            YearInput = new TextField();
            YearInput.setPromptText("Year");
            YearInput.setMinWidth(50);

            PersonIDInput = new TextField();
            PersonIDInput.setPromptText("PersonID");
            PersonIDInput.setMinWidth(50);

            PersonNameInput = new TextField();
            PersonNameInput.setPromptText("Person" + " " + "Name");
            PersonNameInput.setMinWidth(50);

            OccupationInput = new TextField();
            OccupationInput.setPromptText("Occupation");
            OccupationInput.setMinWidth(50);

            Button addButton  = new Button("Add");
            addButton.setOnAction(e -> addbuttonClicked());
            Button deleteButton  = new Button("Delete");
            deleteButton.setOnAction(e -> deletebuttonClicked());

            Button LogoutButton  = new Button("Log Out");
            LogoutButton.setOnAction(e -> LogoutButtonClicked());

            HBox hbox = new HBox();
            hbox.setPadding(new Insets(5,10,10,5));
            hbox.setSpacing(10);
            hbox.getChildren().addAll(IdInput,NameInput,YearInput,PersonIDInput, PersonNameInput, OccupationInput,addButton,deleteButton,LogoutButton);

            table = new TableView<>();
            table.setItems(ap.getProductions());
            table.getColumns().addAll(IDColumn, NameColumn,YearColumn,PersonIDColumn,PersonNameColumn,OccupationColumn);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(table,hbox);

            //11.18

            Scene scene = new Scene(vbox);
            window.setScene(scene);
            window.show();

        }else{
            WelcomeLabel.setText("Invalid LoginInfo");
        }

    }

    public void LogoutButtonClicked(){
        System.exit(0);
    }


    public void addbuttonClicked(){
        Credits credits = new Credits();
        credits.setProductionName(NameInput.getText());
        credits.setProductionID(Integer.parseInt(IdInput.getText()));
        credits.setYear(Integer.parseInt(YearInput.getText()));
        credits.setPersonID(Integer.parseInt(PersonIDInput.getText()));
        credits.setPersonName(PersonNameInput.getText());
        credits.setOccupation(OccupationInput.getText());
        table.getItems().add(credits);
        NameInput.clear();
        IdInput.clear();
        YearInput.clear();
        PersonIDInput.clear();
        PersonNameInput.clear();
        OccupationInput.clear();

    }
    //delete button clicked
    public void deletebuttonClicked(){
        ObservableList<Credits> productionSelected, allProductions;
        allProductions = table.getItems();
        productionSelected = table.getSelectionModel().getSelectedItems();
        productionSelected.forEach(allProductions::remove);
    }


    //this could be used to database - Here starts yt video

    App gl = new App();



    @FXML
    private void GuestButton(ActionEvent event) throws IOException {
        User se = new User();
        window = se.getWindow();
        App aa = new App();
        window = aa.getStage();
        window.setTitle("Credits");

        TableColumn<Credits, Integer> IDColumn = new TableColumn("ID");
        IDColumn.setMinWidth(50);
        IDColumn.setCellValueFactory(new PropertyValueFactory("ProductionID"));

        TableColumn<Credits, String> NameColumn = new TableColumn("Name");
        NameColumn.setMinWidth(200);
        NameColumn.setCellValueFactory(new PropertyValueFactory("ProductionName"));

        TableColumn<Credits, String> YearColumn = new TableColumn("Year");
        YearColumn.setMinWidth(70);
        YearColumn.setCellValueFactory(new PropertyValueFactory("Year"));

        TableColumn<Credits, Integer> PersonIDColumn = new TableColumn("PersonID");
        PersonIDColumn.setMinWidth(50);
        PersonIDColumn.setCellValueFactory(new PropertyValueFactory("PersonID"));

        TableColumn<Credits, String> PersonNameColumn = new TableColumn("PersonName");
        PersonNameColumn.setMinWidth(200);
        PersonNameColumn.setCellValueFactory(new PropertyValueFactory("PersonName"));

        TableColumn<Credits, String> OccupationColumn = new TableColumn("Occupation");
        OccupationColumn.setMinWidth(200);
        OccupationColumn.setCellValueFactory(new PropertyValueFactory("Occupation"));

        table = new TableView<>();
        table.setItems(ap.getProductions());
        table.getColumns().addAll(IDColumn, NameColumn,YearColumn,PersonIDColumn,PersonNameColumn,OccupationColumn);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void UserButton(ActionEvent event) throws IOException {
        Parent guestButton = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene GuestScene = new Scene(guestButton);

        // get the stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(GuestScene);
        window.show();
    }
    @FXML
    private void BackToFrontPageButton(ActionEvent event) throws IOException {
        Parent guestButton = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        Scene GuestScene = new Scene(guestButton);

        // get the stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(GuestScene);
        window.show();
    }
    public void getDATA (ActionEvent actionEvent){

    }
}
