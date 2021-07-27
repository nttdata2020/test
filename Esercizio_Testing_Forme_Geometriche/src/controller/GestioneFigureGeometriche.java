package controller;


import model.CRUDFiguraGeometrica;
import model.Cerchio;
import model.FiguraGeometrica;
import model.Quadrato;
import model.Rettangolo;
import model.Triangolo;
import view.Viste;

public class GestioneFigureGeometriche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cerchio cerchio;
		Quadrato quadrato;
		Rettangolo rettangolo;
		Triangolo triangolo;
		Viste vista = new Viste();
		CRUDFiguraGeometrica crud = new CRUDFiguraGeometrica();
		
		int id;
		int scelta;
		boolean flagMenu;
		
		if(!crud.carica()) {
			vista.messaggio("Errore di caricameto!");
			vista.leggiStringa("Premere invio per caricare il menù principale");	
		}
		
		do {
			flagMenu=true;
			
			scelta = vista.menuPrincipale();
			
			switch (scelta) {
			
			case 1:
				// Inserimento forme geomentriche
				do {
					scelta = vista.menuFormeGeometriche();
					switch (scelta) {
						case 1:		
							
							// Cerchio
							cerchio = new Cerchio();
							vista.inserimentoFiguraGeometrica(cerchio);
							if(crud.inserimento(cerchio)) {
								vista.messaggio("Inserimento eseguito con successo!");
								vista.stampaInformazioni(cerchio);
							}else{
								vista.messaggio("Inserimento in errore!");
							};
							
							vista.leggiStringa("Premere invio per tornare al menù principale");					
							break;
								
						case 2:
							// Quadrato
							quadrato = new Quadrato();
							vista.inserimentoFiguraGeometrica(quadrato);
							if(crud.inserimento(quadrato)) {
								vista.messaggio("Inserimento eseguito con successo!");
								vista.stampaInformazioni(quadrato);
							}else{
								vista.messaggio("Inserimento in errore!");
							};
							vista.leggiStringa("Premere invio per tornare al menù principale");
							break;
							
						case 3:
							// Rettangolo
							rettangolo = new Rettangolo();
							vista.inserimentoFiguraGeometrica(rettangolo);
							if(crud.inserimento(rettangolo)) {
								vista.messaggio("Inserimento eseguito con successo!");
								vista.stampaInformazioni(rettangolo);
							}else{
								vista.messaggio("Inserimento in errore!");
							};
							vista.leggiStringa("Premere invio per tornare al menù principale");
							break;
						
						case 4:
							// Triangolo	
							triangolo = new Triangolo();
							vista.inserimentoFiguraGeometrica(triangolo);
							if(crud.inserimento(triangolo)) {
								vista.messaggio("Inserimento eseguito con successo!");
								vista.stampaInformazioni(triangolo);
							}else{
								vista.messaggio("Inserimento in errore!");
							};
							vista.leggiStringa("Premere invio per tornare al menù principale");
							break;
												
						case 5: 
							// Menu precedente
							flagMenu = false;
							break;
					}
				}while(flagMenu);
				flagMenu = true;
				break;
			case 2:
				// Modifica figura geometrica
				id=0;
				
				// Se ci sono figure geometriche nell'arrayList, chiedo quale modificare
				if (vista.stampaFigureGeometriche(crud.leggi())) {
					id =vista.leggiIntero("Digita l'Id della figura geometrica da modificare: ");
					
					FiguraGeometrica objFg = crud.leggi(id);
					
					if (objFg !=null) {
						FiguraGeometrica copiaFg = crud.copia(objFg);

						vista.modificaFiguraGeometrica(copiaFg);
					
						if(vista.leggiStringa("Modificare la figura (s/n)?").toLowerCase().equals("s")) {
							if (crud.modifica(id, copiaFg)) {
								vista.messaggio("Modifica eseguita con successo!");
							}else {
								vista.messaggio("ATTENZIONE: Errore durante la modifica!");
							}
						}else {
							vista.messaggio("Operazione annullata!");						
						}
					}else {
						vista.messaggio("Errore: L'id non è stato trovato");
					}
				}

				vista.leggiStringa("Premere un tasto per tornare al menù prncipale!");
				break;
			case 3:
				// Cancellazione figura geometrica
				// Se ci sono figure geometriche nell'arrayList, chiedo quale modificare
				if (vista.stampaFigureGeometriche(crud.leggi())) {
					id =vista.leggiIntero("Digita l'Id della figura geometrica da eliminare: ");

					
					if(crud.leggi(id)!=null) { 
						vista.stampaInformazioni(crud.leggi(id));
												
						if(vista.leggiStringa("Sicuro di voler e la figura geometrica (s/n)?: ").toLowerCase().equals("s")) {
							
							crud.cancella(id);
							
							vista.messaggio("Figura geometrica cancellata con successo!");
							vista.stampaFigureGeometriche(crud.leggi());	
						}else {
							vista.messaggio("Cancellazione annullata!");
						}
					}else {
						vista.messaggio("Figura geometrica non presente in archivio!");	
					}
				}
				vista.leggiStringa("Premere un tasto per tornare al menù prncipale!");					
				break;
			case 4:
				// Visualizzazione figure geometriche
				vista.stampaFigureGeometriche(crud.leggi());
				vista.leggiStringa("Premere un tasto per tornare al menù principale");
				break;
			case 5:
				// Uscita dal progamma
				if(!crud.salva()){
					vista.messaggio("Errore nel salvataggio dei dati!");
				}
				flagMenu = false;
				break;
			}
		} while (flagMenu);
	}
}