package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class PreparaScontrinoIntestazione extends PreparaScontrinoDecorator {

	private final String intestazione;
	
	public PreparaScontrinoIntestazione(PreparaScontrino scontrinoPreparato, String intestazione) {
		super(scontrinoPreparato);
		this.intestazione = intestazione;
	}
	
	@Override
	public void prepara(ScontrinoIngredienti scontrino) {
		scontrino.aggiungiInTesta(intestazione);
		super.prepara(scontrino);
	}

}
