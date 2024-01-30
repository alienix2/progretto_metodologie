package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.ProfitStrategy;

public class ProfittoPercentuale implements ProfitStrategy{

	private double percentuale;
	
	public ProfittoPercentuale(double percentuale) {
		this.percentuale = percentuale;
	}
	
	@Override
	public double aggiungiProfitto(double costoIntrinseco) {
		return Math.round((costoIntrinseco *(1 + (percentuale/100))*100))/100.0;
	}

}
