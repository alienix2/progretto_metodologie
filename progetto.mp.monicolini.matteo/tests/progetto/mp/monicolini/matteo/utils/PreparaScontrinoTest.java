package progetto.mp.monicolini.matteo.utils;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class PreparaScontrinoTest {

	private ScontrinoIngredienti scontrino;
	private Date data;
	Clock orologio;
	
	@Before
	public void setup() {
		orologio = Clock.fixed(Instant.parse("2022-02-05T09:30:00.00Z"), ZoneId.of("Europe/Rome"));
		data = new Date(orologio.millis());
		scontrino = new MockCreaScontrino();
		scontrino.aggiungiInCoda("Ingredienti scontrino\n");
	}
	
	@Test
	public void preparaScontrinoTest() {
		PreparaScontrinoData scontrinoData = new PreparaScontrinoData(data);
		scontrinoData.prepara(scontrino);
		assertThat(scontrino.toString())
			.isEqualTo("Ingredienti scontrino\n\n"
					+ data.toString()
					+"\n");
	}
	

	@Test
	public void preparaScontrinoIntestazioneTest() {
		PreparaScontrino scontrinoIntestazione 
			= new PreparaScontrinoIntestazione(new PreparaScontrinoData(data), "Intestazione");
		scontrinoIntestazione.prepara(scontrino);
		assertThat(scontrino.toString())
			.isEqualTo("Intestazione\n"
					+ "Ingredienti scontrino\n\n"
					+ data.toString()
					+"\n");
	}
	
	@Test
	public void preparaScontrinoieDiPagina() {
		PreparaScontrino scontrinoPieDiPagina =
				new PreparaScontrinoPieDiPagina(new PreparaScontrinoData(data), "Pie di pagina");
		scontrinoPieDiPagina.prepara(scontrino);
		assertThat(scontrino.toString())
			.isEqualTo("Ingredienti scontrino\n\n"
					+ "Pie di pagina\n"
					+ data.toString()
					+ "\n");
	}
	
	@Test
	public void stampaScontrinoIntestazionePieDiPagina() {
		PreparaScontrino scontrinoPieDiPaginaIntestazione = 
				new PreparaScontrinoIntestazione(
					new PreparaScontrinoPieDiPagina(
							new PreparaScontrinoData(data), "Pie di pagina"), "Intestazione");
		scontrinoPieDiPaginaIntestazione.prepara(scontrino);
		assertThat(scontrino.toString())
			.isEqualTo("Intestazione\n"
					+ "Ingredienti scontrino\n\n"
					+ "Pie di pagina\n"
					+ data.toString()
					+ "\n");
	}

}
