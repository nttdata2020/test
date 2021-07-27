package model;

public class Quadrato extends FiguraGeometrica{

	private double lato;
	
	public Quadrato() {
		
	}
	
	public Quadrato(double lato) {
		this.lato = lato;
	}
	
	// Costruttore per la copia dell'oggetto
	public Quadrato(Quadrato q) {
		super();
		this.lato = q.lato;
	}
	
	
	public double getLato() {
		return lato;
	}
	
	public void setLato(double lato) {
		this.lato = lato;
	}

	@Override
	public String toString() {
		return  String.valueOf(lato) ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(lato);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Quadrato other = (Quadrato) obj;
		if (Double.doubleToLongBits(lato) != Double.doubleToLongBits(other.lato))
			return false;
		return true;
	}
	
	public double getPerimetro() {
		double perimetro;
		perimetro = 4*lato;
		return perimetro;
	}
	
	public double getArea() {
		double area;
		area = lato*lato;
		return area;
	}
}
