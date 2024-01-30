package progetto.mp.monicolini.matteo.puntocaldo;

import java.util.Objects;

public class IngredienteBase extends Ingrediente {
	
	private double costoBase;
	
	public IngredienteBase(String nome, double costoBase) {
		super(nome);
		this.costoBase = costoBase;
	}

	@Override
	public double calcolaCostoIntrinseco() {
		return costoBase;
	}
	
	@Override
	public void cambiaCostoPerNome(String nome, double incrementoPercentuale) {
		if(this.getNome().contains(nome)) {
			setCostoBase(calcolaCostoIntrinseco()*(1+(incrementoPercentuale/100)));
		}
	}

	public void setCostoBase(double costoBase) {
		this.costoBase = costoBase;
	}
	
	public double getCostoBase() {
		return costoBase;
	}
	
	@Override
	public void accept(IngredienteVisitor visitor) {
		visitor.visitIngredienteBase(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(costoBase);
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
		IngredienteBase other = (IngredienteBase) obj;
		return Double.doubleToLongBits(costoBase) == Double.doubleToLongBits(other.costoBase);
	}
}
