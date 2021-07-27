package model;

public class Triangolo extends FiguraGeometrica {

	private int latoA;
	private int latoB;
	private int latoC;
	
	public Triangolo() {
		
	}
	
	public Triangolo(int latoA,int latoB, int latoC) {
		super();
		this.latoA = latoA;
		this.latoB = latoB;
		this.latoC = latoC;
	}
	
	// Costruttore per la copia dell'oggetto
	public Triangolo(Triangolo t) {
		super();
		this.latoA = t.latoA;
		this.latoB = t.latoB;
		this.latoC = t.latoC;
	}
	
	public int getLatoA() {
		return latoA;
	}
	
	public int getLatoB() {
		return latoB;
	}
	
	public int getLatoC() {
		return latoC;
	}
	
	public void setLatoA(int latoA) {
		this.latoA= latoA;
	}
	
	public void setLatoB(int latoB) {
		this.latoB=latoB;
	}
	
	public void setLatoC(int latoC) {
		this.latoC = latoC;
	}

	@Override
	public String toString() {
		return String.valueOf(latoA) + "," + String.valueOf(latoB) + "," + String.valueOf(latoC);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + latoA;
		result = prime * result + latoB;
		result = prime * result + latoC;
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
		Triangolo other = (Triangolo) obj;
		if (latoA != other.latoA)
			return false;
		if (latoB != other.latoB)
			return false;
		if (latoC != other.latoC)
			return false;
		return true;
	}
	
	public double getPerimetro() {
		
		return latoA+latoB+latoC;
	}
	
	public double getArea() {
		double semiperimetro;
		double area;
		
		semiperimetro= (latoA+latoB+latoC);
		semiperimetro = semiperimetro/2;
		area = Math.sqrt(semiperimetro*(semiperimetro - latoA)*(semiperimetro - latoB)*(semiperimetro - latoC));
		
		return area;
	}
		
}
