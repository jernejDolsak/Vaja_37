import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
//public class pivskaSteklenicaTable extends AbstractTableModel {
public class myTable extends DefaultTableModel {
   private String[] columnNames = {"st. jeder", "ram", "st. virtual", "poraba v wattih"};
   
   private ArrayList<Server> serverji;
   
   // konstruktor
   public myTable(){
		serverji  = new ArrayList<Server>();
		super.addColumn("Št. procesorjev");
		super.addColumn("št. virtual");
		super.addColumn("Proc per vir");
		super.addColumn("RAM (Gb)");
		super.addColumn("Sistem");
		super.addColumn("Poraba (W)");
   }
   
   

	   // dodamo metodo za dodajanje steklenic 
	   public void addServer(Server s) {
		   // doda server na seznam
		   serverji.add( s );
		   
		   Object[] vrstica = new Object[]{ s.getSteviloProcesorjev(),
				   							s.getSteviloVirtual(),
				   							s.getSteviloProcesorjevPerVirtuala(),
				   							s.getRamGB() + "Gb", 
				   							s.getVrsta(), 
				   							s.getPoraba() + "W" };
		   /*
		    * Ne rabim več 
		    
		   for (int c=0; c < vrstica.length; c++) {
			   // tole je noro uporabna zadeva !!!!!
			   System.out.println(c+ ". Stolpec: " + vrstica[c] + " tip: " + vrstica[c].getClass() );
		   
		   }
		   
		   */
		   
	       // doda vrednosti v tabelo
		   addRow(vrstica );
		   
	   }

}
