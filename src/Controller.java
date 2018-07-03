package bf.cls;

import javafx.fxml.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.collections.*;
import java.net.URL;
import javafx.scene.input.MouseEvent;
import java.util.regex.*;
import java.text.DecimalFormat;
import java.io.*;
import java.util.stream.Collectors;
import java.util.jar.*;

public class Controller implements Initializable {

    @FXML private ListView<String> languages;
    @FXML private ListView<String> percents;
    @FXML private TextArea inputField;
    @FXML private TextField paramsField;
    @FXML private TextArea resultField;
    
    private static final DecimalFormat PERCENT = new DecimalFormat("#%");
    private ObservableList<String> langList = FXCollections.observableArrayList();
    private ObservableList<String> percList = FXCollections.observableArrayList();
    
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
	String jarPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        try (            
            JarInputStream stream = new JarInputStream(new FileInputStream(jarPath));            
        ) {
            for(;;) {
                JarEntry entry = stream.getNextJarEntry();
                if (entry == null) break;
                
                String name = entry.getName();				
                if (name.contains("interpreter") && name.contains("class")) {
                    langList.add(name.substring(name.lastIndexOf('/') + 1, name.lastIndexOf('.')));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	
        langList.sort(Comparator.naturalOrder());
        languages.setItems(langList);
        languages.getSelectionModel().select("Brainfuck");        
        
        
        String init = PERCENT.format(0);
        int size = langList.size();
        for (int i = 0; i < size; i++) {
            percList.add(init);
        }
        percents.setItems(percList);
    }
    
    @FXML
    void run(MouseEvent event) {
        try {
            Interpreter interpreter = (Interpreter) Class.forName("bf.cls.interpreter." + 
							languages.getSelectionModel().getSelectedItem()).newInstance();            
            String code = inputField.getText();
            
            Deque<Integer> params = new ArrayDeque<>();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(paramsField.getText());
            while (m.find()) {
                params.add(Integer.valueOf(m.group()));
            }
            
            resultField.setText(interpreter.interpret(code,params));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException|InstantiationException e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    void calculateChances(MouseEvent event) {
        String code = inputField.getText();
        if (code.length() == 0) return;
        
        int size = langList.size();
        for (int i = 0; i < size; i++) {
            try {
                Interpreter interpreter = (Interpreter) Class.forName("bf.cls.interpreter." + langList.get(i)).newInstance();                
                String op = interpreter.getOp();                              
                
                double countDistinct = (double)code.chars()
                                                   .distinct()
                                                   .count();
                
                double countOpInCode = (double)code.chars()
                                                   .distinct()
                                                   .mapToObj(c -> String.valueOf((char) c))
                                                   .filter(c -> op.contains(c))
                                                   .count();
                
                double k1 = countOpInCode / op.length();
                double k2 = countOpInCode / countDistinct;
                String k = PERCENT.format(k1 * k2);
                percList.set(i,k);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException|InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void identifyLanguage(MouseEvent event) {
        calculateChances(event);
        int max = percList.stream()
                          .mapToInt(s -> Integer.parseInt(s.replaceAll("\\D", "")))
                          .max()
                          .getAsInt();
        if (max == 0) return;
        languages.getSelectionModel().select(percList.indexOf(String.valueOf(max) + "%"));
    }
    
    @FXML
    void clearOutput(MouseEvent event) {
        resultField.clear();
    }
}
