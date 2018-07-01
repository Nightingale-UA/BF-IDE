package bf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.SplitPane;
import bf.cls.Controller;

public class Main extends Application {
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        SplitPane pane = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        
        stage.setTitle("BF Interpreter");
        stage.setScene(new Scene(pane));		
        stage.show();	
        
    }  
     
    
}