package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Sportverein;
import business.SportvereinModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class SportvereinView {
	 //---Anfang Attribute der grafischen Oberflaeche---
	private SportvereinModel atModel;
	private SportvereinControl atControl;
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblOrt   		 			= new Label("Ort:");
    private Label lblAnzahlMitglieder  	 	= new Label("Anzahl Mitglieder:");
    private Label lblAnzahlEhemaligerMitglieder   	
     										= new Label("Anzahl ehemaliger Mitglieder:");
    private Label lblSportarten  			= new Label("Sportarten:");
    private TextField txtName 	 			= new TextField();
    private TextField txtOrt				= new TextField();
    private TextField txtAnzahlMitglieder	= new TextField();
    private TextField txtAnzahlEhemaligerMitglieder	
    										= new TextField();
    private TextField txtSportarten	 		= new TextField();
    TextArea txtAnzeige  					= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Sportverein
   
    
    public SportvereinView(SportvereinControl atControl, Stage primaryStage, SportvereinModel atModel){
    	this.atModel = atModel;
    	this.atControl = atControl;
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Sportvereinen");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    

	private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblOrt.setLayoutX(20);
    	lblOrt.setLayoutY(130);
    	lblAnzahlMitglieder.setLayoutX(20);
    	lblAnzahlMitglieder.setLayoutY(170);
    	lblAnzahlEhemaligerMitglieder.setLayoutX(20);
    	lblAnzahlEhemaligerMitglieder.setLayoutY(210);
    	lblSportarten.setLayoutX(20);
    	lblSportarten.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblOrt, lblAnzahlMitglieder,
       		lblAnzahlEhemaligerMitglieder, lblSportarten);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtOrt.setLayoutX(170);
    	txtOrt.setLayoutY(130);
    	txtOrt.setPrefWidth(200);
    	txtAnzahlMitglieder.setLayoutX(170);
    	txtAnzahlMitglieder.setLayoutY(170);
    	txtAnzahlMitglieder.setPrefWidth(200);
      	txtAnzahlEhemaligerMitglieder.setLayoutX(170);
    	txtAnzahlEhemaligerMitglieder.setLayoutY(210);
    	txtAnzahlEhemaligerMitglieder.setPrefWidth(200);
    	txtSportarten.setLayoutX(170);
    	txtSportarten.setLayoutY(250);
    	txtSportarten.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtOrt, txtAnzahlMitglieder,
     		txtAnzahlEhemaligerMitglieder, txtSportarten);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   public void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    atControl.nehmeSportvereinAuf(txtName.getText(), 
           	            txtOrt.getText(),
           	            Integer.parseInt(txtAnzahlMitglieder.getText()),
           	        	Integer.parseInt(txtAnzahlEhemaligerMitglieder.getText()),
            		    txtSportarten.getText().split(";"));
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            atControl.zeigeSportvereineAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	atControl.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	atControl.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				atControl.schreibeSportvereineInCsvDatei();
			}	
	    });
   }
   public void leseAusDatei(String typ){
   	try {
     		if("csv".equals(typ)){
     			BufferedReader ein = new BufferedReader(new FileReader("Sportverein.csv"));
     			String[] zeile = ein.readLine().split(";");
     			this.sportverein = new Sportverein(zeile[0], 
     				zeile[1], 
     				Integer.parseInt(zeile[2]), 
     				Integer.parseInt(zeile[3]), 
     				zeile[4].split("_"));
     				ein.close();
     	  			zeigeInformationsfensterAn(
     	  	   			"Der Sportverein wurde gelesen!");
     		}
      		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
  public void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
  public void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }
   
}
