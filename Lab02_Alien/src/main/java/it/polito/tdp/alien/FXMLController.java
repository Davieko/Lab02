package it.polito.tdp.alien;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Map<String, String> dictionary = new HashMap<String, String>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField input;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea output;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String s = input.getText();
    	if(s.compareTo("") == 0 || s == null)
    		output.setText("Inserisci qualcosa!");
    	
    	StringTokenizer st = new StringTokenizer(s, " ");
    	
    	switch(st.countTokens()) {
    	
	    	case 1:
	    		String alienWord = st.nextToken();
	    		if(alienWord.matches("[a-zA-Z]*")) {
	    			if(dictionary.containsKey(alienWord))
	    				output.setText(dictionary.get(alienWord));
	    			else
	    				output.setText("Non c'è la parola");
	    		} else
	    			output.setText("Intesisci solo lettere alfabetiche");
	    		break;
	    		
	    	case 2:
	    		String alienWord2 = st.nextToken();
	    		String translate = st.nextToken();
	    		if(alienWord2.matches("[a-zA-Z]*") && translate.matches("[a-zA-Z]*")) {
	    			dictionary.put(alienWord2, translate);
	    		} else
	    			output.setText("Intesisci solo lettere alfabetiche");
	    		break;
	    		
    		default:
    			output.setText("Intesisci una o max due parole");
    			break;
    	}
    }
    

    
    @FXML
    void initialize() {
        assert input != null : "fx:id=\"input\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert output != null : "fx:id=\"output\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}