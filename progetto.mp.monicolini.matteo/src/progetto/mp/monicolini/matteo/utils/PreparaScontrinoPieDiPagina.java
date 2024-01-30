package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class PreparaScontrinoPieDiPagina  extends PreparaScontrinoDecorator {

	private final String pieDiPagina;
	
	public PreparaScontrinoPieDiPagina(PreparaScontrino scontrinoPreparato, String pieDiPagina) {
		super(scontrinoPreparato);
		this.pieDiPagina = pieDiPagina;
	}
	
	@Override
	public void prepara(ScontrinoIngredienti scontrino) {
		scontrino.aggiungiInCoda(pieDiPagina);
		super.prepara(scontrino);
	}

}
