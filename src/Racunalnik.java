import java.io.File;

/*
 *Deklariramo javni razred 
 */
public class Racunalnik{
	
	
	/**
	 * Deklariramo lastnosti 
	 */
	public boolean jeVklopljen;  // stanje ali je ra�unalnik vklopljen (public zaradi dostopa v dedovan class)
	private String vrsta;        // vrsta ra�unalnika 
	private String sistem;       // podatki o sistemu 
	private String sistemDisk;   // podatki o sistemskem disku
	private String errMsg        = "ERR: Sistem ni zagnan!"; // enoten string za napako, �e je ra�unalnik izklopljen


	/**
	 * Konstruktor kjer inicializiramo lastnosti
	 * 
	 * @param vkl BOOLEAN - je naprava vklopljena?
	 * @param vrs String - Vrsta naprave (prenosnik, ...)
	 */
	public Racunalnik( boolean vkl, String vrs){
		jeVklopljen     = vkl;
		vrsta		    = vrs;
		sistem			= "Sistem še ni določen!"; 		// ob zagonu �e ne vemo kak�en sistem je nalo�en
		sistemDisk		= "0"; 							// ob zagonu �e ne poznamo koli�ine, osnovna vrednost je 0
	}
	
	
	/**
	 * @return Vrne sistem, če je naprava vključena
	 */
	public String getSistem(){
		if (jeVklopljen){
			sistem = System.getProperty("os.name").toLowerCase();
			return sistem;
		}else{
			return errMsg;
		}
	}
	
	
	/**
	 * Metoda ki nastavi in vrne vrsto sistema 
	 * 
	 * @param v Vrsta naprave
	 * @return vrne nastavljeno vrednost naprave
	 */
	public String vrstaRac(String v){
		if (jeVklopljen == false){
			return errMsg;
		}
		
		if (v == ""){
			/**
			 * vrednost v ni nastavljena (v = nova vrsta pc-ja)
			 * v tem primeru ne naredimo ni�, ker je return za if-om 
			 */
		}else{
			vrsta = v;			
		}
		return vrsta;
	}


	/**
	 * preverimo če disk obstaja, in s pomočjo knjižnice java.io.file dobimo informacijo, koliko prostora
	 * ima ta disk. Nato z funkcijo velikost vrnemo lažje berljivo velikost naprave.
	 * Če disk ni prisoten (pogon) potem vrne obvestilo, da pogon ne obstaja
	 * 
	 * @param crkaPogona črka pogona, ki jo preverjamo
	 * @return če pogon obstaja, vrne velikost pogona 
	 */
	public String sistemDisk(String crkaPogona){
		if (jeVklopljen == false){
			return errMsg;
		}
		if (crkaPogona != ""){
			File f = new File(crkaPogona + ":\\");
			if ( f.exists() ){
				sistemDisk = velikost( f.getTotalSpace() );
				return sistemDisk;
			}else{
				return "Pogon " + crkaPogona + ":\\ ne obstaja!";
			}
		}else{
			return "Črka pogona ni definirana";
		}
	}
	
	
	/**
	 * stikalo za vklop in izklop naprave
	 * 
	 * @return ob klicu se spremeni stanje iz vklopljenega v izklopljenega in obratno, simulira pritisk na gumb :)
	 */
	public boolean stikalo(){
		if (jeVklopljen){
			jeVklopljen = false;
		}else{
			jeVklopljen = true;
		}
		return jeVklopljen;
	}
	
	
	/**
	 * @return vrne string z opisom vrste 
	 */
	public String getVrsta() {
		return vrsta;	
		
	}
	
	
	/**
	 * Privatna funkcija znotraj metode
	 * 
	 * @param size velikost, ki jo želimo formatirati in izpisati
	 * @return Velikost z definicij GB, Mb,...
	 */
	private String velikost(float size){
		if ( size > 1000000000) {
			// gigabytes
			return size / 1000000000.00 + " GB";
		} else if ( size > 1000000) {
			// megabyte
			return size / 1000000.00 + " Mb";
		} else if ( size > 1000) {
			// kb
			return size / 1000.00 + " kb";
		} else {
			return size + " b";
		}
	}
	
}