package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.Calcolatrice;
import progetto.mp.monicolini.matteo.puntocaldo.Ingrediente;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteBase;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteLavorato;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteVisitor;
import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class IngredienteAggiungiAScontrinoNoDettagliVisitor implements IngredienteVisitor {

	private final Calcolatrice calcolatrice;
	private final ScontrinoIngredienti scontrino;
	
	IngredienteAggiungiAScontrinoNoDettagliVisitor(Calcolatrice calcolatrice, ScontrinoIngredienti scontrino) {
		this.calcolatrice = calcolatrice;
		this.scontrino = scontrino;
	}
	
	@Override
	public void visitIngredienteBase(IngredienteBase ingrediente) {
		commonVisit(ingrediente);
	}

	@Override
	public void visitIngredienteLavorato(IngredienteLavorato lavorato) {
		commonVisit(lavorato);
	}
	
	public void commonVisit(Ingrediente ingrediente) {
		scontrino.aggiungiInCoda(ingrediente.getNome()
				+": "
				+calcolatrice.prezzoFinale(ingrediente)
				+" euro");
	}

}
