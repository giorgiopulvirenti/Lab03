/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;


import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;


public class SpellCheckerController {
	Dictionary dictionary= new Dictionary();
	ArrayList<String> input=new ArrayList<String>();
	ArrayList<RichWord> rich;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="errori"
    private Label errori; // Value injected by FXMLLoader
    
    @FXML // fx:id="durata"
    private Label durata; // Value injected by FXMLLoader
    
    @FXML // fx:id="comboBox"
    private ComboBox<String> comboBox; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea1"
    private TextField txtArea1; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpell"
    private Button btnSpell; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea2"
    private TextField txtArea2; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtArea1.clear();
    	this.txtArea2.clear();

    }

    @FXML
    void doCombo(ActionEvent event) {
    	
    	dictionary.loadDictionary(this.comboBox.getValue());
    	System.out.println("a".compareTo("b"));
    	System.out.println("a".compareTo("l'"));
    	System.out.println("l'aquila".compareTo("b"));

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	input.clear();
    	String array[]=null;
    	long l=System.nanoTime();
    int h=0;
    	array=this.txtArea1.getText().split(" ");
    	for (int i =0;i<array.length;i++)
    		input.add(array[i]);
    		
    	rich= (ArrayList<RichWord>) dictionary.spellCheckText(input);
    	System.out.println(rich);
    	for(RichWord s: rich){
    		if (!s.isCorretta()){
    			h++;
    			this.txtArea2.appendText(s.getParola()+" ");
    			
    		}
    		
    	}
    	this.errori.setText("parole errate"+h);
    	this.durata.setText("durata"+(System.nanoTime()-l));
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	this.comboBox.getItems().addAll("Italian","English");
    	assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtArea1 != null : "fx:id=\"txtArea1\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtArea2 != null : "fx:id=\"txtArea2\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert errori != null : "fx:id=\"errori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert durata != null : "fx:id=\"durata\" was not injected: check your FXML file 'SpellChecker.fxml'.";
    }
}
