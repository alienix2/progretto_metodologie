package progetto.mp.monicolini.matteo.puntocaldo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;


public class IngredienteBaseTest {
	
	@Test
	public void testIngredienteBaseToString() {
		Ingrediente ingrediente = new IngredienteBase("Ingrediente", 0.50);
		assertThat(ingrediente.toString())
			.isEqualTo("IngredienteBase: Ingrediente");
	}
	
	@Test
	public void testIngredienteBaseEquals() {
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 0.50);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente1", 0.50);
		Ingrediente ingrediente3 = new IngredienteBase("Ingrediente3", 0.50);
		Ingrediente ingrediente4 = new IngredienteBase("Ingrediente1", 0.20);
		Ingrediente ingrediente5 = new IngredienteBase("Ingrediente5", 0.10);
		assertThat(ingrediente1.equals(ingrediente2)).isTrue();
		assertThat(ingrediente1.equals(ingrediente3)).isFalse();
		assertThat(ingrediente1.equals(ingrediente4)).isFalse();
		assertThat(ingrediente1.equals(ingrediente5)).isFalse();
	}
	
	@Test
	public void testIngredienteBaseHashCode() {
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 0.50);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente1", 0.50);
		Ingrediente ingrediente3 = new IngredienteBase("Ingrediente3", 0.50);
		Ingrediente ingrediente4 = new IngredienteBase("Ingrediente1", 0.20);
		Ingrediente ingrediente5 = new IngredienteBase("Ingrediente5", 0.10);
		assertThat(ingrediente1.hashCode()).isEqualTo(ingrediente2.hashCode());
		assertThat(ingrediente1.hashCode()).isNotEqualTo(ingrediente3.hashCode());
		assertThat(ingrediente1.hashCode()).isNotEqualTo(ingrediente4.hashCode());
		assertThat(ingrediente1.hashCode()).isNotEqualTo(ingrediente5.hashCode());
	}
	
	@Test
	public void testIngredienteBaseIncrementaCostoPerNome() {
		Ingrediente daIncrementare1 = new IngredienteBase("SÏIncremento", 1);
		Ingrediente daIncrementare2 = new IngredienteBase("SÏIncremento", 1);
		Ingrediente noIncremento = new IngredienteBase("NoIncremento", 1);
		daIncrementare1.cambiaCostoPerNome("SÏIncremento", 100);
		daIncrementare2.cambiaCostoPerNome("SÏ", 100);
		noIncremento.cambiaCostoPerNome("SÏIncremento", 100);
		noIncremento.cambiaCostoPerNome("StringaDiversa", 100);
		assertThat(daIncrementare1.calcolaCostoIntrinseco()).isEqualTo(2);
		assertThat(daIncrementare2.calcolaCostoIntrinseco()).isEqualTo(2);
		assertThat(noIncremento.calcolaCostoIntrinseco()).isEqualTo(1);
	}
}
