package progetto.mp.monicolini.matteo.utils;

import java.util.Iterator;

import progetto.mp.monicolini.matteo.puntocaldo.Calcolatrice;
import progetto.mp.monicolini.matteo.puntocaldo.Ingrediente;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteBase;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteLavorato;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteVisitor;
import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class IngredienteAggiungiAScontrinoVisitor implements IngredienteVisitor {

	private final Calcolatrice calcolatrice;
	private final ScontrinoIngredienti scontrino;
	
	IngredienteAggiungiAScontrinoVisitor(Calcolatrice calcolatrice, ScontrinoIngredienti scontrino) {
		this.calcolatrice = calcolatrice;
		this.scontrino = scontrino;
	}
	
	@Override
	public void visitIngredienteBase(IngredienteBase ingrediente) {
		scontrino.aggiungiInCoda(ingrediente.getNome() 
					+": "
					+calcolatrice.prezzoFinale(ingrediente)
					+" euro");
	}

	@Override
	public void visitIngredienteLavorato(IngredienteLavorato lavorato) {
		Iterator<Ingrediente> iteraIngredienti = lavorato.iterator();
		scontrino.aggiungiInCoda(lavorato.getNome()
				+": "
				+calcolatrice.prezzoFinale(lavorato)
				+" euro"
				+"|");
		while(iteraIngredienti.hasNext()) {
			iteraIngredienti.next().accept(this);
		}
		scontrino.aggiungiInCoda("_");
	}
			
}
