package business;

public class Sportverein {
	
    private String name;
    private String ort;
    private int anzahlMitglieder;
    private int anzahlEhemaligerMitglieder;
    private String[] sportarten;
    
    public Sportverein(String name, String ort, int anzahlMitglieder,
       	int anzahlEhemaligerMitglieder, String[] sportarten){
    	this.name = name;
      	this.ort = ort;
       	this.anzahlMitglieder = anzahlMitglieder;
       	this.anzahlEhemaligerMitglieder = anzahlEhemaligerMitglieder;
       	this.sportarten = sportarten;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getAnzahlMitglieder() {
		return anzahlMitglieder;
	}

	public void setAnzahlMitglieder(int anzahlMitglieder) {
		this.anzahlMitglieder = anzahlMitglieder;
	}

	public int getAnzahlEhemaligerMitglieder() {
		return anzahlEhemaligerMitglieder;
	}

	public void setAnzahlEhemaligerMitglieder(int anzahlEhemaligerMitglieder) {
		this.anzahlEhemaligerMitglieder = anzahlEhemaligerMitglieder;
	}

	public String[] getSportarten() {
		return sportarten;
	}

	public void setSportarten(String[] sportarten) {
		this.sportarten = sportarten;
	}
	
 	public String getSportartenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getSportarten().length - 1; i++) {
			ergebnis = ergebnis + this.getSportarten()[i] + trenner; 
		}
		return ergebnis	+ this.getSportarten()[i];
	}
	
	public String gibSportvereinZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getOrt() + trenner
  			+ this.getAnzahlMitglieder() + trenner
  		    + this.getAnzahlEhemaligerMitglieder() + trenner + "\n"
  		    + this.getSportartenAlsString(trenner) + "\n";
  	}
}

