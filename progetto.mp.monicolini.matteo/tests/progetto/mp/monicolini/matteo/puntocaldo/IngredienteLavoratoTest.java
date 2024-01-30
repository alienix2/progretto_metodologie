package progetto.mp.monicolini.matteo.puntocaldo;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;
import java.util.Arrays;
import org.junit.Test;

public class IngredienteLavoratoTest {
	
	@Test
	public void testIngredienteLavoratoCalcolaCostointrinsecoNullo() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		assertThat(lavorato.calcolaCostoIntrinseco()).isEqualTo(0);
	}
	
	@Test
	public void testIngredienteLavoratoCalcolaCostointrinsecoCostoProduzioneVuoto() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato",1);
		assertThat(lavorato.calcolaCostoIntrinseco()).isEqualTo(1);
	}
	
	@Test
	public void testIngredienteLavoratoCalcolaCostoIntrinseco() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		IngredienteLavorato annidato = new IngredienteLavorato("Annidato");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 1);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1.50);
		lavorato.getMix().addAll(Arrays.asList(ingrediente1, annidato));
		annidato.getMix().add(ingrediente2);
		assertThat(lavorato.calcolaCostoIntrinseco()).isEqualTo(2.5);
		annidato.getMix().remove(ingrediente2);
		assertThat(lavorato.calcolaCostoIntrinseco()).isEqualTo(1);
	}
	
	@Test
	public void testIngredienteLavoratoCalcolaCostointrinsecoCostoProduzione() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato",1);
		IngredienteLavorato annidato = new IngredienteLavorato("Annidato",1.50);
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 1);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1.50);
		lavorato.getMix().addAll(Arrays.asList(ingrediente1, annidato));
		annidato.getMix().add(ingrediente2);
		assertThat(lavorato.calcolaCostoIntrinseco()).isEqualTo(5);
		annidato.getMix().remove(ingrediente2);
		assertThat(lavorato.calcolaCostoIntrinseco()).isEqualTo(3.5);
	}
	
	@Test
	public void testIngredienteLavoratoAggiungiIngrediente() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		Ingrediente ingrediente = new IngredienteBase("Ingrediente", 0.50);
		lavorato.aggiungiIngrediente(ingrediente);
		Collection<Ingrediente> mix = lavorato.getMix();
		assertThat(1).isEqualTo(mix.size());
		assertThat(ingrediente).isIn(mix);
	}
	
	@Test
	public void testIngredienteLavoratoRimuoviIngrediente() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrdiente1", 0.50);
		Ingrediente daRimuovere = new IngredienteBase("Ingrediente2", 1);
		Collection<Ingrediente> mix = lavorato.getMix();
		mix.addAll(Arrays.asList(ingrediente1,daRimuovere));
		lavorato.rimuoviIngrediente(daRimuovere);
		assertThat(1).isEqualTo(mix.size());
	}
	
	@Test
	public void testIngredienteLavoratoToString() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 0.50);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1);
		Collection<Ingrediente> mix = lavorato.getMix();
		mix.addAll(Arrays.asList(ingrediente1,ingrediente2));
		assertThat(lavorato.toString())
			.isEqualTo(
					"IngredienteLavorato: Lavorato "
							+"[IngredienteBase: Ingrediente1, "
							+"IngredienteBase: Ingrediente2]");
	}
	
	@Test
	public void testIngredienteLavoratoNidificatoToString() {
		IngredienteLavorato lavorato = new IngredienteLavorato("Lavorato");
		IngredienteLavorato nidificato = new IngredienteLavorato("Nidificato");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 0.50);
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1);
		nidificato.getMix().add(ingrediente2);
		lavorato.getMix().addAll(Arrays.asList(ingrediente1, nidificato));
		assertThat(lavorato.toString())
			.isEqualTo(
					"IngredienteLavorato: Lavorato "
							+"[IngredienteBase: Ingrediente1, "
							+"IngredienteLavorato: Nidificato "+
								"[IngredienteBase: Ingrediente2]]");
	}
	
	@Test
	public void testIngredienteLavoratoEquals() {
		IngredienteLavorato lavorato1 = new IngredienteLavorato("Lavorato1");
		IngredienteLavorato lavorato2 = new IngredienteLavorato("Lavorato1");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 0.50);
		lavorato1.getMix().add(ingrediente1);
		lavorato2.getMix().add(ingrediente1);
		assertThat(lavorato1.equals(lavorato2)).isTrue();
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1);
		lavorato2.getMix().add(ingrediente2);
		assertThat(lavorato1.equals(lavorato2)).isFalse();
	}
	
	@Test
	public void testIngredienteLavoratoHashCode() {
		IngredienteLavorato lavorato1 = new IngredienteLavorato("Lavorato1");
		IngredienteLavorato lavorato2 = new IngredienteLavorato("Lavorato1");
		Ingrediente ingrediente1 = new IngredienteBase("Ingrediente1", 0.50);
		lavorato1.getMix().add(ingrediente1);
		lavorato2.getMix().add(ingrediente1);
		assertThat(lavorato1.hashCode()).isEqualTo(lavorato2.hashCode());
		Ingrediente ingrediente2 = new IngredienteBase("Ingrediente2", 1);
		lavorato2.getMix().add(ingrediente2);
		assertThat(lavorato1.hashCode()).isNotEqualTo(lavorato2.hashCode());
	}
	
	@Test
	public void testIngredienteLavoratoCambiaCostoPerNome() {
		IngredienteLavorato lavorato = new IngredienteLavorato("SÏIncremento");
		IngredienteLavorato nidificato = new IngredienteLavorato("NoIncremento");
		IngredienteBase ingrediente1 = new IngredienteBase("SÏIncremento",1);
		IngredienteBase ingrediente2 = new IngredienteBase("NoIncremento",1);
		IngredienteBase ingrediente3 = new IngredienteBase("SÏIncremento",1);
		nidificato.getMix().addAll(Arrays.asList(ingrediente2, ingrediente3));
		lavorato.getMix().addAll(Arrays.asList(ingrediente1, nidificato));
		lavorato.cambiaCostoPerNome("SÏ", 100);
		assertThat(ingrediente1.calcolaCostoIntrinseco()).isEqualTo(2);
		assertThat(ingrediente2.calcolaCostoIntrinseco()).isEqualTo(1);
		assertThat(ingrediente3.calcolaCostoIntrinseco()).isEqualTo(2);
		
	}

}
