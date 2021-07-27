package model;

public class Cerchio extends FiguraGeometrica{

	private double raggio;
	
	public Cerchio() {
		
	}
	
	public Cerchio(double raggio) {
		this.raggio= raggio;
	}
	
	// Costruttore per la copia dell'oggetto
	public Cerchio(Cerchio c)  {
		super(c);
		this.raggio = c.getRaggio();
	}
	
	public double getRaggio() {
		
		return raggio;
	}
	
	public void setRaggio(double raggio) {
		
		this.raggio = raggio;
	}

	@Override
	public String toString() {
		return  String.valueOf(raggio) ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(raggio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerchio other = (Cerchio) obj;
		if (Double.doubleToLongBits(raggio) != Double.doubleToLongBits(other.raggio))
			return false;
		return true;
	}
	
	public double getPerimetro() {
		double perimetro;
		perimetro = 2* raggio * Math.PI;
				
		return perimetro;
			
	}
	public double getArea() {
		
		double area;
		area = raggio*raggio*Math.PI;
		
		return area;
	}
}
