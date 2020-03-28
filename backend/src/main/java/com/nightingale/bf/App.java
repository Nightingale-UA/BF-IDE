package com.nightingale.bf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

public class App extends Application {    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {        
        SplitPane pane = FXMLLoader.load(getClass().getResource("/fxml/editor.fxml"));
        
        stage.setTitle("BF IDE");
        stage.setScene(new Scene(pane));		
        stage.show();
        
    }  
     
    
}
