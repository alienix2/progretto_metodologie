package progetto.mp.monicolini.matteo.puntocaldo;

import java.util.Objects;

public abstract class Ingrediente {

	private String nome;

	public Ingrediente(String nome) {
		this.nome = nome;
	}
	
	public abstract double calcolaCostoIntrinseco();
	
	public abstract void cambiaCostoPerNome(String nome, double incrementoPercentuale);
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public abstract void accept(IngredienteVisitor visitor);
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(nome, other.nome);
	}

	public String toString() {
		return this.getClass()
					.getSimpleName()
					+": "+this.getNome();
	}


}