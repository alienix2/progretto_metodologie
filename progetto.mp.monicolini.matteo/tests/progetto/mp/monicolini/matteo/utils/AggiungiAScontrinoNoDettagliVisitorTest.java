package progetto.mp.monicolini.matteo.utils;

import org.junit.Before;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import progetto.mp.monicolini.matteo.puntocaldo.*;

public class AggiungiAScontrinoNoDettagliVisitorTest {

	private Calcolatrice calcolatrice;
	private IngredienteVisitor visitor;
	private ScontrinoIngredienti scontrino;
	
	@Before
	public void setup() {
		calcolatrice = new Calcolatrice(new ProfittoNullo());
		scontrino = new MockCreaScontrino();
		visitor = new IngredienteAggiungiAScontrinoNoDettagliVisitor(calcolatrice, scontrino);
	}
	
	@Test
	public void testVisitIngredienteBase() {
		Ingrediente ingrediente = new IngredienteBase("Ingrediente", 1);
		ingrediente.accept(visitor);
		assertThat(scontrino.toString())
			.isEqualTo("Ingrediente: 1.0 euro\n");
	}
	
	@Test
	public void testVisitIngredienteBaseMultipleAggiunte() {
		Ingrediente ingrediente = new IngredienteBase("Ingrediente1", 1);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1);
		ingrediente.accept(visitor);
		ingrediente2.accept(visitor);
		assertThat(scontrino.toString())
			.isEqualTo("Ingrediente1: 1.0 euro\n"
						+"Ingrediente2: 1.0 euro\n");
	}
	
	@Test
	public void testVisitIngredienteLavorato() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 1);
		lavorato.aggiungiIngrediente(ingrediente1);
		lavorato.accept(visitor);
		assertThat(scontrino.toString())
			.isEqualTo("Lavorato: 1.0 euro\n");
	}
	
	@Test
	public void testVisitIngredienteLavoratoAnnidato() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		IngredienteLavorato annidato = new IngredienteLavorato("Annidato");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 1);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1);
		annidato.aggiungiIngrediente(ingrediente2);
		lavorato.aggiungiIngrediente(annidato);
		lavorato.aggiungiIngrediente(ingrediente1);
		lavorato.accept(visitor);
		assertThat(scontrino.toString())
			.isEqualTo("Lavorato: 2.0 euro\n");
	}

}
