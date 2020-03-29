
public class Tiskalnik extends Racunalnik {
	
	
	
	private String tiskalnik = "";
	private int stNatisnjeno;
	
	/**
	 * Deklariramo konstruktor
	 * Pred super ne sme biti ničesar navedenega!
	 * 
	 * @param vkl Vklop naprave
	 * @param vrs Vrsta naprave
	 * @param tsk Naziv tiskalnika
	 */
	public Tiskalnik( boolean vkl, String vrs, String tsk ){
		/**
		 * Pokličemo konstruktor nadrazreda
		 */
		super(vkl, vrs);
		
		tiskalnik    = tsk;  // nastavimo ostale zadeve, ki so bistvene za ta podrazred
		stNatisnjeno = 0; // privzeti �tevec natisnjenih strani - ponastavljen na 0!
	}
	
	

	/**
	 * Ne vrne ničesar, le nastavi nov tiskalnik na računalniku
	 * kadar nastavimo nov tisklanik, ponastavimo števec natisnjenih dokumentov
	 * 
	 * @param tsk Naziv tiskalnika
	 */
	public void setTiskalnik(String tsk){
		tiskalnik = tsk;
		stNatisnjeno = 0;
	}

	
	/**
	 * @return Vrne naziv tiskalnika 
	 */
	public String getTiskalnik(){
		return tiskalnik;
	}


	/**
	 * @param strani Število strani, ki jih želimo natisniti
	 * @return vrne število, koliko strani je natisnjenih na tem tiskalniku
	 */
	public int natisni( int strani){
		if (tiskalnik == ""){
			return 0;
		}else{
			stNatisnjeno += strani; // prištevek v pool natisnjenih strani
			return stNatisnjeno;
		}
	}
	
	
}