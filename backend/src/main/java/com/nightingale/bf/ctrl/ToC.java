package com.nightingale.bf.ctrl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.nightingale.bf.Interpreter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ToC extends SceneChanger implements InterpreterPane, LanguageExpert {
    @FXML private ListView<String> languages;
	@FXML private ListView<String> percents;
	
	@FXML private TextArea inputField;
	@FXML private TextArea resultField;
	@FXML private Button runBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		languages.setItems(Helper.getLangList());
		percents.setItems(Helper.getPercList());

		String in = Helper.getBfCode();
		if (in != null) inputField.setText(in);

		if (!Helper.isChecked()) runBtn.setDisable(true);
		languages.getSelectionModel().select(Helper.getCurrentLanguage());
	}

	@Override
	public void identifyLanguage(MouseEvent event) {
		String code = inputField.getText();
        if (code.length() == 0) return;
		
		languages.getSelectionModel().select(Helper.calculateChances(code));
	}

	@Override
	public void run(MouseEvent event) {
		Interpreter interpreter = Helper.getInterpreterFromList(languages);

		String code = inputField.getText();
		String result = interpreter.toC(code);
		resultField.setText(result);

		Helper.setBfCode(code);
		Helper.setCCode(result);
	}

	@Override
	public void clearOutput(MouseEvent event) {
		resultField.clear();
	}

	@Override
	public void format(MouseEvent event) {
		String code = inputField.getText();
		String formatted = Helper.format(code);
		inputField.setText(formatted);
		Helper.setBfCode(formatted);
	}

	@Override
	public void codeChange(KeyEvent event) {
		Helper.setCodeChecked(false);
		runBtn.setDisable(true);
	}

	@Override
	public void checkBf(MouseEvent event) {
		List<String> errors = Helper.check(inputField.getText());
		if (errors.size() == 0) {
			Helper.setCodeChecked(true);
			runBtn.setDisable(false);
		} else {
			resultField.clear();			
			int n = 1;
			for (String e : errors) {
				resultField.appendText("Error " + n + ": " + e + "\n");
				n++;
			}
		}		
	}

	@Override
	void chooseLanguage(MouseEvent event) {
		String current = languages.getSelectionModel().getSelectedItem();
		Helper.setCurrentLanguage(current);
	}
}