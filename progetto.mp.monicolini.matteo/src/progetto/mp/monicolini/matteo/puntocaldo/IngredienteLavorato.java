package progetto.mp.monicolini.matteo.puntocaldo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class IngredienteLavorato extends Ingrediente {

	private double costoProduzione = 0;
	private Collection<Ingrediente> mix = new ArrayList<>();
	
	public IngredienteLavorato(String nome) {
		super(nome);
	}
	
	public IngredienteLavorato(String nome, double costoProduzione) {
		super(nome);
		this.costoProduzione = costoProduzione;
	}
	
	public void aggiungiIngrediente(Ingrediente ingrediente) {
		mix.add(ingrediente);
	}
	
	public void rimuoviIngrediente(Ingrediente ingrediente) {
		mix.remove(ingrediente);
	}
	
	@Override
	public double calcolaCostoIntrinseco() {
		double costoTemp = 0;
		Iterator<Ingrediente> iteraIngredienti = this.iterator();
		while(iteraIngredienti.hasNext()) costoTemp += iteraIngredienti.next().calcolaCostoIntrinseco();
		return costoTemp + costoProduzione;
	}
	
	@Override
	public void cambiaCostoPerNome(String nome, double incrementoPercentuale) {
		mix.forEach(x -> x.cambiaCostoPerNome(nome, incrementoPercentuale));
	}
	
	public Iterator<Ingrediente> iterator() {
        return mix.iterator();
    }
	
	public void setCostoProduzione(double costoProduzione) {
		this.costoProduzione = costoProduzione;
	}
	
	public double getCostoProduzione() {
		return costoProduzione;
	}

	@Override
	public void accept(IngredienteVisitor visitor) {
		visitor.visitIngredienteLavorato(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mix);
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
		IngredienteLavorato other = (IngredienteLavorato) obj;
		return Objects.equals(mix, other.mix);
	}

	@Override
	public String toString() {
		return super.toString()+" "+mix.toString();
	}

	Collection<Ingrediente> getMix(){
		return mix;
	}
}
