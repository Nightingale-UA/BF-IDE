package com.nightingale.bf.ctrl;

import java.net.URL;
import java.util.ResourceBundle;

import com.nightingale.bf.Interpreter;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class StringToBf extends SceneChanger implements InterpreterPane {
    @FXML private ListView<String> languages;
    @FXML private ListView<String> percents;

	@FXML private TextArea resultField;
	@FXML private TextField inputField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		languages.setItems(Helper.getLangList());
		percents.setItems(Helper.getPercList());

		String in = Helper.getResultedString();
		if (in != null) inputField.setText(in);
		languages.getSelectionModel().select(Helper.getCurrentLanguage());
	}
	
	@Override
	public void run(MouseEvent event) {
		Interpreter interpreter = Helper.getInterpreterFromList(languages);
		String target = inputField.getText();
		String code = interpreter.fromString(target);

		resultField.setText(code);
		Helper.setBfCode(code);
		Helper.setResultedString(target);
	}

	@Override
	public void clearOutput(MouseEvent event) {
		resultField.clear();
	}

	@Override
	void chooseLanguage(MouseEvent event) {
		String current = languages.getSelectionModel().getSelectedItem();
		Helper.setCurrentLanguage(current);
	}
}