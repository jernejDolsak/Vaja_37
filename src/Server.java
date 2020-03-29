
public class Server extends Racunalnik {
	
	private float steviloVirtual;
	private int steviloProcesorjev;
	private int ramVelikost = 8; // gb rama na enoto / modul 
	private int ramModuli = 4;	// enot rama (modulov)
	private int steviloHdd = 4;
	private float porabaPerRam = 6; // wat porabe na modul 
	private float porabaPerHdd = 10; // wat porabe na modul 
	private float porabaMainboard = 60; // poraba mati�ne plo��e 
	private float porabaPerProcesor = 130; // poraba enega procesorja
	
	private float procesorPerVirtuala;
	
	/**
	 * konstruktor
	 * @param stvv število virtual
	 * @param stvp števio procesorjev
	 */
	public Server(int stvv, int stvp){
		// pred super ne dajamo ničesar!
		super(true, "WebServer X123");
		
		// sedaj določimo ostale lastnosti
		steviloVirtual 	= stvv;
		steviloProcesorjev = stvp;
		procesorPerVirtuala = getSteviloProcesorjevPerVirtuala() ;
	}
	
	
	/**
	 * @param stvv nastavi število virtual
	 */
	public void setSteviloVirtual(int stvv){
		steviloVirtual = stvv;
	}


	/**
	 * @param hd nastavi število hdd enot
	 */
	public void setSteviloHdd(int hd){
		steviloHdd = hd;
	}
	
	
	/**
	 * @param ram količina rama (nastavi ali v konzolo vrne string, če je računalnik vgasnjen)
	 */
	public void setSteviloRAM(int ram){
		if (jeVklopljen){
			System.out.println( "Sistem je zagnan, rama ne moreš menjati!");
		}else{
			ramModuli = ram;
		}
	}
	
	
	/**
	 * @return vrne količino procesorjev
	 */
	public int getSteviloProcesorjev(){
		return steviloProcesorjev;
	}
	
	
	/**
	 * @return vrne število virtual
	 */
	public float getSteviloVirtual(){
		return (int) steviloVirtual ;
	}
	
	/**
	 * @return vrne porabo energije v wattih, kjer se računa količina ram modulov * poraba po ramu, itd..
	 */
	public float getPoraba(){
		float poraba = ramModuli * porabaPerRam + steviloHdd * porabaPerHdd  + steviloProcesorjev * porabaPerProcesor + porabaMainboard;
		return poraba;
	}
	

	/**
	 * @return vrne število procesorjev po virtuali
	 */
	public float getSteviloProcesorjevPerVirtuala(){
		procesorPerVirtuala = steviloProcesorjev / steviloVirtual;
		return procesorPerVirtuala;
	}


	/**
	 * @return ramVelikost velikost ram enote / modula
	 */
	public int getRamModuli() {
		return ramModuli;
	}


	/**
	 * @return ramSize - vrne količino rama 
	 */
	public int getRamGB() {
		return ramModuli * ramVelikost;
	}
	
	/**
	 * @param r
	 * @return zamenja ram tudi če je računalnik zagnan
	 */
	public void setForceRamChange(int r) {
		ramModuli = r;
	}

	/**
	 * @param nastavi velikost ene ram ploščice
	 */
	public void setRamVelikost(int rv) {
		ramVelikost = rv;
	}
	
}