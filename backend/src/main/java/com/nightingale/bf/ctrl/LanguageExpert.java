package com.nightingale.bf.ctrl;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public interface LanguageExpert {
    @FXML void identifyLanguage(MouseEvent event);
    @FXML void format(MouseEvent event);
    @FXML void codeChange(KeyEvent event);
    @FXML void checkBf(MouseEvent event);
}