package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Elements.fxml"));
	    
        Scene scene = new Scene(root, 500, 400);
    
        stage.setTitle("Steam Server Control");
        stage.setScene(scene);
        stage.show();
        
        
        Controller con = new Controller();
        Saver save = new Saver();
        
       
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
