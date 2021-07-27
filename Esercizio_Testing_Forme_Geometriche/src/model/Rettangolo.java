package model;

public class Rettangolo extends FiguraGeometrica{

	private int latoMinore;
	private int latoMaggiore;
	
	public Rettangolo() {
		
	}
	
	public Rettangolo(int latoMaggiore,int latoMinore) {
		this.latoMinore= latoMinore;
		this.latoMaggiore= latoMaggiore;
	}
	
	// Costruttore per la copia dell'oggetto
	public Rettangolo(Rettangolo r) {
		super();
		this.latoMinore= r.latoMinore;
		this.latoMaggiore= r.latoMaggiore;
	}
	
	public int getLatoMaggiore() {
		
		return latoMaggiore;
	}
	
	public int getLatoMinore() {
		
		return latoMinore;
	}
	
	public void setLatoMaggiore(int latoMaggiore) {
		this.latoMaggiore=latoMaggiore;
	}
	
	public void setLatoMinore(int latoMinore) {
		this.latoMinore= latoMinore;
	}

	@Override
	public String toString() {
		return String.valueOf(latoMinore) + "," + String.valueOf(latoMaggiore) ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + latoMaggiore;
		result = prime * result + latoMinore;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rettangolo other = (Rettangolo) obj;
		if (latoMaggiore != other.latoMaggiore)
			return false;
		if (latoMinore != other.latoMinore)
			return false;
		return true;
	}
	
	public double getPerimetro() {
		double perimetro;
		perimetro = 2*latoMaggiore + 2*latoMinore;
		return perimetro;
	}
	
	public double getArea() {
		double area;
		area= latoMaggiore*latoMinore;
		return area;
	}
	
}
