package model;

import java.util.ArrayList;

public interface ICRUDFiguraGeometrica {
		//public  ArrayList<FiguraGeometrica> FigureGeometriche = new ArrayList<FiguraGeometrica>();

		// Inserimento di una figura geometrica 
		public boolean inserimento (FiguraGeometrica f);

		// Modifica di una figura geometrica
		public boolean modifica(int id, FiguraGeometrica f);
			
		// Cancella una figura geometricca dall'arraylist FigureGeometriche
		public void cancella(int id);	
		
		// Ricerco il dipendente mediante l'Id passato come argomento
		public FiguraGeometrica leggi(int id);
		
		// Restituisco il riferimento all'oggetto Dipendenti	
		public ArrayList<FiguraGeometrica> leggi();
		
}
