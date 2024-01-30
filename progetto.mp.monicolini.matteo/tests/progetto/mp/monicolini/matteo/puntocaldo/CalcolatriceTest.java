package progetto.mp.monicolini.matteo.puntocaldo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import progetto.mp.monicolini.matteo.utils.ProfittoPercentuale;
import progetto.mp.monicolini.matteo.utils.ProfittoManoOpera;
import progetto.mp.monicolini.matteo.utils.ProfittoNullo;

public class CalcolatriceTest {
	private Calcolatrice calcolatrice;
	private Ingrediente ingrediente;
	
	@Before
	public void setup() {
		calcolatrice = new Calcolatrice(new ProfittoNullo());
		ingrediente = new IngredienteBase("ingrediente",1.5);
	}
	
	@Test
	public void testProfittoNulloIngredienteLavoratoCostoNullo() {
		IngredienteLavorato lavorato = new IngredienteLavorato("lavorato");
		calcolatrice.setProfitStrategy(new ProfittoNullo());
		assertThat(calcolatrice.prezzoFinale(lavorato)).isEqualTo(0.0);
		calcolatrice.setProfitStrategy(new ProfittoPercentuale(200));
		assertThat(calcolatrice.prezzoFinale(lavorato)).isEqualTo(0.0);
		calcolatrice.setProfitStrategy(new ProfittoManoOpera(2,100));
		assertThat(calcolatrice.prezzoFinale(lavorato)).isEqualTo(0.0);
	}
	
	@Test
	public void testProfittoNulloIngredienteBase() {
		calcolatrice.setProfitStrategy(new ProfittoNullo());
		assertThat(calcolatrice.prezzoFinale(ingrediente)).isEqualTo(1.5);
	}
	
	@Test
	public void testProfittoPercentuale() {
		calcolatrice.setProfitStrategy(new ProfittoPercentuale(200));
		assertThat(calcolatrice.prezzoFinale(ingrediente)).isEqualTo(4.5);
	}
	
	@Test
	public void testProfittoPercentualeArrotonndato() {
		calcolatrice.setProfitStrategy(new ProfittoPercentuale(100.506));
		assertThat(calcolatrice.prezzoFinale(ingrediente)).isEqualTo(3.01);
	}
	
	@Test
	public void testProfittoManoOpera() {
		calcolatrice.setProfitStrategy(new ProfittoManoOpera(2,100));
		assertThat(calcolatrice.prezzoFinale(ingrediente)).isEqualTo(4.5);
	}
	
	@Test
	public void testProfittoManoOperaArrotondato() {
		calcolatrice.setProfitStrategy(new ProfittoManoOpera(2,50.253));
		assertThat(calcolatrice.prezzoFinale(ingrediente)).isEqualTo(3.01);
	}
	
}
