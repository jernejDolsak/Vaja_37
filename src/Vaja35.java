// uvozimo paket SwingConstants
import javax.swing.*;

// uvozimo javax.swing.* za delo z tabelami
import javax.swing.table.*;

import java.awt.Component;
// uvozimo paket za delo z dogodki
import java.awt.event.*;


// uvozimo paket za delo z pripomočki
import java.util.*;


// deklariramo javni razred Vaja35, ki implementira vmesnik ActionListener
public class Vaja35 implements ActionListener{
	
	// definiramo attribute, lastnosti
	private JFrame okno;
	private JPanel povrsina;
	private JButton gumb;
	private JTextField vnosnoPolje;
	private JLabel besedilo;
	private myTable mt;
	
    private JTextField ffStVir;
    private JTextField ffstJeder;
    private JTextField ffRamModul;
    private JTextField ffRamPerModul;
	// private JComboBox comboBox;
	
	
	// statična metoda, ki se zažene ob začetku
	public static void main(String[] args){

		Vaja35 v = new Vaja35( "Naslov novega okna" );			
		
	}
	
	// konstruktor
	public Vaja35( String naslov){
		
		okno = new JFrame(naslov);                      // iniializiramo okno 
		
		povrsina = new JPanel();                        // ustvarimo provšino
		
		besedilo    = new JLabel("Hello Swing World");  // ustavimo okence z besedilom;

		vnosnoPolje = new JTextField(32);               // ustvarimo vnosno polje 
		
		// za lažje sledenje tu definiram osnovne atribute za izris polja
		int zamik = 10;        // presledek med polji
		int zamikNazivX = 10;  // x nivo, od leve strani okna do desne (label, naziv polja)
		int zamikPoljaY = 1;   // y nivo, od vrha okna pa dol
		int zamikPoljaX = 190; // x nivo, od leve strani okna do desne
		
		// polje
		ffstJeder = new JTextField();
		ffstJeder.setBounds(zamikPoljaX, zamikPoljaY, 86, 20);
        ffstJeder.setColumns(10);
        // label
        JLabel labelStJeder = new JLabel("Število procesorjev");
        labelStJeder.setBounds(zamikNazivX, zamikPoljaY, zamikPoljaX - 20, 14);
        labelStJeder.setHorizontalAlignment(SwingConstants.RIGHT);
        okno.getContentPane().add(labelStJeder);
        okno.getContentPane().add( ffstJeder );
        
        // dodaj presledek
        zamikPoljaY +=25;
        
		// polje
        ffStVir = new JTextField();
        ffStVir.setBounds(zamikPoljaX, zamikPoljaY, 86, 20);
        ffStVir.setColumns(10);
        // label
        JLabel labelProc = new JLabel("Število virtual");
        labelProc.setBounds(zamikNazivX, zamikPoljaY, zamikPoljaX - 20, 14);
        labelProc.setHorizontalAlignment(SwingConstants.RIGHT);
        okno.getContentPane().add(labelProc);
        okno.getContentPane().add( ffStVir );        
        
        
        // dodaj presledek
        zamikPoljaY +=25;
        
		// polje
        ffRamModul = new JTextField();
        ffRamModul.setBounds(zamikPoljaX, zamikPoljaY, 86, 20);
        ffRamModul.setColumns(10);
        // label
        JLabel labelRPM = new JLabel("Vnesi vel. 1. ram modula");
        labelRPM.setBounds(zamikNazivX, zamikPoljaY, zamikPoljaX - 20, 14);
        labelRPM.setHorizontalAlignment(SwingConstants.RIGHT);
        okno.getContentPane().add(labelRPM);
        okno.getContentPane().add( ffRamModul );                
        
        // dodaj presledek
        zamikPoljaY +=25;
        
        // polje
        ffRamPerModul = new JTextField();
        ffRamPerModul.setBounds(zamikPoljaX, zamikPoljaY, 86, 20);
        ffRamPerModul.setColumns(10);
        // label
        JLabel labelRAM = new JLabel("Količina RAM modulov");
        labelRAM.setBounds(zamikNazivX, zamikPoljaY, zamikPoljaX - 20, 14);
        labelRAM.setHorizontalAlignment(SwingConstants.RIGHT);
        okno.getContentPane().add(labelRAM);
        okno.getContentPane().add( ffRamPerModul );                
        
        
        zamikPoljaY +=25;
        
        // pripravi in izriši gumb
		gumb  = new JButton("Dodaj");	
		gumb.setBounds( zamikPoljaX, zamikPoljaY, 90, 20);
		okno.getContentPane().add(gumb);
		
		gumb.addActionListener(this);                   // gumbu določimo poslušalca dogodkov

		// tabela
		mt = new myTable();
		JTable table = new JTable( mt);
		// ScrollPane - zato da je tabela scrollable in prikazuje glavo tabele
	    JScrollPane scrlTbl = new JScrollPane( table );
	    scrlTbl.setBounds(190, 130, 600, 200);
		
		
		okno.getContentPane().add( scrlTbl );
		okno.add(povrsina);
   
		okno.setVisible(true);                          // pokličemo metodo, ki prikaže okno
		                                                // cmd: program ustavimo z CTRL-C 
		                                                // cmd: parametri izvajanja CTRL-BREAK		
		okno.setSize(800, 600);                         // nastavi velikost okna
		//okno.setLocationRelativeTo(null); 				// okno se naj odpre na sredini zaslona
		
		// nastavimo delovanje tako, da se ob zapiraju okna zstavi tudi izvajanje aplikacije
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
	
	
	
	/**
	 * čaka na akcijo potrditve forme (klik na gummb) in jo izvede
	 * 
	 */
	public void actionPerformed(ActionEvent e){
		String stVir  = ffStVir.getText();
		String stJeder = ffstJeder.getText();
		String stRam = ffRamModul.getText();
		String stRamPerModul = ffRamPerModul.getText();
		
		// spremenimo str v int
		int istVir = Integer.parseInt(stVir);
		int istJeder = Integer.parseInt(stJeder);
		int istRam = Integer.parseInt(stRam);
		int istRamPerModul = Integer.parseInt(stRamPerModul);
		

		
		Server 	srv = new Server(istVir,istJeder);
				srv.setForceRamChange(istRam);
				srv.setRamVelikost(istRamPerModul);
		
		mt.addServer( srv );
		
		// vrednosti posastavi na prazen string 
		ffStVir.setText("");
		ffstJeder.setText("");
	}
	
	
	
}