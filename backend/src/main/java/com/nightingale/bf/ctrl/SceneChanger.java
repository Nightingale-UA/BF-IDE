package com.nightingale.bf.ctrl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public abstract class SceneChanger implements Initializable {      
    @FXML abstract void chooseLanguage(MouseEvent event);
    
    @FXML 
    void editorBtn(MouseEvent event) {
        String paneName = "/fxml/editor.fxml";
        Helper.callPane(paneName, event);
    }
    @FXML 
    void bfToStringBtn(MouseEvent event) {
        String paneName = "/fxml/toString.fxml";
        Helper.callPane(paneName, event);
    }
    @FXML 
    void stringToBfBtn(MouseEvent event) {
        String paneName = "/fxml/stringToBf.fxml";
        Helper.callPane(paneName, event);
    }
    @FXML 
    void cToBfBtn(MouseEvent event) {
        String paneName = "/fxml/cToBf.fxml";
        Helper.callPane(paneName, event);
    }
    @FXML 
    void bfToCBtn(MouseEvent event) {
        String paneName = "/fxml/toC.fxml";
        Helper.callPane(paneName, event);
    }
}