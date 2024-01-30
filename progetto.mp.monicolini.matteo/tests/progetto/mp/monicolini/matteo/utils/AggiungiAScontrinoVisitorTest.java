package progetto.mp.monicolini.matteo.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import progetto.mp.monicolini.matteo.puntocaldo.Calcolatrice;
import progetto.mp.monicolini.matteo.puntocaldo.Ingrediente;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteBase;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteLavorato;
import progetto.mp.monicolini.matteo.puntocaldo.IngredienteVisitor;
import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class AggiungiAScontrinoVisitorTest {

	private Calcolatrice calcolatrice;
	private IngredienteVisitor visitor;
	private ScontrinoIngredienti scontrino;
	
	@Before
	public void setup() {
		calcolatrice = new Calcolatrice(new ProfittoNullo());
		scontrino = new MockCreaScontrino();
		visitor = new IngredienteAggiungiAScontrinoVisitor(calcolatrice, scontrino);
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
		.isEqualTo("Lavorato: 1.0 euro|\n"
					+"Ingrediente1: 1.0 euro\n"
					+"_\n");
	}

	@Test
	public void testVisitIngredienteLavoratoAnnidato() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		IngredienteLavorato annidato = new IngredienteLavorato("Annidato");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 1);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1.50);
		lavorato.aggiungiIngrediente(annidato);
		lavorato.aggiungiIngrediente(ingrediente1);
		annidato.aggiungiIngrediente(ingrediente2);
		lavorato.accept(visitor);
		assertThat(scontrino.toString())
		.isEqualTo("Lavorato: 2.5 euro|\n"
					+"Annidato: 1.5 euro|\n"
					+"Ingrediente2: 1.5 euro\n"
					+"_\n"
					+"Ingrediente1: 1.0 euro\n"
					+"_\n");
	}

}
