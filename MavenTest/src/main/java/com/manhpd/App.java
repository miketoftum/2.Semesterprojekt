package com.manhpd;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("FrontPage"), 640, 480);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public Stage getStage(){
        return stage;
    }


    public static void main(String[] args) {

        Logger.getLogger("").setLevel(Level.WARNING);

        String Connectionstring =  "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(Connectionstring);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Productions");
        MongoCollection productionsCollection = mongoDatabase.getCollection("Productions");

        CodecRegistry pojocoderegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),pojocoderegistry);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(Connectionstring)).codecRegistry(codecRegistry).build();
        MongoClient pojoClient = MongoClients.create(mongoClientSettings);

        MongoDatabase pojodatabase = pojoClient.getDatabase("Productions");
        MongoCollection<Credits> pojoProductionCollection = pojodatabase.getCollection("Productions",Credits.class);

        pojoProductionCollection.insertOne(new Credits(1,"pn",2020,1,"pen","op"));

        App app = new App();
        pojoProductionCollection.insertMany(app.getProductions());
        launch();
    }

    public ObservableList<Credits> getProductions() {
        ObservableList<Credits> productions = FXCollections.observableArrayList();
        productions.add(new Credits(2, "Druk",2020,2,"Mads Mikkelsen","Actor"));
        productions.add(new Credits(3,  "Retfærdighedens ryttere",2020,3,"Lars Brygmann","Actor"));
        productions.add(new Credits(4, "Journal 64",2018,4,"Nikolaj Lie Kaas","Actor"));
        return productions;

    }

}

