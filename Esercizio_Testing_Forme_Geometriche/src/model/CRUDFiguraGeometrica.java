package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CRUDFiguraGeometrica implements ICRUDFiguraGeometrica {

	private  ArrayList<FiguraGeometrica> FigureGeometriche = new ArrayList<FiguraGeometrica>();
	
	public CRUDFiguraGeometrica() {

	}
	
	public boolean carica() {
		Cerchio cerchio;
		Quadrato quadrato;
		Rettangolo rettangolo;
		Triangolo triangolo;
		String linea="";
		
		// Creare la cartella c:\dati
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\stuanis\\Downloads\\Esercizio Testing Forme_Geometriche\\Esercizio_Testing_Forme_Geometriche\\dati\\figuregeometriche.dat"))) {

			while(linea != null) {
				
				String [] attributi = linea.split(",");
				
				switch (attributi[0] ) {
					case "Cerchio": {
						cerchio = new Cerchio();
						cerchio.SetTipoFormaGeometrica(attributi[0]);
						cerchio.setRaggio(Double.parseDouble(attributi[1]));
						FigureGeometriche.add(cerchio);	
						break;
					}
					case "Quadrato": {
						quadrato = new Quadrato();
						quadrato.SetTipoFormaGeometrica(attributi[0]);
						quadrato.setLato(Double.parseDouble(attributi[1]));
						FigureGeometriche.add(quadrato);
						break;
					}
					case "Rettangolo": {
						rettangolo = new Rettangolo();
						rettangolo.SetTipoFormaGeometrica(attributi[0]);
						rettangolo.setLatoMinore(Integer.parseInt(attributi[1]));
						rettangolo.setLatoMaggiore(Integer.parseInt(attributi[2]));
						FigureGeometriche.add(rettangolo);
						break;
					}
					case "Triangolo": {
						triangolo = new Triangolo();
						triangolo.SetTipoFormaGeometrica(attributi[0]);
						triangolo.setLatoA(Integer.parseInt(attributi[1]));
						triangolo.setLatoB(Integer.parseInt(attributi[2]));
						triangolo.setLatoC(Integer.parseInt(attributi[3]));
						FigureGeometriche.add(triangolo);
						break;
					}
				} 
				linea = bufferedReader.readLine();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean salva() {
		// Creare la cartella c:\dati
		try(FileWriter fileWriter = new FileWriter("C:\\Users\\stuanis\\Downloads\\Esercizio Testing Forme_Geometriche\\Esercizio_Testing_Forme_Geometriche\\dati\\figuregeometriche.dat")) {
		
			for(int i = 0; i < FigureGeometriche.size(); i++) {
				fileWriter.write(FigureGeometriche.get(i).getTipoFormaGeometrica() + "," + FigureGeometriche.get(i).toString()+"\n");
			}
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean inserimento(FiguraGeometrica f) {
		// TODO Auto-generated method stub
		
		FigureGeometriche.add(f);
		return true;
	}

	@Override
	public boolean modifica(int id, FiguraGeometrica f) {
		// TODO Auto-generated method stub
		id=id-1;
		
		if (id<FigureGeometriche.size()) {
			FigureGeometriche.set(id,f);
			return true;
		}		
		return false;
	}

	@Override
	public void cancella(int id) {
		// TODO Auto-generated method stub
		id=id-1;
		
		FigureGeometriche.remove(id);
	}

	@Override
	public FiguraGeometrica leggi(int id) {
		// TODO Auto-generated method stub
		id=id-1;
		
		if (id<FigureGeometriche.size()) {
			return FigureGeometriche.get(id);
		}		
		return null;
	}
	
	@Override
	public ArrayList<FiguraGeometrica> leggi() {
		// TODO Auto-generated method stub
		return FigureGeometriche;
	}
	public FiguraGeometrica copia(FiguraGeometrica oriFg) {
		if(oriFg!=null) {
			if(oriFg instanceof Cerchio) {
				Cerchio cerchioCopia = new Cerchio((Cerchio)oriFg);
				return cerchioCopia;
			}else if(oriFg instanceof Quadrato) {
				Quadrato quadratoCopia = new Quadrato((Quadrato)oriFg);
				return quadratoCopia;
			}else if(oriFg instanceof Rettangolo) {
				Rettangolo rettangoloCopia = new Rettangolo((Rettangolo)oriFg);
				return rettangoloCopia;
			}else if(oriFg instanceof Triangolo){
				Triangolo triangoloCopia = new Triangolo((Triangolo)oriFg);
				return triangoloCopia;
			}else {
				return null;
			}
		}else {
			return null;
		}	
	}

}
