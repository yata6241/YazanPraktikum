package gui;

import java.io.IOException;

import business.Sportverein;
import business.SportvereinModel;
import javafx.stage.Stage;

public class SportvereinControl {
	private SportvereinModel atModel;
	private SportvereinView atView;

	public SportvereinControl(Stage primaryStage) {
		super();
		this.atModel = new SportvereinModel();
		this.atView = new SportvereinView(this, primaryStage, atModel);
	}
	public void nehmeSportvereinAuf(String name, String ort, int anzahlMitglieder, int anzahlEhemaligerMitglieder,
			String[] sportarten) {
		try {
			this.atModel.setSportverein(
					new Sportverein(name, ort, anzahlMitglieder, anzahlEhemaligerMitglieder, sportarten));
		} catch (Exception exc) {
			atView.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}
	
	public void zeigeSportvereineAn() {
		if (this.atModel.getSportverein() != null) {
			this.atView.txtAnzeige.setText(
			this.atModel.getSportverein().gibSportvereinZurueck(' '));
		} else {
			atView.zeigeInformationsfensterAn("Bisher wurde keine Sportverein aufgenommen!");
		}
	}

	public void schreibeSportvereineInCsvDatei() {
		try {

			atModel.schreibeSportvereineInCsvDatei();
		} catch (IOException exc) {
			atView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			atView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	public void leseAusDatei(String typ) {
		try {
			atModel.leseAusDatei(typ);
		} catch (IOException exc) {
			atView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			atView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	
}
