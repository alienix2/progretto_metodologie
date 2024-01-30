package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.ScontrinoIngredienti;

public class MockCreaScontrino implements ScontrinoIngredienti{
	
	private StringBuilder builder = new StringBuilder();
	
	@Override
	public void aggiungiInCoda(String aggiunta) {
		builder.append(aggiunta + "\n");
	}
	
	@Override
	public void aggiungiInTesta(String aggiunta) {
		builder.insert(0, aggiunta + "\n");
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}
	
}
