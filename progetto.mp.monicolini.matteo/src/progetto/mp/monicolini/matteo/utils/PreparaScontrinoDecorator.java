package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public abstract class PreparaScontrinoDecorator implements PreparaScontrino {
	
	private PreparaScontrino scontrinoPreparato;
	
	public PreparaScontrinoDecorator (PreparaScontrino scontrinoPreparato) {
		this.scontrinoPreparato = scontrinoPreparato;
	}

	@Override
	public void prepara(ScontrinoIngredienti scontrino) {
		scontrinoPreparato.prepara(scontrino);
	}

}
