package com.manhpd;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class User extends Application {

    //ytVideo
    Stage window;
    TableView<Credits> table;
    TextField IdInput, NameInput;

    public static void main(String[] args) {
        launch();
    }

    public Stage getWindow() {
        return window;
    }


    @Override
    public void start(Stage stage) throws IOException {
        //here
        window = stage;
        window.setTitle("Credits");

        TableColumn<Credits, Integer> IDColumn = new TableColumn("ID");
        IDColumn.setMinWidth(200);
        IDColumn.setCellValueFactory(new PropertyValueFactory("ProductionID"));

        TableColumn<Credits, String> NameColumn = new TableColumn("Name");
        NameColumn.setMinWidth(200);
        NameColumn.setCellValueFactory(new PropertyValueFactory("ProductionName"));

        IdInput = new TextField();
        IdInput.setPromptText("Id");
        IdInput.setMinWidth(100);

        NameInput = new TextField();
        NameInput.setPromptText("Production"+" "+"Name");

        Button addButton  = new Button("Add");
        addButton.setOnAction(e -> addbuttonClicked());
        Button deleteButton  = new Button("Delete");
        deleteButton.setOnAction(e -> deletebuttonClicked());

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(IdInput,NameInput,addButton,deleteButton);

        table = new TableView<>();
        table.setItems(getProductions());
        table.getColumns().addAll(IDColumn, NameColumn);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table,hbox);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addbuttonClicked(){
        Credits credits = new Credits();
        credits.setProductionName(NameInput.getText());
        credits.setProductionID(Integer.parseInt(IdInput.getText()));
        table.getItems().add(credits);
        NameInput.clear();
        IdInput.clear();

    }
    //delete button clicked
    public void deletebuttonClicked(){
        ObservableList<Credits> productionSelected, allProductions;
        allProductions = table.getItems();
        productionSelected = table.getSelectionModel().getSelectedItems();

        productionSelected.forEach(allProductions::remove);
    }

    //this could be used to database - Here starts yt video
    public ObservableList<Credits> getProductions() {
        ObservableList<Credits> productions = FXCollections.observableArrayList();
        productions.add(new Credits(1, "Druk",2020,1,"Mads Mikkelsen","Actor"));
        productions.add(new Credits(2,  "Retfærdighedens ryttere",2020,2,"Lars Brygmann","Actor"));
        productions.add(new Credits(3, "Journal 64",2018,2,"Nikolaj Lie Kaas","Actor"));
        return productions;
    }
}
