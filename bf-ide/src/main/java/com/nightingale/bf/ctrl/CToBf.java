package com.nightingale.bf.ctrl;

import java.net.URL;
import java.util.ResourceBundle;

import com.nightingale.bf.Interpreter;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class CToBf extends SceneChanger implements InterpreterPane {
    @FXML private ListView<String> languages;
    @FXML private ListView<String> percents;

	@FXML private TextArea resultField;
	@FXML private TextArea inputField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		languages.setItems(Helper.getLangList());
		percents.setItems(Helper.getPercList());

		String in = Helper.getCCode();
		if (in != null) inputField.setText(in);
		languages.getSelectionModel().select(Helper.getCurrentLanguage());
	}

	@Override
	public void run(MouseEvent event) {
		Interpreter interpreter = Helper.getInterpreterFromList(languages);

		String cCode = inputField.getText();
		String bfCode = interpreter.fromHighLevel(cCode);

		resultField.setText(bfCode);
		Helper.setBfCode(bfCode);
		Helper.setCCode(cCode);
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