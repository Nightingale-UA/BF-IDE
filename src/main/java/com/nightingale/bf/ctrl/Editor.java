package com.nightingale.bf.ctrl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Editor extends SceneChanger implements LanguageExpert {
    @FXML private ListView<String> languages;
    @FXML private ListView<String> percents;

	@FXML private TextArea inputField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {              
        if (Helper.getLangList() == null) Helper.generateLists();        
        languages.setItems(Helper.getLangList());        
		percents.setItems(Helper.getPercList());
		
		String in = Helper.getBfCode();
		if (in != null) inputField.setText(in);
		languages.getSelectionModel().select(Helper.getCurrentLanguage());
		
	}

	@Override
	public void identifyLanguage(MouseEvent event) {
		String code = inputField.getText();
        if (code.length() == 0) return;
		
		languages.getSelectionModel().select(Helper.calculateChances(code));
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
		Helper.setBfCode(inputField.getText());
	}

	@Override
	public void checkBf(MouseEvent event) {
		List<String> errors = Helper.check(inputField.getText());
		if (errors.size() == 0) Helper.setCodeChecked(true);
		// TODO: underline errors in the code		
	}

	@Override
	void chooseLanguage(MouseEvent event) {
		String current = languages.getSelectionModel().getSelectedItem();
		Helper.setCurrentLanguage(current);
	}       
}