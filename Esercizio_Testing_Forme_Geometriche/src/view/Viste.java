package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Cerchio;
import model.FiguraGeometrica;
import model.Quadrato;
import model.Rettangolo;
import model.Triangolo;

public class Viste implements IViste{

	public int leggiIntero(String messaggio) {
		Scanner input = new Scanner(System.in);
		int valore = 0;
		boolean flag;
		do {
			flag= false;
			System.out.print(messaggio);
			try {
				valore = Integer.parseInt(input.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Errore! Inserire un numero intero.");
				flag = true;
			}
		}while(flag);
		return valore;
	}

	public double leggiDouble(String messaggio) {
		Scanner input = new Scanner(System.in);
		double valore = 0;
		boolean flag;
		do {
			flag= false;

			System.out.print(messaggio);
			try {
				valore = Double.parseDouble(input.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Errore! Inserire un numero decimale.");
				flag = true;
			}
		}while(flag);
			return valore;
	}

	public String leggiStringa(String messaggio) {
		Scanner input=new Scanner(System.in);
		System.out.print(messaggio);
		return input.nextLine();
	}
	
	public int menuFormeGeometriche() {
		int scelta=0;
		boolean flag=true;
		Scanner input=new Scanner(System.in);
		System.out.println();
		System.out.println("--- Menù principale Figure Geometriche ---");
		System.out.println();
		System.out.println("1) Cerchio");	
		System.out.println("2) Quadrato");
		System.out.println("3) Rettangolo");
		System.out.println("4) Triangolo");
		System.out.println("5) Menù precedente");
		System.out.println();
		
		do {
			System.out.print("Digitare la scelta: ");
			
			try {
				scelta=Integer.parseInt(input.nextLine());
				if(scelta ==0 || scelta >5) {
					System.out.println("Scelta non valida! ");
				}else flag=false;
			}catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("Scelta non valida!");
					flag=true;	
			}
			
		}while(flag);
		return scelta;
	}
	public int menuPrincipale() {
		int scelta=0;
		boolean flag=true;
		Scanner input=new Scanner(System.in);
		System.out.println();
		System.out.println("--- Menù principale Figure Geometriche ---");
		System.out.println();
		System.out.println("1) Inserimento");	
		System.out.println("2) Modifica");
		System.out.println("3) Elimina");
		System.out.println("4) Visualizza");
		System.out.println("5) Esci dal programma");
		System.out.println();
		
		do {
			System.out.print("Digitare la scelta: ");
			
			try {
				scelta=Integer.parseInt(input.nextLine());
				if(scelta ==0 || scelta >5) {
					System.out.println("Scelta non valida! ");
				}else flag=false;
			}catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("Scelta non valida!");
					flag=true;	
			}
			
		}while(flag);
		return scelta;
	}
	
