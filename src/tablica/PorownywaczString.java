package tablica;

public class PorownywaczString implements Porownywacz<String> {
	public boolean porownaj (String a, String b){ 
		if (a.compareToIgnoreCase(b) < 0) return true; // podczas porownywania ignorujemy wielkosc liter
		else return false;
		}

}
