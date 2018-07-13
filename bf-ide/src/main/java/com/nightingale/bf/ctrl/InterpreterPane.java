package com.nightingale.bf.ctrl;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public interface InterpreterPane {
    @FXML void run(MouseEvent event);
    @FXML void clearOutput(MouseEvent event);   
}