	//Stampa a video le informazioni sulla figura geometrica
	public void stampaInformazioni(FiguraGeometrica figura) {
		
		messaggio("--- Informazioni sulla figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + figura.getTipoFormaGeometrica() );
		
		switch (figura.getTipoFormaGeometrica() ) {
			case "Cerchio": {
					Cerchio cerchio = (Cerchio)figura;
					messaggio("Raggio: " + cerchio.getRaggio());
					break;
				}
			case "Quadrato": {
				Quadrato quadrato = (Quadrato)figura;
				messaggio("Lato: " + quadrato.getLato());
				break;
			}			
			case "Rettangolo": {
				Rettangolo rettangolo = (Rettangolo)figura;
				messaggio("LatoMinore: " + rettangolo.getLatoMinore() + ", Lato maggiore: " + rettangolo.getLatoMaggiore());
				break;
			}
			case "Triangolo": {
				Triangolo triangolo = (Triangolo)figura;
				messaggio("LatoA: " + triangolo.getLatoA() + ", LatoB: " + triangolo.getLatoB()+ ", LatoC: " + triangolo.getLatoC());
				break;
			}
		}
		messaggio("Perimetro: " + figura.getPerimetro());
		messaggio("Area: " + figura.getArea());
		messaggio("------------------- Fine --------------------");
	}
	
	// Stampa a video l'elenco delle figure geometriche contenute nel arraylist figure
	public boolean stampaFigureGeometriche(ArrayList<FiguraGeometrica> figure) {
		
		System.out.println();
		System.out.println("--- Elenco delle figure geometriche in archivio ---");
		
		if (figure.size()>0) {		
			for (int i = 0; i < figure.size(); i++) {
				System.out.println();
				System.out.println("Figura: "+(i+1));
				stampaInformazioni(figure.get(i));			
			}
			System.out.println();
			return true;
		}else {
		
			System.out.println("Nessun Dipendente in archivio");
			System.out.println();
			return false;
		}
		
	}
	
	// Inserimento della figura geometrica selezionata
	public void inserimentoFiguraGeometrica(FiguraGeometrica fg) {
		
		if(fg!=null) {
			if(fg instanceof Cerchio) {

				inserimentoDatiCerchio((Cerchio)fg);

			}else if(fg instanceof Quadrato) {
				
				inserimentoDatiQuadrato((Quadrato)fg);

			}else if(fg instanceof Rettangolo) {
				
				inserimentoDatiRettangolo((Rettangolo)fg);
				
			}else if(fg instanceof Triangolo){

				inserimentoDatiTriangolo((Triangolo)fg);
				
			}else {
				messaggio("Errore: figura geometrica non valida!");
			}
		}else {
			messaggio("Errore: la figura non è instanziata!");
		}
	}
	
	private void inserimentoDatiCerchio(Cerchio cerchio) {
		double raggio;
		boolean flag;
		
		cerchio.FigureGeometriche("Cerchio");
		
		messaggio("--- Inserimento dati figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + cerchio.getTipoFormaGeometrica() );	

		do {
			flag=true;
			
			raggio = leggiDouble("Raggio:");
			
			if (raggio>0) {
				flag=false;
			}else {
				messaggio("Inserire un valore maggiore di zero!");
			}
			
		}while(flag);
		
		cerchio.setRaggio(raggio);
	}
	private void inserimentoDatiQuadrato(Quadrato quadrato) {
		double lato;
		boolean flag;
		
		quadrato.FigureGeometriche("Quadrato");
		
		messaggio("--- Inserimento dati figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + quadrato.getTipoFormaGeometrica() );	

		do {
			flag=true;
			
			lato = leggiDouble("Lato:");
			
			if (lato>0) {
				flag=false;
			}else {
				messaggio("Inserire un valore maggiore di zero!");
			}
		
		}while (flag);	
		
		quadrato.setLato(lato);	
	}
	private void inserimentoDatiRettangolo(Rettangolo rettangolo) {
		int latoMaggiore;	
		int latoMinore;
		boolean flag;
		
		rettangolo.FigureGeometriche("Rettangolo");
		
		messaggio("--- Inserimento dati figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + rettangolo.getTipoFormaGeometrica() );	

		do {
			
			do {
				flag=true;
				
				latoMinore = leggiIntero("Lato minore:");
				
				if (latoMinore>0) {
					flag=false;
				}else {
					messaggio("Inserire un valore maggiore di zero!");
				}
			
			}while (flag);	
			
			do {
				flag=true;
				
				latoMaggiore = leggiIntero("Lato maggiore:");
				
				if (latoMaggiore>0) {
					flag=false;
				}else {
					messaggio("Inserire un valore maggiore di zero!");
				}			
				
			}while (flag);
		
			flag = true;
	
			if(latoMaggiore==latoMinore) {
				messaggio("Attenzione il lato maggiore non può essere uguale lato minore");
			}else {
				if (latoMaggiore>latoMinore) {
					flag=false;
				}else {
					messaggio("Attenzione il lato maggiore non può essere inferiore del lato minore");
				}
			}
			
		}while(flag);
		
		rettangolo.setLatoMinore(latoMinore);	
		rettangolo.setLatoMaggiore(latoMaggiore);
	}
	private void inserimentoDatiTriangolo(Triangolo triangolo) {
		int latoA;	
		int latoB;
		int latoC;		
		boolean flag;
		
		triangolo.FigureGeometriche("Triangolo");
		messaggio("--- Inserimento dati figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + triangolo.getTipoFormaGeometrica() );				
		
		do {
			flag=true;
			
			latoA = leggiIntero("Lato A:");
			
			if (latoA>0) {
				flag=false;
			}else {
				messaggio("Inserire un valore maggiore di zero!");
			}
		
		}while (flag);	
		
		do {
			flag=true;
			
			latoB = leggiIntero("Lato B:");
			
			if (latoB>0) {
				flag=false;
			}else {
				messaggio("Inserire un valore maggiore di zero!");
			}			
			
		}while (flag);
		
		do {
			flag=true;
		
			latoC = leggiIntero("Lato C:");
			
			if (latoC>0) {
				flag=false;
			}else {
				messaggio("Inserire un valore maggiore di zero!");
			}	
			
		}while (flag);
		
		triangolo.setLatoA(latoA);
		triangolo.setLatoB(latoB);
		triangolo.setLatoC(latoC);		
	}
	
	// Modifica della figura geometrica selezionata
	public void modificaFiguraGeometrica(FiguraGeometrica fg) {
		
		if(fg!=null) {
			if(fg instanceof Cerchio) {
				modificaDatiCerchio((Cerchio)fg);
			}else if(fg instanceof Quadrato) {
				modificaDatiQuadrato((Quadrato)fg);
				
			}else if(fg instanceof Rettangolo) {
				modificaDatiRettangolo((Rettangolo)fg);
			}else if(fg instanceof Triangolo){
				modificaDatiTriangolo((Triangolo)fg);
			}else {
				messaggio("Errore: figura geometrica non valida!");
			}
		}else {
			messaggio("Errore: la figura non è instanziata!");
		}
	}	
	
	// Modifica dei dati del cerchio
	private void modificaDatiCerchio(Cerchio cerchio) {
		boolean flag;
		String valoreStr="";
		double raggio;
		
		messaggio("");
		messaggio("--- Modifica figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + cerchio.getTipoFormaGeometrica() );	
		
		do {
			flag=false;
			raggio =cerchio.getRaggio();
			valoreStr=leggiStringa("Raggio["+raggio+"]:");
			
			try {
				if(!valoreStr.equals("")) {
					raggio = Double.parseDouble(valoreStr);
					if (raggio>0) {
						cerchio.setRaggio(raggio);
					}else {
						messaggio("Inserire un valore maggiore di zero!");
						flag= true;
					}
				}
			} catch (NumberFormatException e) {
				messaggio("Errore! Inserire un numero decimale.");
				flag= true;
			}
		} while (flag);
	}
	
	// Modifica dei dati del quadrato
	private void modificaDatiQuadrato(Quadrato quadrato) {
		double lato;
		String valoreStr;
		boolean flag;
		
		quadrato.FigureGeometriche("Quadrato");
		
		messaggio("--- Inserimento dati figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + quadrato.getTipoFormaGeometrica() );	

		do {
			flag=false;
			lato =quadrato.getLato();
			valoreStr = leggiStringa("Lato["+lato+"]:");
			try {
				if (!valoreStr.equals("")) {
					lato = Double.parseDouble(valoreStr);
					if (lato>0) {
						quadrato.setLato(lato);	
					}else {
						messaggio("Inserire un valore maggiore di zero!");
						flag = true;
					}
				}
			} catch (NumberFormatException e) {
				messaggio("Errore! Inserire un numero decimale.");
				flag = true;
			}
		}while (flag);	
		
		
	}
	
	// Modifica dei dati del rettangolo
	private void modificaDatiRettangolo(Rettangolo rettangolo) {
		String valoreStr;
		int latoMaggiore=0;	
		int latoMinore=0;
		boolean flag;
		
		rettangolo.FigureGeometriche("Rettangolo");
		
		messaggio("--- Inserimento dati figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + rettangolo.getTipoFormaGeometrica() );	

		do {
			
			do {
				flag=true;
				
				valoreStr = leggiStringa("Lato minore["+rettangolo.getLatoMinore()+"]:");
				
				try {
					if (!valoreStr.equals("")) {
						latoMinore= Integer.parseInt(valoreStr);
						if (latoMinore>0) {
							flag=false;
						}else {
							messaggio("Inserire un valore maggiore di zero!");
						}
					}else {
						latoMinore=rettangolo.getLatoMinore();
						flag = false;
					}
				} catch (NumberFormatException e) {
					messaggio("Errore! Inserire un numero intero.");
				}			
			}while (flag);	
			
			do {
				flag=true;
				
				valoreStr = leggiStringa("Lato maggiore["+rettangolo.getLatoMaggiore()+"]");
				
				try {
					if(!valoreStr.equals("")) {
						latoMaggiore= Integer.parseInt(valoreStr);
						if (latoMaggiore>0) {
							flag=false;
						}else {
							messaggio("Inserire un valore maggiore di zero!");
						}		
					}else {
						latoMaggiore=rettangolo.getLatoMaggiore();
						flag = false;
					}
				} catch (Exception e) {
					messaggio("Errore! Inserire un numero intero.");
				}
							
			}while (flag);
		
			flag = true;
	
			if(latoMaggiore==latoMinore) {
				messaggio("Attenzione il lato maggiore non può essere uguale lato minore");
			}else {
				if (latoMaggiore>latoMinore) {
					flag=false;
				}else {
					messaggio("Attenzione il lato maggiore non può essere inferiore del lato minore");
				}
			}
			
		}while(flag);
		
		rettangolo.setLatoMinore(latoMinore);	
		rettangolo.setLatoMaggiore(latoMaggiore);
		
	}
	
	// Modifica dei dati del triangolo
	private void modificaDatiTriangolo(Triangolo triangolo) {
		String valoreStr;
		int latoA=0;	
		int latoB=0;
		int latoC=0;		
		boolean flag;
		
		triangolo.FigureGeometriche("Triangolo");
		messaggio("--- Inserimento dati figura geometrica ---");
		messaggio("");
		messaggio("Tipo forma geometrica: " + triangolo.getTipoFormaGeometrica() );				
		
		do {
			flag=true;
			
			valoreStr = leggiStringa("Lato A["+triangolo.getLatoA()+"]:");
			try {
				if (!valoreStr.equals("")) {
					latoA = Integer.parseInt(valoreStr);
					if (latoA>0) {
						flag=false;
					}else {
						messaggio("Inserire un valore maggiore di zero!");
					}
				}else {
					latoA = triangolo.getLatoA();
					flag = false;
				}
				
			} catch (Exception e) {
				messaggio("Errore! Inserire un numero intero.");
			}		
		}while (flag);	
		
		do {
			flag=true;
			
			valoreStr = leggiStringa("Lato B["+triangolo.getLatoB()+"]:");
			try {
				if (!valoreStr.equals("")) {
					latoB = Integer.parseInt(valoreStr);
					if (latoB>0) {
						flag=false;
					}else {
						messaggio("Inserire un valore maggiore di zero!");
					}
				}else {
					latoB = triangolo.getLatoB();
					flag = false;
				}
				
			} catch (Exception e) {
				messaggio("Errore! Inserire un numero intero.");
			}		
		}while (flag);
		
		do {
			flag=true;
			
			valoreStr = leggiStringa("Lato C["+triangolo.getLatoC()+"]:");
			try {
				if (!valoreStr.equals("")) {
					latoC = Integer.parseInt(valoreStr);
					if (latoC>0) {
						flag=false;
					}else {
						messaggio("Inserire un valore maggiore di zero!");
					}
				}else {
					latoC = triangolo.getLatoC();
					flag = false;
				}
				
			} catch (Exception e) {
				messaggio("Errore! Inserire un numero intero.");
			}		
		}while (flag);
		
		triangolo.setLatoA(latoA);
		triangolo.setLatoB(latoB);
		triangolo.setLatoC(latoC);		
	}
	
	public void messaggio(String messaggio) {
		System.out.println(messaggio);
	}
}
