package progetto.mp.monicolini.matteo.utils;

import java.util.Date;

import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class PreparaScontrinoData implements PreparaScontrino {
	
	Date data;
	
	public PreparaScontrinoData(Date data) {
		this.data = data;
	}
	
	@Override
	public void prepara(ScontrinoIngredienti scontrino) {
		scontrino.aggiungiInCoda(data.toString());
	}

}
