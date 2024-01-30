package progetto.mp.monicolini.matteo.utils;

import progetto.mp.monicolini.matteo.puntocaldo.ProfitStrategy;

public class ProfittoNullo implements ProfitStrategy{

	@Override
	public double aggiungiProfitto(double costoIntrinseco) {
		return Math.round(costoIntrinseco*100)/100.0;
	}

}
