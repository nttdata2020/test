package model;

public abstract class FiguraGeometrica {

	private String tipoFormaGeometrica;
	
	public FiguraGeometrica() {
		
	}
	
	public FiguraGeometrica(FiguraGeometrica fg) {
		this.tipoFormaGeometrica = fg.tipoFormaGeometrica;
	}

	public void FigureGeometriche(String tipoFormaGeometrica) {
		SetTipoFormaGeometrica(tipoFormaGeometrica);
	}
	
	public String getTipoFormaGeometrica() {
		
		return tipoFormaGeometrica;
	}
	
	public void SetTipoFormaGeometrica(String tipoFormaGeometrica) {
		this.tipoFormaGeometrica = tipoFormaGeometrica;
	}
	
	public abstract double getPerimetro();

	public abstract double getArea();

	@Override
	public String toString() {
		return "tipoFormaGeometrica=" + tipoFormaGeometrica ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoFormaGeometrica == null) ? 0 : tipoFormaGeometrica.hashCode());
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
		FiguraGeometrica other = (FiguraGeometrica) obj;
		if (tipoFormaGeometrica == null) {
			if (other.tipoFormaGeometrica != null)
				return false;
		} else if (!tipoFormaGeometrica.equals(other.tipoFormaGeometrica))
			return false;
		return true;
	}	
}
